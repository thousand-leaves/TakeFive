drop table if exists person CASCADE; 
create table person (
id integer AUTO_INCREMENT, 
age integer not null, 
coin_level integer not null, 
creative_level integer not null, 
email varchar(255), 
happy_level integer not null, 
health_level integer not null, 
name varchar(255), 
smart_level integer not null, 
primary key (id)
);