## 约束条件
- 目前仅支持int,float,long,double,boolean,String数据类型
- 目前仅支持 "=", "like", "and", "or"操作
- 实体类中的字段与表中字段一一对应
- 实体类中需存在无参构造函数以及getter&setter方法

## 功能介绍
用于小型的项目，简化数据库访问操作
- 添加（含id添加忽略），表中若存在id字段，请设为自增
- 删除：清空所有记录，多条件删除，单条件删除
- 更新：无条件更新记录，多条件更新记录，单条件更新记录
- 查询：无条件全部查询，多条件查询多条记录，多条件查询单条记录，
单条件查询多条记录，单条件查询单条记录

## 使用说明

#### 文件说明
- ConnectionUtil.java : 用于连接数据库，在里面替换数据库名
- DBReflectionUtil.java：通用的增删改查操作。

假设我们有个Student实体类，并存在students表
```
//实体类
package com.sprint.entity;

public class Student {
	private int id;
	private String name;
	private int age;
	private String sex;
	private String school;
	private String major;
	private String clazz;
	//省略构造 && gettter && setter方法
}
```
```
//对应表结构
create table students (
	id int auto_increment,
	name varchar(128),
	age int,
	sex varchar(5),
	school varchar(128),
	major varchar(128),
	clazz varchar(128)
)engine=innodb default charset = utf8;
```
一般需要再封装一层dao，看个人编程规范吧。这里直接使用DBReflectionUtil类操作

#### 添加数据: ` public static boolean insert(String tableName, T object)`



|参数名|参数名描述|
|---------|---------------|
|tableName|表名|
|object|存储的对象|

```
Student stu = new Student("name", 18, "male", "CodeUniversity", "SoftWare", "class01");
DBReflectionUtil.insert("students", stu)) 	
```

#### 清空所有记录：`public static boolean deleteAll(String tableName)`

|参数名|参数名描述|
|---------|---------------|
|tableName|表名|

```
DBReflectionUtil.deleteAll("students");
```

#### 单条件删除记录：`public static boolean deleteByKeys(String tableName, Map<String, Object>map, String operator1)`

|参数名|参数名描述|
|---------|---------------|
|tableName|表名|
|map|条件字段和字段值组成的key-value|
|operator1|操作类型，目前只支持"="或"like"|

```
//例如：删除students中 name前缀为'邢',需要自己进行字符匹配
Map<String, Object> map = new HashMap<String, Object>();
map.put("name", "邢%");
DBReflectionUtil.deleteByKeys("students", map, "like");
```

#### 多条件删除记录：`public static boolean deleteByKeys(String tableName, Map<String, Object>map, String operator1, String operator2)`


|参数名|参数名描述|
|---------|---------------|
|tableName|表名|
|map|条件字段和字段值组成的key-value|
|operator1|操作类型，目前只支持"="或"like"|
|operator2|逻辑操作，目前只支持"and"或"or"|

```
//例如：删除students中 age=18并且 sex='女'
Map<String, Object> map = new HashMap<String, Object>();
map.put("sex", "女");
map.put("age", 18);
DBReflectionUtil.deleteByKeys("students", map, "=", "and");
```

#### 无条件更新：`public static boolean updateAll(String tableName, Map<String, Object> map)`

|参数名|参数名描述|
|---------|---------------|
|tableName|表名|
|map|需要更新的字段和字段值组成的key-value|

```
//假设将students中的age更新为1000, major更新为"水下工作者"
Map<String, Object> map = new HashMap<String, Object>();
map.put("age", 1000);
map.put("major", "水下工作者");
DBReflectionUtil.updateAll("students", map);
```

#### 单条件更新：`public static boolean updateByKeys(String tableName, Map<String, Object> updateMap, Map<String, Object> optionMap, String operator1)`
|参数名|参数名描述|
|---------|---------------|
|tableName|表名|
|updateMap|需要更新的字段和字段值组成的key-value|
|optionMap|条件字段和字段值组成的key-value|
|operator1|操作类型，目前只支持"="或"like"|

```
//假设将name中姓“骆”的age更改为20
Map<String, Object> updateMap = new HashMap<String, Object>();
map.put("age", 20);
Map<String, Object> optionMap = new HashMap<String, Object>();
map.put("name", "骆%");
DBReflectionUtil.updateByKeys("students", updateMap, optionMap, "like");
```

