/*这里展示了PLSQL的异常处理*/

/*异常处理的一般语法*/
/*
  EXCEPTION
    WHEN exception1 THEN
      statements;
      ...
    WHEN exceptionN THEN
      statements;
    WHEN OTHERS THEN
      statements;
*/

/*五个常用系统预定义异常*/
/*
ACCESS_INTO_NULL:看本页实例
COLLECTION_IS_NULL:使用集合变量（嵌套表或VARRAY）前，没有初始化集合变量。
DUP_VAL_ON_INDEX:在唯一约束的列上插入重复值。
NO_DATA_FOUND:SELECT INTO未返回行或引用了索引表未初始化元素。
TOO_MANY_ROWS:SELECT INTO返回超过一行。
*/
set serveroutput on
DECLARE
/*obj_type类型创建语句是这样的：
create or replace
TYPE obj_type AS OBJECT(name varchar2(20),age INTEGER)
*/
obj obj_type;
--obj obj_type:=obj_type(NULL,NULL);改成这样便不会有异常,因为经过了初始化。
BEGIN
  obj.name:='Tim';
  EXCEPTION
    WHEN ACCESS_INTO_NULL THEN
      dbms_output.put_line('首先初始化对象obj');
END;
/