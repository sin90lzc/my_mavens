/*这里展示了函数的使用*/

/*
函数的创建语法：
CREATE [OR REPLACE] FUNCTION function_name([parameter1 [IN|OUT|IN OUT] datatype[,...]]) RETURN datatype {IS|AS} function_body; 
*/

/*下面创建一个函数get_emp_record，它能根据员工的编号返回一条记录*/
set serveroutput on
CREATE OR REPLACE FUNCTION get_emp_record(eno IN emp.empno%TYPE) RETURN emp%ROWTYPE IS
v_emp emp%ROWTYPE;
BEGIN
  SELECT * INTO v_emp FROM emp WHERE empno=eno;
  RETURN v_emp;--返回值
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    raise_application_error(-20003,'该员工不存在');
END;
/

/*使用上面定义的函数*/
DECLARE
  v_emp emp%ROWTYPE;
BEGIN
  v_emp:=get_emp_record(eno=>7782);
  dbms_output.put_line(v_emp.empno||' '||v_emp.ename);
END;
/