/*这里展示了触发器的使用*/

/*触发器在事件发生时被隐式触发,而且触发器不能接受参数,不能像过程一样显式调用*/

/*触发器主要有DML触发器,替代触发器,系统触发器及DDL触发器*/

/*触发器创建语法*/
/*
  CREATE [OR REPLACE] TRIGGER trigger_name {BEFORE | AFTER | INSTEAD OF} trigger_event ON {table_name | view_name} [FOR EACH ROW] BEGIN trigger_body END trigger_name;
*/

/*下面创建触发器emp_trigger,该触发器只针对SALESMAN,它可以禁止周六日改变表emp,如果是工作日,可以插入或更新的sal,但不能超过5000*/
CREATE OR REPLACE TRIGGER emp_trigger BEFORE INSERT OR UPDATE OF sal OR DELETE ON emp FOR EACH ROW WHEN (old.job='SALESMAN')
BEGIN
--  dbms_output.put_line(to_char(sysdate,'day'));
  IF to_char(sysdate,'day') IN ('saturday','sunday') THEN
    raise_application_error(-20022,'不能在休息日改变员工信息');
  ELSE
   IF (INSERTING OR UPDATING) AND :NEW.sal>5000 THEN --INSERTING,UPDATING,DELETING是条件谓语,指示现在的事件是否为INSERTE,UPDATE,DELETE.
--     dbms_output.put_line(:NEW.sal);
      :NEW.sal:=5000;
   END IF;
  END IF;
END emp_trigger;
/

/*下面创建一个针对视图的触发器(对于复杂视图是不可以直接执行INSERT,UPDATE,DELETE操作的)*/
CREATE OR REPLACE VIEW view_emp_dept AS SELECT d.deptno deptno,d.dname dname,e.empno empno,e.ename ename,e.sal FROM dept d,emp e WHERE d.deptno=e.deptno;
/
CREATE OR REPLACE TRIGGER view_trigger INSTEAD OF UPDATE ON view_emp_dept FOR EACH ROW
DECLARE
v_deptno dept.deptno%TYPE;
v_dname dept.dname%TYPE;
v_empno emp.empno%TYPE;
v_ename emp.ename%TYPE;
v_sal emp.sal%TYPE;
BEGIN
  v_deptno:=NVL(:new.deptno,:old.deptno);
  v_dname:=NVL(:new.dname,:old.dname);
  v_empno:=NVL(:new.empno,:old.empno);
  v_ename:=NVL(:new.ename,:old.ename);
  v_sal:=NVL(:new.sal,:old.sal);
  UPDATE dept SET deptno=v_deptno,dname=v_dname WHERE deptno=v_deptno;
  UPDATE emp SET empno=v_empno,ename=v_ename,sal=v_sal WHERE empno=v_empno;
END view_trigger;
