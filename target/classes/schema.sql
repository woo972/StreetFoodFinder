
/* user type 
 * 1: admin
 * 2: store master
 * 3: consumer
 * 
 * 주소 쿼리스트링 사용을 위해 쿼리스트링에 사용될 특수문자는 디비에 저장되지 않도록 막아야함
 */

drop table if exists user_info;
create  table user_info (
	user_id varchar(20) not null, 
	user_pw varchar(20) not null, 
	user_name varchar(20),	
	user_type varchar(3)
);
alter table user_info add primary key (user_id);

/*owner_id = user_id fk 처리?
 * 한 가게에 오너가 여러명인 경우, 오너 한 명이 여러 가게를 가진 경우....
 */

drop table if exists store_info;
create table store_info (
	store_id varchar(20) not null, 
	owner_id varchar(20) not null,
	store_name varchar(20),
	store_desc varchar(100),
	store_lat varchar(20),
	store_lon varchar(20)
);
alter table store_info add primary key (store_id);

/* 타코야끼 8개에 천원 
 * 타코야끼 1팩에 천원...  각각 다른 단위가 있을 텐데 어떻게 정량화?
 * 
 */
drop table if exists menu_info;
create table menu_info (
	store_id varchar(20) not null, 
	menu_name varchar(20) not null,	
	menu_price integer not null,
	unit varchar(10) not null
);
alter table menu_info add primary key (store_id, menu_name);

