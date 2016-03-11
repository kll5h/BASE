insert into user(id, username, password, salt, account_non_expired, account_non_locked, credentials_non_expired, enabled) values (1,'roy','spring','sault', true, true, true, true);
insert into user(id, username, password, salt, account_non_expired, account_non_locked, credentials_non_expired, enabled) values (2,'craig','spring','sault', true, true, true, true);
insert into user(id, username, password, salt, account_non_expired, account_non_locked, credentials_non_expired, enabled) values (3,'greg','spring','sault', true, true, true, true);
 
insert into role(id, name) values (1,'USER');
insert into role(id, name) values (2,'ADMIN');
insert into role(id, name) values (3,'GUEST');

insert into user_role(user_id, role_id) values (1,1);
insert into user_role(user_id, role_id) values (1,2);
insert into user_role(user_id, role_id) values (2,1);
insert into user_role(user_id, role_id) values (3,1);