#### 多条件更新：`public static boolean updateByKeys(String tableName, Map<String, Object> updateMap, Map<String, Object> optionMap, String operator1, String operator2)`

|参数名|参数名描述|
|---------|---------------|
|tableName|表名|
|updateMap|需要更新的字段和字段值组成的key-value|
|optionMap|条件字段和字段值组成的key-value|
|operator1|操作类型，目前只支持"="或"like"|
|operator2|逻辑操作，目前只支持"and" 或 "or"|

```
//假设将age=18并且major='SoftWare'的记录中clazz更改为"1403"
Map<String, Object> updateMap = new HashMap<String, Object>();
map.put("clazz", "1403");
Map<String, Object> optionMap = new HashMap<String, Object>();
map.put("age", 18);
map.put("major", "SoftWare");
DBReflectionUtil.updateByKeys("students", updateMap, optionMap, "=", "and");
```


#### 无条件查询操作接口：`public static <T> List<T> findAll(String table, T object)`

|参数名|参数名描述|
|---------|---------------|
|tableName|表名|
|object|获取的对象，不用设置数据，仅 new Object()|


```
//例如：获取所以的学生
List<Student> list = DBReflectionUtil.findAll("students", new Student());
```

#### 单条件查询单条：`public static <T> T findOnlyByKey(String tableName, T object, Map<String, Object> map)`

|参数名|参数名描述|
|---------|---------------|
|tableName|表名|
|object|获取的对象，不用设置数据，仅 new Object()|
|map|条件字段和字段值组成的key-value|

```
// 例如：取出表中id为2的记录
Map<String, Object> map = new HashMap<String, Object>();
map.put("id", 2);
Student stu = DBReflectionUtil.findOnlyByKey("students", new Student(),map);
```
#### 单条件查询多条：`pulic static <T> List<T> findMoreByKeys(String tableName, T object, , Map<String, Object> map, String operator1)`

|参数名|参数名描述|
|---------|---------------|
|tableName|表名|
|object|获取的对象，不用设置数据，仅 new Object()|
|map|条件字段和字段值组成的key-value|
|operator1|操作类型，目前只支持"="或"like"|

```
//例如：查找name中含"骆"的学生
Map<String, Object> map = new HashMap<String, Object>();
map.put("name", "骆%");
List<Student> list = DBReflectionUtil.findOnlyByKey("students", new Student(), map, "like");
```

#### 多条件查询多条记录：`public static <T> List<T> findMoreByKeys(String tableName, T object, Map<String, Object> map, String operator1, String operator2)`

|参数名|参数名描述|
|---------|---------------|
|tableName|表名|
|object|获取的对象，不用设置数据，仅 new Object()|
|map|条件字段和字段值组成的key-value|
|operator1|操作类型，目前只支持"="或"like"|
|operator2|逻辑操作，目前只支持"and" 或 "or"|

```
//例如：查询name中姓"骆"，并且school为"中国"为前缀的学生
Map<String, Object> map = new HashMap<String, Object>();
map.put("name", "骆%");
map.put("sex", "中国%");
Student stu = DBReflectionUtil.findOnlyByKey("students", new Student(), map, "like", "and");
```

#### 多条件查询单条记录：`public static <T> List<T> findMoreByKeys(String tableName, T object, Map<String, Object> map, String operator1, String operator2)`

|参数名|参数名描述|
|---------|---------------|
|tableName|表名|
|object|获取的对象，不用设置数据，仅 new Object()|
|map|条件字段和字段值组成的key-value|
|operator1|操作类型，目前只支持"="或"like"|
|operator2|逻辑操作，目前只支持"and" 或 "or"|

```
//例如：查询sex为"男"，并且id为4为前缀的学生
Map<String, Object> map = new HashMap<String, Object>();
map.put("sex", "男");
map.put("id", 4);
Student stu = DBReflectionUtil.findOnlyByKey("students", new Student(), map, "=", "and");
```


## 下一版需要改进的地方（当前版的缺点）
- 合理，全面的数据校验
- 查询，更新，删除的sql语句改成 IN类型
- 支持时间类型


