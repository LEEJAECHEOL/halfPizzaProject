# JSP 반올림피자 프로젝트

## 환경

- windows10 or mac
- jdk1.8 
- tomcat9.0
- sts tool, intelliJ
- mysql8.0
- lombok
- gson (json파싱)
- mysqlConnector
- 인코딩 utf-8
- git
- lucy
- cos
- ckeditor(cdn)


## MySQL 데이터베이스 생성 및 사용자 생성

```sql
create user 'half'@'%' identified by '1234';
GRANT ALL privileges on *.* to 'half'@'%';
CREATE database half;
```

## MySQL 테이블 생성

```sql
use half;
create table users(
    id int primary key auto_increment,
    name varchar(20) not null,
    username varchar(20) not null,
    password varchar(20) not null,
    birth date,
    phone char(13),
    email varchar(100),
    role varchar(10),
    emailAd boolean,
    smsAd boolean,
    createDate timestamp,
    updateDate timestamp
);
create table menu(
	id int primary key auto_increment,
    gubun varchar(10),
    originFileName1 varchar(200) null,
    changeFileName1 varchar(100) null,
    path varchar(100) null,
    title varchar(100) not null,
    content text null,
    price int not null,
    isR boolean,
    createDate timestamp
);
create table optional(
	id int primary key auto_increment,
    title varchar(100) not null,
    gubun varchar(10),
    price int not null
);

create table faq(
    id int primary key auto_increment,
    gubun varchar(100),
    title varchar(100),
    content text null,
    createDate timestamp,
    updateDate timestamp
);
create table event(
    id int primary key auto_increment,
    title varchar(100),
    fromDate date,
    toDate date,
    originFileName1 varchar(100),
    changeFileName1 varchar(100),
    originFileName2 varchar(100),
    changeFileName2 varchar(100),
    path varchar(100),
    createDate timestamp
);
create table notice(
    id int primary key auto_increment,
    title varchar(100),
    content text null,
    createDate timestamp,
    updateDate timestamp
);
create table orders(
    id int primary key auto_increment,
    userId int,
    name varchar(20),
    phone varchar(13),
    addr varchar(200),
    storeTel varchar(13),
    storeAddr varchar(200),
    info longText,
    text varchar(200),
    impId varchar(100),
    merchantId varchar(100),
    paidAmount int,
    state varchar(20),
    createDate timestamp
);
create table store(
	id int primary key auto_increment,
    xPos double,
    yPos double,
    name varchar(200),
    tel varchar(13),
    addr varchar(200),
    addr2 varchar(200),
    createDate timestamp
);
```