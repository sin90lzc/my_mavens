/*这里展示了自定义异常的用法*/

/*自定义异常语法*/
/*
  exception_name EXCEPTION;
  PRAGMA EXCEPTION_INTO(exception_name,exception_no);
  
  使用RAISE exception_name抛出异常
*/
set serveroutput on
DECLARE
  e_no_employee EXCEPTION;
  --PRAGMA EXCEPTION_INTO(e_no_employee,-2291);不知道为什么不能为异常设定编号和异常消息
BEGIN
  UPDATE emp set ename='tim' WHERE empno=111111;
  IF SQL%NOTFOUND THEN
    RAISE e_no_employee;
  END IF;
EXCEPTION
  WHEN e_no_employee THEN
    dbms_output.put_line('该员工不存在');
    dbms_output.put_line('错误号：'||SQLCODE);--SQLCODE返回异常编号
    dbms_output.put_line(SQLERRM);--SQLERRM返回异常消息
END;