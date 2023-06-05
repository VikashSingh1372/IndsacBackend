
create table if not exists persistent_logins ( 
  username varchar(100) not null, 
  series varchar(64) primary key, 
  token varchar(64) not null, 
  last_used timestamp not null
);

--delete from  user_role;
--delete from  roles;
--delete from  users;


--INSERT INTO roles (id, name) VALUES
--('e677bb88-a6d4-41f8-bd7c-d816ac1ba9df', 'ROLE_ADMIN'),
--('f7c715e8-c9b0-4278-abc3-5d1310543273', 'ROLE_ACTUATOR'),
--('6c9bdc82-cbe3-456f-b55b-b153a8523f53', 'ROLE_USER'),
--('b51858f9-c165-4009-b9cb-7d5fb37a8e5a', 'ROLE_INSTRUCTOR')
--;


