create table users(id number primary key,name varchar2(20) unique,age number(3) check (age<150 and age>0);

create table Orders(id number primary key,order_date date,users_id references users(id));

create table Product(id number primary key,users_id number references users(id),name varchar(20),price number); 

create table order_item(product_id number references product(id),orders_id number references orders(id),constraint order_item_pk primary key(product_id,orders_id));

create sequence seq;
