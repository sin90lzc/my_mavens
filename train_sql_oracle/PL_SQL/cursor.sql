/*这里展示了游标CURSOR的使用*/

/*游标指的是从数据库中查询出来的数据以临时表的形式存放在内存中，游标可以对存储在内存中的数据进行操作*/

/*游标的基本操作有：声明游标、打开游标、提取游标、关闭游标*/
set serveroutput on
DECLARE
/*声明游标*/
CURSOR emp_cursor IS SELECT * FROM EMP;

/*声明参数化游标*/
CURSOR ename_cursor(en emp.ename%TYPE) IS SELECT ename FROM EMP WHERE ename=en;

/*声明可更新可删除的游标*/
CURSOR sal_cursor IS SELECT sal FROM emp FOR UPDATE;

/*声明游标变量类型*/
TYPE emp_cursor_type IS REF CURSOR RETURN emp%ROWTYPE;--RETURN子句可以省略，它表示每一行CURSOR的数据类型
v_emp_cursor emp_cursor_type;--定义游标变量


v_emp emp%ROWTYPE;
v_ename emp.ename%TYPE;
v_sal emp.sal%TYPE;
BEGIN
  dbms_output.put_line('------------------游标基本使用------------------');
  /*打开游标*/
  OPEN emp_cursor;
  LOOP
  /*提取游标*/
    FETCH emp_cursor INTO v_emp;--每次提取一行记录
  EXIT WHEN emp_cursor%NOTFOUND;--NOTFOUND属性表示一行记录都没有找到时，退出循环
    IF emp_cursor%ROWCOUNT=3 THEN--ROWCOUNT属性用于返回到目前为止已经提取的实际行数。这里表示提取到第三行数据时为真。
    dbms_output.put_line(v_emp.ename);
    END IF;
  END LOOP;
  
  IF emp_cursor%ISOPEN THEN--ISOPEN属性表示CURSOR是否是打开状态。
  /*关闭游标*/
  CLOSE emp_cursor;
  END IF;
  
  dbms_output.put_line('------------------参数化游标的使用------------------');
  OPEN ename_cursor('ALLEN');
  FETCH ename_cursor INTO v_ename;
  dbms_output.put_line(v_ename);
  IF ename_cursor%ISOPEN THEN
  CLOSE ename_cursor;
  END IF;
  
  dbms_output.put_line('------------------隐式游标的使用------------------'); 
  /*PL/SQL在执行一个SQL语句或DML语句时，oracle会自动创建一个隐式游标，其名称固定为SQL。隐式游标无须声明和打开，使用完后也不用关闭，这些操作由系统自动维护*/
  SELECT * INTO v_emp FROM EMP WHERE rownum<=1;
  --FETCH SQL INTO v_emp;
  IF SQL%NOTFOUND THEN
  dbms_output.put_line('没有找到记录');
  END IF;
  UPDATE emp SET sal=1000 WHERE rownum<=1;
  IF SQL%FOUND THEN
  dbms_output.put_line('已经更新数据');
  END IF;
  
  dbms_output.put_line('------------------使用游标更新或删除数据------------------');
  /*如果要通过游标更新或删除数据，在定义游标时必须带有FOR UPDATE子句，而且为了更新或删除当前游标行数据，还需要在UPDATE或DELETE子句引用WHERE CURRENT OF子句*/
  OPEN sal_cursor;
  LOOP
    FETCH sal_cursor INTO v_sal;
  EXIT WHEN sal_cursor%NOTFOUND;
    IF sal_cursor%ROWCOUNT=4 THEN
    UPDATE emp SET sal=v_sal WHERE CURRENT OF sal_cursor;--通过cursor更新数据
    ELSIF sal_cursor%ROWCOUNT=5 THEN
    DELETE emp WHERE CURRENT OF sal_cursor;--通过cursor删除数据
    END IF;
  END LOOP;
  EXECUTE IMMEDIATE 'rollback';--回滚，恢复数据
  dbms_output.put_line('成功通过游标更新或删除数据，回滚并恢复数据');
  
  dbms_output.put_line('------------------使用游标FOR循环------------------');
  /*当使用游标FOR循环时，ORACLE会隐含地打开游标、提取游标数据并关闭游标*/
  FOR v_cursor IN emp_cursor LOOP
    IF v_cursor.ename='KING' THEN
    dbms_output.put_line(v_cursor.ename);
    END IF;
  END LOOP;
  
  FOR v_cursor IN (SELECT * FROM emp) LOOP --直接使用子查询方式使用FOR循环
    IF v_cursor.ename='KING' THEN
    dbms_output.put_line(v_cursor.ename);
    END IF;
  END LOOP;
  
  dbms_output.put_line('------------------游标变量（动态游标）------------------');
  OPEN v_emp_cursor FOR SELECT * FROM emp;--使用OPEN FOR语句打开游标变量
  LOOP
    FETCH v_emp_cursor INTO v_emp;
  EXIT WHEN v_emp_cursor%NOTFOUND;
      IF v_emp_cursor%ROWCOUNT=10 THEN
        dbms_output.put_line(v_emp.ename);
      END IF;
  END LOOP;
END;
/