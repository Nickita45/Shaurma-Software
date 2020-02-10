drop table if exists user;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
create table document (id integer not null AUTO_INCREMENT, date datetime, done bit not null, user_id integer not null, primary key (id));