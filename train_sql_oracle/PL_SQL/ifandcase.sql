set serveroutput on
DECLARE
c_a CONSTANT CHAR(1) :='a';
c_b CONSTANT CHAR(1) :='b';
c_c CONSTANT CHAR(1) :='c';
v_ch CHAR(1);
v_result CHAR(1);
BEGIN
    v_ch:='c';
    IF v_ch='a' THEN
      dbms_output.put_line('choose a!');
    ELSIf v_ch='b' THEN
      dbms_output.put_line('choose b!');
    ELSIF v_ch='c' THEN
      dbms_output.put_line('choose c!');
    ELSE
      dbms_output.put_line('v_ch is '||v_ch);
    END IF;
    
    CASE v_ch
    WHEN 'a' THEN v_result:='a';
    WHEN 'b' THEN v_result:='b';
    WHEN 'c' THEN v_result:='c';
    ELSE v_result:=v_ch;
    END CASE;

    dbms_output.put_line('v_result is ' || v_result);
END;