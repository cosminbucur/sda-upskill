-- DONE: save all db objects here

create database if not exists spring_jdbc_tutorial;

use spring_jdbc_tutorial;

create table if not exists book
(
`id` int auto_increment primary key,
`title` varchar(100) not null,
`author` varchar(100) not null,
`publish_date`date
);

insert into book (title, author, publish_date) values ("book1", "author1", "2020-11-03");

select * from book;

select * from book where author="author1";

select * from book where id="1";

select * from book where title="book1";

UPDATE book
SET title = 'book4', author= 'author4'
WHERE id = 3;

DELETE FROM book WHERE id='3';