
# 注册登录

#### 数据库(user表设计)

```
create table user(
	id int(11) not null auto_increment,
	email varchar(64) not null,
	password varchar(16) not null,
	nickname varchar(16) not null,
	primary key(id)
)engine = innodb default charset = utf8;
```

#### 技术：mail, redis,@Async, security

#### 设计思路：
注册除了进行数据库操作外，还通过邮箱进行验证,核心类：JavaMailSender(负责邮件的创建和发送), MimeMessage(纸), MimeMessageHelper(邮件各信息). 通过UUID和字符拼接生成token作为key, 将user的json作为value.存入到redis。用户需要在12小时内点击注册链接，完成注册。
<br />
登录通过spring-security框架进行安全设置。(让其访问指定的路径)，类型拦截器。

# 视频 

#### category

```
create table category(
	id bigint(20) not null auto_increment,
	user_id bigint(20) default null,
	name varchar(68) default null,
	logo varchar(68) default null,
	amount int(11) default 0,
	popularity bigint(20) default 0,
	md5 varchar(32) default null,
	primary key(id)
)engine=innodb default charset=utf8;

```
