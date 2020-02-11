create table document (id integer not null, date datetime(6), done bit not null, user_id integer not null, primary key (id)) engine=InnoDB
create table hibernate_sequences (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name)) engine=InnoDB
insert into hibernate_sequences(sequence_name, next_val) values ('default',0)