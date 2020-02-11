drop table if exists hibernate_sequence;
drop table if exists role_table;
drop table if exists user;
create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
create table role_table (id bigint not null, employee_id bigint, role_name varchar(30), user_id bigint, primary key (id));
create table user (user_id bigint not null, active bit, email varchar(40), first_name varchar(40), last_name varchar(40), login varchar(40), password varchar(40), primary key (user_id));
alter table role_table add constraint FKpec01w40sojsoyujmr9n6i2ko foreign key (user_id) references user (user_id);