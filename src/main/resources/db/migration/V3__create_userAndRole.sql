drop table if exists hibernate_sequence;
drop table if exists role_table;

create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
