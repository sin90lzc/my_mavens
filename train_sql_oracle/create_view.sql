/*
该视图显示用户发布商品的详情
*/
create or replace view v_userpublish as  select u.id user_id,u.name user_name,p.id product_id,p.name product_name,p.price price from users u left outer join product p on u.id=p.users_id;


/*
该视图显示每个用户的订单详情。
*/
create or replace view v_userorder as select user_id,user_name,p.name product_name,p.price price from (select oi.product_id oipid,user_name,user_id from ((select o.id oid,u.name user_name,u.id user_id from orders o join users u on u.id=o.users_id) join order_item oi on oi.orders_id=oid)) join product p on p.id=oipid order by user_id;


/*
上面的查询用户订单详情的SQL语句可以简化成
*/
create or replace view v_userorder as select u.id user_id,u.name user_name,p.name product_name,p.price price from users u,orders o,product p,order_item oi where u.id=o.users_id and o.id=oi.orders_id and oi.product_id=p.id order by u.id;
