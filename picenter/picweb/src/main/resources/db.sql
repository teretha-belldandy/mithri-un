create database if not exists picenterdb;

use picenterdb;

create table picuser (
uid int(20) PRIMARY KEY,
uname VARCHAR(20) NOT NULL,
age int NOT NULL,
vip Boolean
);