show databases;
create database todolist;

use todolist;

create table todolist (
No int primary key auto_increment not null ,
List varchar(100) not null ,
Finished enum ('YES', 'NO') not null,
Time_Created datetime default current_timestamp
) Engine=InnoDB;

show tables;

desc todolist;
