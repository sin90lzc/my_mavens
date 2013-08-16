/*这里展示了如何定义多行单列或多行多列的集合变量，但是如果要用到多行多列，最好还是使用Cursor*/
set serveroutput on
DECLARE
/*
自定义索引表类型，索引表的元素个数没有限制，并且下标可以为负值或字符串
其语法是：
TYPE type_name IS TABLE OF data_type [NOT NULL] INDEX BY key_type;
NOT NULL表示索引表中不允许有NULL元素。
key_type可以是BINARY_INTEGER,PLS_INTEGER,VARCHAR2三者之一
*/
TYPE ename_table_type IS TABLE OF emp.ename%TYPE
NOT NULL INDEX BY BINARY_INTEGER;

/*自定义一个以字符串为索引的索引表*/
TYPE area_table_type IS TABLE OF NUMBER INDEX BY VARCHAR2(20);

/*自定义一个多行多列的索引表*/
TYPE emp_table_type IS TABLE OF emp%ROWTYPE INDEX BY PLS_INTEGER;

/*
自定义嵌套表，嵌套表的元素下标从1开始，并且元素个数没有限制，而且元素是无序的。
其语法是：
TYPE type_name IS TABLE OF data_type;
注意：嵌套表在使用前必须使用它的构造方法初始化。
*/
TYPE sal_table_type IS TABLE OF emp.sal%TYPE;

/*
自定义变长数组，元素下标从1开始，并且元素的最大个数是有限制的。
其语法是：
TYPE type_name IS VARRAY(size_limit) OF data_type [NOT NULL];
注意：嵌套表在使用前必须使用它的构造方法初始化。
*/
TYPE empno_table_type IS VARRAY(4) OF emp.empno%TYPE;

ename_table ename_table_type;
area_table area_table_type;
emp_table emp_table_type;
sal_table sal_table_type;
v_sql VARCHAR2(200);
v_i INTEGER;
empno_table empno_table_type:=empno_table_type(1,1,1);--VARRAY类型必须在使用前初始化。

