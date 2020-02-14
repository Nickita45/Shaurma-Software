drop table if exists hibernate_sequence;
drop table if exists document;
create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 );
create table document (id integer not null AUTO_INCREMENT, date datetime(6), done bit not null, primary key (id)) engine=InnoDB