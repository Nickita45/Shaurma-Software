create table additive (id integer not null auto_increment, name varchar(255), price double precision not null, primary key (id)) engine=InnoDB;
create table line (id integer not null auto_increment, description varchar(255), order_id integer, shaurma integer, user_id integer, primary key (id)) engine=InnoDB;
create table line_additive (line_ids integer not null, additive_ids integer not null, primary key (line_ids, additive_ids)) engine=InnoDB;
create table line_spice (line_ids integer not null, spice_ids integer not null, primary key (line_ids, spice_ids)) engine=InnoDB;
create table shaurma_type (id integer not null auto_increment, name varchar(255), price double precision not null, primary key (id)) engine=InnoDB;
create table spice (id integer not null auto_increment, name varchar(255), price double precision not null, primary key (id)) engine=InnoDB;


