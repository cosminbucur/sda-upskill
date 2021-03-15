create database if not exists jdbc_tutorial;

use jdbc_tutorial;

create table if not exists book
(
`id` int auto_increment primary key,
`title` varchar(100) not null,
`author` varchar(100) not null,
`publish_date`date
);