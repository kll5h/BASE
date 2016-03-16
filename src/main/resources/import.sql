insert into user(id, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) values (1,'roy','$2a$10$0EHOuqpPPhQatNZP1LR4jemFJS7mDz5QJzJY2hbNU319Aueojv4qW', true, true, true, true);
insert into user(id, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) values (2,'craig','$2a$10$0EHOuqpPPhQatNZP1LR4jemFJS7mDz5QJzJY2hbNU319Aueojv4qW', true, true, true, true);
insert into user(id, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) values (3,'greg','$2a$10$0EHOuqpPPhQatNZP1LR4jemFJS7mDz5QJzJY2hbNU319Aueojv4qW', true, true, true, true);
 
insert into role(id, name, created_by, created_date, last_modified_by, last_modified_date) values (1,'USER', 1, current_timestamp(), null, null);
insert into role(id, name, created_by, created_date, last_modified_by, last_modified_date) values (2,'ADMIN', 1, current_timestamp(), null, null);
insert into role(id, name, created_by, created_date, last_modified_by, last_modified_date) values (3,'GUEST', 1, current_timestamp(), null, null);

insert into user_role(user_id, role_id) values (1,1);
insert into user_role(user_id, role_id) values (1,2);
insert into user_role(user_id, role_id) values (2,1);
insert into user_role(user_id, role_id) values (3,1);