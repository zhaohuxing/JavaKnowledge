###数据库设计
- 创建数据库
	create database TestOfHuitui default charset utf8;
- User 
```
create table User (
	id int(11) NOT NULL AUTO_INCREMENT primary key,
	create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,	
	name varchar(128) not null,
	address varchar(128) not null,
	birth varchar(128) not null,
	sex varchar(2) not null
)ENGINE=INNODB DEFAULT CHARSET UTF8;
```
易溥咸 福建省 10/26/1966
insert into User (id, name, address, birth, sex)values(1000, "易溥咸", "福建省", "10/26/1966", "男");