
/* user type 
 * 1: admin
 * 2: store master
 * 3: consumer
 */

drop table if exists user_info;
create table user_info (
	user_id varchar(20) not null, 
	user_pw varchar(20) not null, 
	user_nick varchar(20),	
	user_type number
);
alter table user_info add primary key (user_id);
