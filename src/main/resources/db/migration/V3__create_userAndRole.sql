drop table if exists hibernate_sequence;
drop table if exists role_table;

create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

create table users (user_id integer not null auto_increment, active bit, email varchar(40), first_name varchar(40), last_name varchar(40), login varchar(40) not null, password varchar(40) not null, primary key (user_id)) engine=InnoDB;
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);
alter table users add constraint UK_ow0gan20590jrb00upg3va2fn unique (login);
create table role_ids (users_ids integer not null, role_ids integer not null, primary key (users_ids, role_ids)) engine=InnoDB;
create table role_table (id integer not null auto_increment, role_name varchar(30), primary key (id)) engine=InnoDB;
