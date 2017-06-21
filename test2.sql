create table user_details
(
	f_name varchar(20) not null,
	l_name varchar(20) not null,
	username varchar(20) primary key not null unique,
	email_id varchar(50) not null unique,
	m_no int(10) unique,
	password varchar(10) not null
);


create table admin_details
(
	f_name varchar(20) not null,
	l_name varchar(20) not null,
	username varchar(5) primary key not null unique,
	password varchar(10) not null
);


create table subjects
(
	sub_name varchar(20) not null,
	sub_id int(3) primary key unique not null auto_increment
);
create table questions
(
	qid int(4) primary key auto_increment,
	qtext varchar(100)not null,
	opt1 varchar(50) not null ,
	opt2 varchar(50) not null ,
	opt3 varchar(50) not null ,
	opt4 varchar(50) not null ,
	copt int(1) not null ,
	sub_name varchar(10)
);

drop table questions;

create table questions
(
	qid int(4) primary key auto_increment,
	qtext varchar(100)not null,
	opt1 varchar(50) not null ,
	opt2 varchar(50) not null ,
	opt3 varchar(50) not null ,
	opt4 varchar(50) not null ,
	copt int(1) not null ,
	sub_id int(3)
);

create table score
(
	score_id int(4) primary key auto_increment,
    username varchar(20),
	score int(3),
	sub_name varchar(10),
	date date
);
select * from score;



insert into subjects values ("SQL",null);
insert into subjects values ("JAVA",null);
insert into subjects values ("C",null);
insert into subjects values ("C++",null);

insert into questions values(null,"You can add a row using SQL in a database with which of the following?","ADD","CREATE","INSERT","MAKE",3,"SQL");
select *from questions;
select *from questions where sub_name='C';
drop table questions;
insert into questions values(null,"#Which of the following cannot be static in C?","variables","functions","structure","none of these",4,"C");
insert into questions values(null,"What is default visibility mode for members of classes in C++ ?","Public","Private","Protected","Depends",2,"C++");

insert into questions values(null,"Which is an indirection operator among the following? ","-","->","%","*",2,"C");
select score_id,sub_name max(score_id) from score group by sub_name having sub_name='C++';

select qid,copt from questions where sub_name='C++'
order by rand() asc limit 5;

INSERT INTO score values (null,(SELECT username FROM user_details),10,"c",null);
select * from score;
insert into user_details(f_name, l_name, username, email_id ,m_no, password) values("bipasha","dutta","bip123","bips",6789,"abc");
select * from user_details;


