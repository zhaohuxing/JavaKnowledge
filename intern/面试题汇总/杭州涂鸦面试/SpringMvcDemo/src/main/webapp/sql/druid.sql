/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.0.18-nt : Database - druid
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`druid` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `druid`;

/*Table structure for table `role_menu` */

DROP TABLE IF EXISTS `role_menu`;

CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL auto_increment,
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `role_id` (`role_id`),
  KEY `menu_id` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限关联表';

/*Data for the table `role_menu` */

insert  into `role_menu`(`id`,`role_id`,`menu_id`) values (1,1,10),(2,1,20),(3,1,1010),(4,1,1020),(5,1,2010),(6,2,10),(7,2,1010),(8,2,1020);

/*Table structure for table `sysmenu` */

DROP TABLE IF EXISTS `sysmenu`;

CREATE TABLE `sysmenu` (
  `id` int(11) NOT NULL auto_increment,
  `text` varchar(20) NOT NULL default '' COMMENT '菜单名称',
  `parentId` int(11) NOT NULL default '0' COMMENT '父级菜单ID 0表示根节点',
  `sequence` int(6) NOT NULL default '0' COMMENT '菜单顺序',
  `iconCls` varchar(20) NOT NULL default '' COMMENT '菜单图标样式',
  `url` varchar(255) NOT NULL default '' COMMENT '菜单链接地址 总是以‘/’开头，相对于项目根路径',
  PRIMARY KEY  (`id`),
  KEY `parentId` (`parentId`),
  KEY `sequence` (`sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台菜单表';

/*Data for the table `sysmenu` */

insert  into `sysmenu`(`id`,`text`,`parentId`,`sequence`,`iconCls`,`url`) values (10,'系统管理',0,10,'','http://www.baidu.com'),(20,'用户管理',0,20,'','/user/list'),(1010,'系统管理1',10,1010,'','http://www.baidu.com'),(1020,'系统管理2',10,1020,'','http://www.baidu.com'),(2010,'用户管理1',20,2010,'','http://www.baidu.com');

/*Table structure for table `sysrole` */

DROP TABLE IF EXISTS `sysrole`;

CREATE TABLE `sysrole` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(60) NOT NULL default '' COMMENT '角色名称',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台角色表';

/*Data for the table `sysrole` */

insert  into `sysrole`(`id`,`name`) values (1,'超级管理员'),(2,'员工');

/*Table structure for table `sysuser` */

DROP TABLE IF EXISTS `sysuser`;

CREATE TABLE `sysuser` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(100) NOT NULL default '' COMMENT '登录名',
  `password` varchar(100) NOT NULL default '' COMMENT '登录密码',
  `email` varchar(30) default NULL COMMENT '邮件',
  PRIMARY KEY  (`id`),
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `sysuser` */

insert  into `sysuser`(`id`,`username`,`password`,`email`) values (1,'admin','e10adc3949ba59abbe56e057f20f883e',NULL),(2,'tony','e10adc3949ba59abbe56e057f20f883e',NULL),(3,'test1','test1',NULL),(4,'test2','test2',NULL),(5,'test3','test3','sdasda@163.com'),(6,'test4','test4','322@qq.com'),(7,'test5','test5',NULL),(8,'test6','test6',NULL),(9,'test7','test7',NULL),(10,'test8','test8','11@qq.com'),(11,'test9','test9',NULL),(12,'qqqq','','11@qq.com'),(13,'asdasdsa','','11@qq.com');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL auto_increment,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `userId` (`userId`),
  KEY `roleId` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台角色与用户关联表';

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`userId`,`roleId`) values (1,1,1),(2,2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
