create database if not exists test;
use test;
drop table if exists dept;

--部门表
create table dept(
id int primary key,
name varchar(255),
comment varchar(255));

--部门表插入数据
insert into dept values(1,'srd','srd');