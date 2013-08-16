/*这里展示了包的使用*/

/*包由包头（包规范）和包体两部分组成。包头和包体分别存储在不同的数据字典中。包头用于声明包中的公共变量，常量，过程，函数，而包体是包头声明的具体实现*/

/*现在要求这样的一个包emp_pack，该包包含最高工资和最低工资属性，能通过员工编号或员工姓名返回该员工工资的函数，插入新记录的过程，通过员工编号或员工姓名更新其工资的过程，删除某记录的过程*/

/*创建包头（包规范）*/
set serveroutput on
CREATE OR REPLACE PACKAGE emp_pack IS
  PROCEDURE add_emp(eno IN OUT emp.empno%TYPE,ename emp.ename%TYPE,esal emp.sal%TYPE,ejob emp.job%TYPE DEFAULT 'SALESMAN',emgr emp.mgr%TYPE DEFAULT 7566,ehire emp.hiredate%TYPE DEFAULT SYSDATE);
  FUNCTION get_sal(eno emp.empno%TYPE) RETURN emp.sal%TYPE;
  FUNCTION get_sal(e_name emp.ename%TYPE) RETURN emp.sal%TYPE;
  PROCEDURE update_sal(eno emp.empno%TYPE,esal emp.sal%TYPE);
  PROCEDURE update_sal(e_name emp.ename%TYPE,esal emp.sal%TYPE);
  PROCEDURE del_emp(eno IN OUT emp.empno%TYPE);
  PROCEDURE print_sal;
END emp_pack;
/
/*创建包体*/
CREATE OR REPLACE PACKAGE BODY emp_pack IS
  e_emp_update EXCEPTION;
  e_emp_delete EXCEPTION;
  max_sal emp.sal%TYPE;
  min_sal emp.sal%TYPE;
  /*插入记录过程*/
  PROCEDURE add_emp(eno IN OUT emp.empno%TYPE,ename emp.ename%TYPE,esal emp.sal%TYPE,ejob emp.job%TYPE DEFAULT 'SALESMAN',emgr emp.mgr%TYPE DEFAULT 7566,ehire emp.hiredate%TYPE DEFAULT SYSDATE) IS
  v_eno emp.empno%TYPE;
  BEGIN
    INSERT INTO emp(empno,ename,sal,job,mgr,hiredate) values(eno,ename,esal,ejob,emgr,ehire);
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      raise_application_error(-20004,'该员工编号已经存在，请另起一个编号');
  END add_emp;
  
  /*获取工资方法*/
  FUNCTION get_sal(eno emp.empno%TYPE) RETURN emp.sal%TYPE IS
    v_sal emp.sal%TYPE;
  BEGIN
    SELECT sal INTO v_sal FROM emp WHERE empno=eno;
    RETURN v_sal;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      raise_application_error(-20005,'该员工不存在!');
  END get_sal;
  
  FUNCTION get_sal(e_name emp.ename%TYPE) RETURN emp.sal%TYPE IS
    v_eno emp.empno%TYPE;
  BEGIN
    SELECT empno INTO v_eno FROM emp WHERE emp.ename=e_name;
    RETURN get_sal(v_eno);
  END get_sal;
  
  PROCEDURE update_sal(eno emp.empno%TYPE,esal emp.sal%TYPE) IS
  BEGIN
    UPDATE emp SET sal=esal WHERE empno=eno;
    IF SQL%NOTFOUND THEN
      RAISE e_emp_update;
    END IF;
  EXCEPTION 
    WHEN e_emp_update THEN
      dbms_output.put_line('没有找到编号为'||eno||'员工');
  END update_sal;
   
  PROCEDURE update_sal(e_name emp.ename%TYPE,esal emp.sal%TYPE) IS
    v_eno emp.empno%TYPE;
  BEGIN
    SELECT empno INTO v_eno FROM emp WHERE emp.ename=e_name;
    update_sal(v_eno,esal);
  EXCEPTION
    WHEN TOO_MANY_ROWS THEN
      raise_application_error(-20006,'有多个同名的员工,请用编号查询');
    WHEN NO_DATA_FOUND THEN
      raise_application_error(-20007,e_name||'员工不存在');
  END update_sal;
  
  PROCEDURE del_emp(eno IN OUT emp.empno%TYPE) IS
  BEGIN
    DELETE FROM emp WHERE empno=eno;
    IF SQL%NOTFOUND THEN
      RAISE e_emp_delete;
    END IF;
  EXCEPTION 
    WHEN e_emp_delete THEN
      dbms_output.put_line('找不到编号为'||eno||'的员工');
  END del_emp;
  
  PROCEDURE print_sal IS
  BEGIN
    dbms_output.put_line('max_sal:'||max_sal);
    dbms_output.put_line('min_sal:'||min_sal);
  END print_sal;
  
/*包构造过程*/
BEGIN
  SELECT MAX(sal),MIN(sal) INTO max_sal,min_sal FROM emp;
END emp_pack;