BEGIN
  SELECT ename INTO ename_table(1000) FROM (SELECT rownum r,ename FROM emp) where r>=1 and r<=1;--返回第一条数据
  SELECT ename INTO ename_table(-1000) FROM (SELECT rownum r,ename FROM emp) where r>=2 and r<=2;--返回第二条数据
  SELECT ename INTO ename_table(0) FROM (SELECT rownum r,ename FROM emp) where r>=3 and r<=3;--返回第三条数据
  dbms_output.put_line('返回的第一条数据的人名是：'||ename_table(1000));
  dbms_output.put_line('返回的第二条数据的人名是：'||ename_table(-1000));
  dbms_output.put_line('返回的第三条数据的人名是：'||ename_table(0));
  /*集合方法exists的使用*/
  IF ename_table.exists(1000) THEN
  dbms_output.put_line('ename_table存在索引为1000的元素：'||ename_table(1000));
  END IF;
  
  /*集合方法delete的使用，delete删除表中所有元素，delete(n)删除表中第n个元素,delete(n,m)删除表中n-m区间的元素，delete方法只适用于索引表或嵌套表*/
  dbms_output.put_line('enable_table''s size：'||ename_table.count);
  ename_table.delete(-1000);
  dbms_output.put_line('enable_table''s size：'||ename_table.count); 
   
  area_table('广州') :=1;
  area_table('北京') :=2;
  area_table('上海') :=3;
  dbms_output.put_line('第一个元素索引:'||area_table.first());--集合方法first的使用
  dbms_output.put_line('最后一个元素索引:'||area_table.last());--集合方法last的使用
  dbms_output.put_line('''北京''索引的下一个索引：'||area_table.next('北京'));--集合方法next的使用
  dbms_output.put_line('''北京''索引的上一个索引：'||area_table.prior('北京'));--集合方法prior的使用
  /*集合方法COUNT的使用,注意可以省略()*/
  IF area_table.count()=3 THEN
  dbms_output.put_line('area_table的元素个数为3');
  END IF;
  
  SELECT * INTO emp_table(-1) FROM emp where rownum<=1;
  SELECT * INTO emp_table(2) FROM emp where ename='ALLEN';
  dbms_output.put_line('emp_table(-1): '||emp_table(-1).ename);
  dbms_output.put_line('emp_table(2): '||emp_table(2).ename);
  dbms_output.put_line('--------------------------------------------');
  
  sal_table:=sal_table_type(1,1,1,1);--必须先初始化嵌套表类型，才可以使用
  SELECT sal INTO sal_table(2) FROM (SELECT rownum r,sal FROM emp) where r>=3 and r<=3;--返回第三条数据并保存到sal_table（2）中
  dbms_output.put_line('第三个人的工资: '||sal_table(2));

  /*嵌套表可以作为表中某个字段的数据类型，但必须指定嵌套表数据保存在哪个表上*/
  SELECT count(*) INTO v_i FROM USER_TYPES WHERE type_name='PHONE_TABLE_TYPE'; --查询是否存在自定义类型'PHONE_TABLE_TYPE'
  IF v_i!=1 THEN
  v_sql :='CREATE OR REPLACE TYPE phone_table_type IS TABLE OF VARCHAR2(20)'; --创建一个保存电话号码的嵌套表类型，那么它便可以作为表字段的类型了
  EXECUTE IMMEDIATE v_sql;--执行DDL
  END IF;
  SELECT count(*) INTO v_i FROM USER_TABLES WHERE table_name='CONTACT'; --查询是否存在表'CONTACT'
  IF v_i!=1 THEN
  v_sql :='CREATE TABLE CONTACT(id NUMBER(4) PRIMARY KEY,cname VARCHAR(20),phone phone_table_type) NESTED TABLE phone STORE AS phone_table';--创建带自定义嵌套表类型phone_table_type的表，并指定该类型的字段保存到表phone_table中。
  EXECUTE IMMEDIATE v_sql;--执行DDL
  END IF;
  SELECT max(id) INTO v_i FROM CONTACT;
  IF v_i IS NOT NULL THEN
  v_i:=v_i+1;
  ELSE v_i:=1;
  END IF;
  INSERT INTO CONTACT VALUES(v_i,'tim',phone_table_type('02028251491',13631360381));--向CONTACT表插入一条记录
  
  /*集合方法extend方法用于扩展集合变量的尺寸，并为它们增加元素,trim方法用于从集合尾部删除元素,这两个方法只适用于VARRAY和嵌套表类型*/
  sal_table:=sal_table_type(1,2,3);
  dbms_output.put_line('sal_table''s size:'||sal_table.count);
  sal_table.extend();--添加一个NULL元素
  sal_table.extend(2);--添加两个NULL元素
  dbms_output.put_line('sal_table''s size:'||sal_table.count);
  sal_table.extend(1,3);--添加一个元素，其值为sal_table(3);
  dbms_output.put_line('sal_table''s last value:'||sal_table(sal_table.count));
  sal_table.trim(6);--移除6个元素
  dbms_output.put_line('sal_table''s size:'||sal_table.count);
  
  
    dbms_output.put_line('--------------------------------------------');
  /*
  VARRAY类型的使用,VARRAY类型也可以作为表字段的类型，具体的使用与嵌套表类型一样，除了VARRAY类型的元素个数是有限制的。
  */
  SELECT empno INTO empno_table(3) FROM (SELECT ROWNUM r,empno FROM emp) WHERE r>=3 AND r<=3;
  dbms_output.put_line('VARRAY测试一：'||empno_table(3));
  /*集合方法limit的使用，注意由于索引表与嵌套表的元素个数是没有限制的，因此会返回NULL*/
  IF empno_table.limit=4 THEN
  dbms_output.put_line('empno_table可以放置的最多元素个数：'||empno_table.limit);
  END IF;
  

END;