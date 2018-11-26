

drop table if exists user_info;

create table user_info (
	user_id varchar(20) not null, 
	user_pw varchar(20) not null, 
	user_nick varchar(20)
	
);

alter table user_info add primary key (user_id);