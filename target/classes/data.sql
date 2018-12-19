
insert into user_info (user_id, user_pw, user_name,user_type, enabled) values ('adm', '1', 'adm', 'ADM', 'Y');
insert into user_info (user_id, user_pw, user_name,user_type, enabled) values ('pro1', '1', 'provider1','PRO', 'Y');
insert into user_info (user_id, user_pw, user_name,user_type, enabled) values ('pro2', '1', 'provider2','PRO', 'Y');
insert into user_info (user_id, user_pw, user_name,user_type, enabled) values ('con1', '1', 'consumer1','CON', 'Y');
insert into user_info (user_id, user_pw, user_name,user_type, enabled) values ('con2', '1', 'consumer2','CON', 'N');

insert into store_info (store_id, owner_id, store_name, store_desc, store_lat, store_lon) 
values ('store1','pro1','store1','this is store1',37.497944,127.027618);
insert into store_info (store_id, owner_id, store_name, store_desc, store_lat, store_lon) 
values ('store2','pro1','store2','this is store2',37.498710,127.029480);
insert into store_info (store_id, owner_id, store_name, store_desc, store_lat, store_lon) 
values ('store3','pro2','store3','this is store3',37.498130,127.029110);

insert into menu_info (store_id, menu_name, menu_price) values('store1','붕어빵',1000);
insert into menu_info (store_id, menu_name, menu_price) values('store1','붕어빵3',2000);
insert into menu_info (store_id, menu_name, menu_price) values('store2','땅콩과자',2000);
insert into menu_info (store_id, menu_name, menu_price) values('store2','바나나빵',3000);
insert into menu_info (store_id, menu_name, menu_price) values('store3','군고구마',5000);
 

