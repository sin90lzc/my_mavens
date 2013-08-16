/*这里展示了存储过程的用法*/

/*创建存储过程的语法*/
/*
  CREATE [OR REPLACE] PROCEDURE procedure_name[(parameter_name [IN|OUT|IN OUT] datatype [,...])] {IS|AS} 
  BEGIN
  procedure_body
  END procedure_name;
*/

/*下面实例创建一个过程p_query_emp，该过程查询emp表，通过编号查询指定员工，并返回员工编号、员工姓名、员工薪资*/
set serveroutput on
CREATE OR REPLACE PROCEDURE p_query_emp(eno IN OUT emp.empno%TYPE,ename OUT emp.ename%TYPE,sal OUT emp.sal%TYPE) IS
BEGIN
  SELECT empno,ename,sal INTO eno,ename,sal FROM emp WHERE empno=eno;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RAISE_APPLICATION_ERROR(-20000,'该员工不存在！');
END;
/
var eno NUMBER;
var ename VARCHAR2;
var sal NUMBER;
EXECUTE :eno:=7499;
EXECUTE p_query_emp(:eno,:ename,:sal);
print eno ename sal;

DECLARE
v_eno emp.empno%TYPE:=7499;
v_ename emp.ename%TYPE;
v_sal emp.sal%TYPE;
BEGIN
  p_query_emp(v_eno,v_ename,v_sal); --在PL/SQL中调用存储过程
  dbms_output.put_line(v_eno||','||v_ename||','||v_sal);
END;
/