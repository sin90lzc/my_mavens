/*
这里展示了如何定义单行多列的复合变量
*/
set serveroutput on
DECLARE
v_name emp.ename%TYPE;--%TYPE用于引用某个表的单列类型，能保存单行单列的值
v_employer emp%ROWTYPE;--%ROWTYPE用于引用某个表的单行记录类型，能保存单行多列的值

/*声明自定义的记录数据类型，它能保存单行多列的值*/
TYPE emp_record_type IS RECORD(
  eno emp.empno%TYPE NOT NULL:=0,
  ename emp.ename%TYPE,
  sal emp.sal%TYPE
);
emp_record emp_record_type;

BEGIN
  SELECT ename INTO v_name FROM emp WHERE ROWNUM <=1;
  dbms_output.put_line('first name from emp:'|| v_name);
  
  SELECT empno,ename INTO v_employer.empno,v_employer.ename FROM emp WHERE ROWNUM <=1;
  dbms_output.put_line(v_employer.ename||'''s no is '||v_employer.empno);
  
  SELECT * INTO v_employer FROM emp WHERE ROWNUM <=1;
  dbms_output.put_line(v_employer.ename||'''s no is '||v_employer.empno);
  
  SELECT empno,ename,sal INTO emp_record.eno,emp_record.ename,emp_record.sal FROM emp WHERE ROWNUM<=1;
  dbms_output.put_line(emp_record.eno||' '||emp_record.ename||'''s sal is '||emp_record.sal);
END;
/ --记得加上/来执行SQL脚本