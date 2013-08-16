/*
这里展示的是变量声明
*/
--必须set serveroutput on，否则没输出
set serveroutput on
DECLARE
c_size CONSTANT INTEGER:=10;--常量定义
v_char CHAR(4) :='abcd';--定义4字节的字符变量
v_num NUMBER(5) DEFAULT 100.0;--定义长度为5的数字
v_notnull BOOLEAN NOT NULL :=TRUE;--一个不能为空的布尔值变量
v_date DATE;--定义一个DATE变量，没有初始化
BEGIN
  --c_size:=11;不能给c_size赋值，因为它是一个常量
	dbms_output.put_line('c_size : '||c_size);
	dbms_output.put_line('v_char : '||v_char );
	dbms_output.put_line('v_num : '||v_num);
  
  v_notnull:=FALSE;
  IF NOT v_notnull THEN
  dbms_output.put_line('v_notnull : '||'false');--不能直接输出布尔值
  END IF;

  v_date:=to_date('1985-02-27','yyyy-mm-dd');
	dbms_output.put_line('v_date : '|| to_char(v_date,'yyyy-mm-dd'));
END;
/