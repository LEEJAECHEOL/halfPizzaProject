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
    originFileName varchar(200) null,
    changeFileName varchar(100) null,
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
    price int not null
);
```