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
- Product
```
create table Product (
	id int(11) not null auto_increment primary key,
	create_time timestamp not null default current_timestamp,
	update_time timestamp not null default current_timestamp on update current_timestamp,
	product_name varchar(128) not null,
	product_type varchar(64) not null,
	product_price double  not null,
	product_unit varchar(32) not null
)engine=innodb default charset utf8;
```

- Sale
```
create table Sale (
	user_id int(11) not	null,
	product_id int(11) not null,
	create_time timestamp not null default current_timestamp,
	update_time timestamp not null default current_timestamp on update current_timestamp,
	sale_date varchar(64) not null,
	sale_price double not null,
	sale_number double not null,
	foreign key(user_id) references User(id),
	foreign key(product_id) references Product(id),
	primayr key(user_id, product_id)
)engine=innodb default charset utf8;
```

