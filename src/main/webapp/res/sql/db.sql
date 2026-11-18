show databases;

create database db_diary;

use db_diary;

create table tbl_member(
memNo		int			auto_increment  comment '회원번호',
memId		varchar(20)	unique  not null	comment '회원아이디',							
memPw		varchar(20)	not null	comment '회원미밀번호',					
memMail		varchar(50)	comment '회원메일',				
memPhone	varchar(50)	comment '회원연락처',								
memRegDate	timestamp	default current_timestamp  comment '회원등록일',							
memModDate	timestamp 	default current_timestamp on update  current_timestamp comment '회원최근수정일',
primary key(memNo)
) auto_increment = 1001;  -- 1001부터 시작한다는 명령어

show tables;
desc tbl_member;
select * from tbl_member;

insert into tbl_member(memId, memPw, memMail, memPhone )
values('gildong', '1234', 'gildong@gmail.com', '010-1234-9999');


insert into tbl_member(memId, memPw, memMail, memPhone )
values('chanho', '1111', 'chanho@gmail.com', '010-1234-7777');


insert into tbl_member(memId, memPw, memMail, memPhone )
values('seari', '0000', 'seari@gmail.com', '010-1234-8888');

insert into tbl_member(memId, memPw, memMail, memPhone )
values('seari2', '0000', 'seari@gmail.com', '010-1234-8888');

set auto_increment_increment = 3;    -- 숫자를 3씩 올린다는 명령어

