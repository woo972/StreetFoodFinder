
insert into user_info (user_id, user_pw, user_nick) values ('test11', 'test1_pw', 'john');
insert into user_info (user_id, user_pw, user_nick) values ('test2', 'test2_pw', 'micky');
insert into user_info (user_id, user_pw, user_nick) values ('test3', 'test3_pw', 'sam');


insert into item_master (item_id, itme_name, visible_flag, price, cre_time, upd_time) 
values ('I01', 'BLOCK_BREAKER', 'Y', 1000, '20181124', '20181124');
insert into item_master (item_id, itme_name, visible_flag, price, cre_time, upd_time) 
values ('I02', 'TEST_ITEM', 'Y', 20000, '20181124', '20181124');
insert into item_master (item_id, itme_name, visible_flag, price, cre_time, upd_time) 
values ('I03', 'AAA', 'N', 100, '20181124', '20181124');


insert into own_item (user_id, item_id, item_qty, cre_time, upd_time)
values ('test11','I01',10,'20181124','20181114');
insert into own_item (user_id, item_id, item_qty, cre_time, upd_time)
values ('test11','I02',5,'20181124','20181114');
insert into own_item (user_id, item_id, item_qty, cre_time, upd_time)
values ('test2','I02',100,'20181124','20181114');