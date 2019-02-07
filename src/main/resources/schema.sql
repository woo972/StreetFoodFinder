
/* user type 
 * 1: admin
 * 2: store master
 * 3: consumer
 * 
 * 주소 쿼리스트링 사용을 위해 쿼리스트링에 사용될 특수문자는 디비에 저장되지 않도록 막아야함
 */

drop table if exists user_info;
create  table user_info (
	user_id varchar(100) not null, 
	user_pw varchar(60) not null, 
	user_name varchar(50),	
	user_type varchar(3),
	gender varchar(1),
	birthday varchar(8),
	enabled varchar(1),
	cre_date varchar(8),
	upd_date varchar(8)
);
alter table user_info add primary key (user_id);

/*cre_date가 n일 이상이면 삭제 
 * 
 * */
drop table if exists temp_nonce;
create  table temp_nonce (
	user_id varchar(100) not null,
	nonce varchar(10) not null,
	cre_date varchar(8)
);
alter table temp_nonce add primary key (user_id, nonce);

/*owner_id = user_id fk 처리?
 * 한 가게에 오너가 여러명인 경우, 오너 한 명이 여러 가게를 가진 경우....
 */
drop table if exists store_info;
create table store_info (
	store_id varchar(20) not null, 
	owner_id varchar(20) not null,
	store_name varchar(20),
	store_desc varchar(100),
	store_lat float,
	store_lon float,
	enabled varchar(1),
	cre_date varchar(8),
	upd_date varchar(8)	
);
alter table store_info add primary key (store_id);

drop table if exists store_image;
create table store_image (
	store_id varchar(20) not null, 
	image_name varchar(30) not null,
	image_order integer,
	cre_date varchar(8),
	upd_date varchar(8)	
);
alter table store_image add primary key (store_id, image_name);

/* 타코야끼 8개에 천원 
 * 타코야끼 1팩에 천원...  각각 다른 단위가 있을 텐데 어떻게 정량화?
 * 
 */
drop table if exists menu_info;
create table menu_info (
	store_id varchar(20) not null,
	menu_type varchar(20),
	menu_name varchar(20) not null,	
	menu_price integer not null,
	enabled varchar(1),
	cre_date varchar(8),
	upd_date varchar(8)
);
alter table menu_info add primary key (store_id, menu_name);

drop table if exists review;
create table review (
	writer_id varchar(20) not null,
	store_id varchar(20) not null, 
	rating integer,
	comment varchar(300),
	cre_date varchar(8),
	upd_date varchar(8)	
);
alter table review add primary key (writer_id,store_id);


drop table if exists favorite;
create table favorite (
	user_id varchar(20) not null,
	store_id varchar(20) not null,
	cre_date varchar(8)	
);
alter table favorite add primary key (user_id,store_id);


/*board_id, reply_id 등은 시퀀스로??
 * 
 */
--drop table if exists notice;
--create table notice (
--	writer_id varchar(20) not null,
--	notice_id varchar(20) not null,
--	title varchar(20) not null,
--	content varchar(500),
--	cre_date varchar(8),
--	upd_date varchar(8)
--); 
--alter table notice add primary key (notice_id);

drop table if exists community;
create table community (
	writer_id varchar(20) not null,
	post_id varchar(20) not null,
	title varchar(20) not null,
	content varchar(500),
	view_cnt integer,
	like_cnt integer,
	unlike_cnt integer,
	cre_date varchar(8),
	upd_date varchar(8)
	
);
alter table community add primary key (post_id);

drop table if exists reply;
create table reply (
	writer_id varchar(20) not null,
	post_id varchar(20) not null,
	reply_id varchar(20) not null,
	content varchar(500),
	like_cnt integer,
	unlike_cnt integer,	
	cre_date varchar(8),
	upd_date varchar(8)
);
alter table reply add primary key (reply_id);