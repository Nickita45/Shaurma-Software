

drop table if exists additive;
 drop table if exists hibernate_sequence;
drop table if exists line;
drop table if exists line_additive;
drop table if exists line_spice;
drop table if exists shaurma_type;
drop table if exists spice;
create table additive (id integer not null, name varchar(255), price double precision not null, primary key (id)) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
 insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
 insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
 create table line (id integer not null, description varchar(255), order_id integer not null, user_id integer not null, shaurma bigint not null, primary key (id)) engine=InnoDB;
 create table line_additive (line_ids integer not null, additive_ids integer not null, primary key (line_ids, additive_ids)) engine=InnoDB;
create table line_spice (line_ids integer not null, spice_ids bigint not null, primary key (line_ids, spice_ids)) engine=InnoDB;
create table shaurma_type (id bigint not null, name varchar(255), price double precision not null, primary key (id)) engine=InnoDB;
create table spice (id bigint not null, name varchar(255), price double precision not null, primary key (id)) engine=InnoDB;
alter table line add constraint FKrm18jcprkqcx6m6igvfan6hoa foreign key (shaurma) references shaurma_type (id);
alter table line_additive add constraint FK78jv5ifjtp04c79cgyomni16x foreign key (additive_ids) references additive (id);
alter table line_additive add constraint FKe37i8wi62067yygh74onyhjgs foreign key (line_ids) references line (id);
alter table line_spice add constraint FKf18kcx1n55oxip7p3x4v8f4vn foreign key (spice_ids) references spice (id);
alter table line_spice add constraint FKhemk5hrcowvuu5jfoi069qr9f foreign key (line_ids) references line (id);