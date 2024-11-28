show databases;
create database todolist;

use todolist;

create table todolist (
No int primary key auto_increment not null ,
List varchar(100) not null ,
Finished enum ('YES', 'NO') not null default 'NO',
Time_Created datetime not null default current_timestamp
) Engine=InnoDB;

drop table todolist;

show tables;

desc todolist;
