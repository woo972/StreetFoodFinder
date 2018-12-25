
insert into user_info (user_id, user_pw, user_name,user_type, enabled, cre_date, upd_date) values ('adm', '1', 'adm', 'ADM', 'Y', '20181214','20181225');
insert into user_info (user_id, user_pw, user_name,user_type, enabled, cre_date, upd_date) values ('pro1', '1', 'provider1','PRO', 'Y', '20181225', '20181225');
insert into user_info (user_id, user_pw, user_name,user_type, enabled, cre_date, upd_date) values ('pro2', '1', 'provider2','PRO', 'Y', '20181211','20181211');
insert into user_info (user_id, user_pw, user_name,user_type, enabled, cre_date, upd_date) values ('con1', '1', 'consumer1','CON', 'Y','20181212','20181227');
insert into user_info (user_id, user_pw, user_name,user_type, enabled, cre_date, upd_date) values ('con2', '1', 'consumer2','CON', 'N','20181212','20181227');

insert into store_info (store_id, owner_id, store_name, store_desc, store_lat, store_lon, enabled, cre_date, upd_date) 
values ('store1','pro1','store1','this is store1',37.497944,127.027618, 'Y', '20181214','20181225');
insert into store_info (store_id, owner_id, store_name, store_desc, store_lat, store_lon, enabled, cre_date, upd_date) 
values ('store2','pro1','store2','this is store2',37.498710,127.029480, 'Y', '20181214','20181225');
insert into store_info (store_id, owner_id, store_name, store_desc, store_lat, store_lon, enabled, cre_date, upd_date) 
values ('store3','pro2','store3','this is store3',37.498130,127.029110, 'Y', '20181214','20181225');

insert into menu_info (store_id, menu_name, menu_price, enabled, cre_date, upd_date) values('store1','붕어빵',1000, 'Y', '20181214','20181225');
insert into menu_info (store_id, menu_name, menu_price, enabled, cre_date, upd_date) values('store1','붕어빵3',2000, 'Y','20181212','20181227');
insert into menu_info (store_id, menu_name, menu_price, enabled, cre_date, upd_date) values('store2','땅콩과자',2000, 'Y', '20181214','20181225');
insert into menu_info (store_id, menu_name, menu_price, enabled, cre_date, upd_date) values('store2','바나나빵',3000, 'N','20181212','20181227');
insert into menu_info (store_id, menu_name, menu_price, enabled, cre_date, upd_date) values('store3','군고구마',5000, 'Y', '20181214','20181225');
 

insert into rating (store_id, rate, writer_id, comment, cre_date, upd_date) values('store1',10,'con1','very good','20181215','20181215');
insert into rating (store_id, rate, writer_id, comment, cre_date, upd_date) values('store1',2,'con2','bad','20181215','20181215');
insert into rating (store_id, rate, writer_id, comment, cre_date, upd_date) values('store2',8,'con1','hmm','20181215','20181215');
insert into rating (store_id, rate, writer_id, comment, cre_date, upd_date) values('store2',5,'con2','test msg','20181215','20181215');
insert into rating (store_id, rate, writer_id, comment, cre_date, upd_date) values('store2',6,'adm','good-good','20181215','20181215');
insert into rating (store_id, rate, writer_id, comment, cre_date, upd_date) values('store3',10,'con2','not bad','20181215','20181215');
