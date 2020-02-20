alter table users drop index UK_6dotkott2kjsp8vw4d0m25fb7;
alter table users drop index UK_ow0gan20590jrb00upg3va2fn;
alter table document add constraint FK98uay1sqq31yku7nneuf8hdd1 foreign key (cashier_id) references users (user_id);
alter table line add constraint FK9ff9v5iia52g9q5gjmcop3mjg foreign key (order_id) references document (id);
alter table line add constraint FKrm18jcprkqcx6m6igvfan6hoa foreign key (shaurma) references shaurma_type (id);
alter table line add constraint FKoxyvlsx5xsrwnmfq0ku3ch6mj foreign key (user_id) references users (user_id);
alter table line_additive add constraint FK78jv5ifjtp04c79cgyomni16x foreign key (additive_ids) references additive (id);
alter table line_additive add constraint FKe37i8wi62067yygh74onyhjgs foreign key (line_ids) references line (id);
alter table line_spice add constraint FKf18kcx1n55oxip7p3x4v8f4vn foreign key (spice_ids) references spice (id);
alter table line_spice add constraint FKhemk5hrcowvuu5jfoi069qr9f foreign key (line_ids) references line (id);
alter table role_ids add constraint FKmxu7tykuketjo67i606p3ptv foreign key (role_ids) references role_table (id);
alter table role_ids add constraint FK5o3ml6m3kcdlnisnauk1tt26g foreign key (users_ids) references users (user_id);