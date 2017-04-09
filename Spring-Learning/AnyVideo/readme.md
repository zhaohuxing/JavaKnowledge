
# 注册登录

#### 数据库---user表设计
```
create table user(
	id int(11) not null auto_increment,
	email varchar(64) not null,
	password varchar(16) not null,
	nickname varchar(16) not null,
	primary key(id)
)engine = innodb default charset = utf8;
```

技术：security, mail, @Async
