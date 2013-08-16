set serveroutput on
DECLARE
i PLS_INTEGER:=100;
s PLS_INTEGER:=0;
BEGIN
  LOOP
  s:=s+i;
  i:=i-1;
  EXIT WHEN i=0;--当条件成立时退出循环
  END LOOP;
  dbms_output.put_line('first loop for s='||s);
  
  s:=0;
  i:=100;
  WHILE i>0 LOOP
  s:=s+i;
  i:=i-1;
  END LOOP;
  dbms_output.put_line('second loop for s='||s);
  
  s:=0;
  i:=100;
  FOR i IN REVERSE 0..100 LOOP--FOR循环只能用于数值型，带REVERSE是递减，不带REVERSE为递增
  s:=s+i;
  END LOOP;
  dbms_output.put_line('third loop for s='||s);
END;