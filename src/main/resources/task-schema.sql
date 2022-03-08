drop table if exists task CASCADE;
create table task (
task_id integer AUTO_INCREMENT,
category varchar(255), 
coin_reward integer not null, 
creative_reward integer not null, 
description varchar(255), 
happy_reward integer not null, 
health_reward integer not null, 
smart_reward integer not null, 
primary key (task_id)
);