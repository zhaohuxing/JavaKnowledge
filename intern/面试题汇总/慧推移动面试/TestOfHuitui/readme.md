###需求
- 提供一个上传页面,将给予的excel数据导入数据库,并显示出来。（完成）
- 列出User清单，并列出User的购买清单（完成）
- 列出Product清单，并列出Product详细清单(完成)
- 使用Echarts列出top10的城市，以及月利润比较(未完成)

###我的编码过程
针对第一条需求，我将文件上传到工程中，用写好的接口读取文件中的数据并插入到对应的表中.<br />
针对第二条需求，我拉去User中数据，并以User作为Key,去Sale中拉去数据<br />
针对第三条需求，我拉去Product中数据，并以Product作为Key,去Sale中拉去数据<br />

###感受
写得跟屎一般,未完，待续.

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
)engine=innodb default charset utf8;
```

