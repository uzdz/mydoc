/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.28-cdb2016-log : Database - mydoc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mydoc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mydoc`;

/*Table structure for table `data_type` */

DROP TABLE IF EXISTS `data_type`;

CREATE TABLE `data_type` (
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `department_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门身份标识ID',
  `department_name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `dictionary_table` */

DROP TABLE IF EXISTS `dictionary_table`;

CREATE TABLE `dictionary_table` (
  `dictionary_table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dictionary_table_code` bigint(20) DEFAULT NULL COMMENT '字典表code',
  `dictionary_table_message` varchar(255) DEFAULT NULL COMMENT '字典表描述',
  `dictionary_table_platform` bigint(20) DEFAULT NULL COMMENT '字典所属平台',
  `dictionary_table_rank` int(11) DEFAULT NULL COMMENT '1系统级主错误编码 2业务级公共错误编码 3业务级错误编码',
  PRIMARY KEY (`dictionary_table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8;

/*Table structure for table `global_classify` */

DROP TABLE IF EXISTS `global_classify`;

CREATE TABLE `global_classify` (
  `global_classify_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `global_classify_name` varchar(255) DEFAULT NULL COMMENT '全局变量集合名称',
  `global_classify_status` int(11) DEFAULT NULL COMMENT '是否启用',
  `global_classify_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`global_classify_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Table structure for table `global_variable_field` */

DROP TABLE IF EXISTS `global_variable_field`;

CREATE TABLE `global_variable_field` (
  `global_variable_field_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '全局变量ID',
  `global_field_name` varchar(255) DEFAULT NULL COMMENT '全局字段名称',
  `global_field_type` varchar(11) DEFAULT NULL COMMENT '字段类型',
  `global_field_remark` varchar(255) DEFAULT NULL COMMENT '字段备注',
  `global_field_must` int(255) DEFAULT NULL COMMENT '字段是否必须',
  `global_classify_id` bigint(20) DEFAULT NULL COMMENT '集合标志id',
  `global_request_result_type` int(11) DEFAULT NULL COMMENT '请求响应类型1请求 2响应',
  PRIMARY KEY (`global_variable_field_id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

/*Table structure for table `interface_info` */

DROP TABLE IF EXISTS `interface_info`;

CREATE TABLE `interface_info` (
  `interface_info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '结构主键ID',
  `interface_name` varchar(255) DEFAULT NULL COMMENT '接口名称',
  `method_name` varchar(255) DEFAULT NULL COMMENT '方法名称',
  `method_purpose` varchar(255) DEFAULT NULL COMMENT '方法用途',
  `method_route` varchar(255) DEFAULT NULL COMMENT '方法请求路径',
  `method_request_demo` text COMMENT '方法请求演示',
  `method_result_demo` text COMMENT '方法结构演示',
  `interface_request_mode` varchar(1000) DEFAULT NULL COMMENT '接口请求方式',
  `interface_response_mode` varchar(1000) DEFAULT NULL COMMENT '接口响应方式',
  `interface_create_user_id` bigint(20) DEFAULT NULL COMMENT '接口创建用户ID',
  `interface_create_user_name` varchar(255) DEFAULT NULL COMMENT '接口创建用户名称',
  `platform_doc_id` bigint(20) DEFAULT NULL COMMENT '平台文档ID',
  `platform_doc_module_classify_id` bigint(20) DEFAULT NULL COMMENT '平台文档模块分类ID',
  `interface_status` int(11) DEFAULT NULL COMMENT '接口状态',
  `interface_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `department_id` bigint(20) DEFAULT NULL COMMENT '接口所属部门0全部 1java 2APP 3web',
  `global_classify_id` bigint(20) DEFAULT NULL COMMENT '全局变量集合标识',
  PRIMARY KEY (`interface_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=291 DEFAULT CHARSET=utf8;

/*Table structure for table `interface_request_field` */

DROP TABLE IF EXISTS `interface_request_field`;

CREATE TABLE `interface_request_field` (
  `interface_request_field_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '接口请求字段属性表',
  `field_name` varchar(255) DEFAULT NULL COMMENT '字段名称',
  `field_type` varchar(11) DEFAULT NULL COMMENT '字段类型名称',
  `field_remark` varchar(255) DEFAULT NULL COMMENT '字段备注',
  `interface_info_id` bigint(20) DEFAULT NULL COMMENT '接口信息表ID',
  `field_must` int(255) DEFAULT NULL COMMENT '字段是否必须',
  PRIMARY KEY (`interface_request_field_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1184 DEFAULT CHARSET=utf8;

/*Table structure for table `interface_response_field` */

DROP TABLE IF EXISTS `interface_response_field`;

CREATE TABLE `interface_response_field` (
  `interface_response_field_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '接口响应字段属性表',
  `field_name` varchar(255) DEFAULT NULL COMMENT '字段名称',
  `field_type` varchar(11) DEFAULT NULL COMMENT '字段类型名称',
  `field_remark` varchar(255) DEFAULT NULL COMMENT '字段备注',
  `interface_info_id` bigint(20) DEFAULT NULL COMMENT '接口信息表ID',
  `field_must` int(255) DEFAULT NULL COMMENT '接口是否必须',
  PRIMARY KEY (`interface_response_field_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2645 DEFAULT CHARSET=utf8;

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `permission_name` varchar(32) DEFAULT NULL COMMENT '权限名',
  `permission_sign` varchar(128) DEFAULT NULL COMMENT '权限标识,程序中判断使用,如"user:create"',
  `description` varchar(256) DEFAULT NULL COMMENT '权限描述,UI界面显示使用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='权限表';

/*Table structure for table `platform_doc` */

DROP TABLE IF EXISTS `platform_doc`;

CREATE TABLE `platform_doc` (
  `platform_doc_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '平台文档分类ID',
  `platform_name` varchar(255) DEFAULT NULL COMMENT '平台名称',
  `platform_create_time` datetime DEFAULT NULL COMMENT '平台创建时间',
  `company_name` varchar(255) DEFAULT NULL COMMENT '所属公司名称',
  PRIMARY KEY (`platform_doc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Table structure for table `platform_doc_module_classify` */

DROP TABLE IF EXISTS `platform_doc_module_classify`;

CREATE TABLE `platform_doc_module_classify` (
  `platform_doc_module_classify_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '平台文档模块分类ID',
  `module_name` varchar(255) DEFAULT NULL COMMENT '模块名称',
  `platform_doc_id` bigint(20) DEFAULT NULL COMMENT '平台文档分类名称',
  PRIMARY KEY (`platform_doc_module_classify_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1056 DEFAULT CHARSET=utf8;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名',
  `role_sign` varchar(128) DEFAULT NULL COMMENT '角色标识,程序中判断使用,如"admin"',
  `description` varchar(256) DEFAULT NULL COMMENT '角色描述,UI界面显示使用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表';

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表id',
  `role_id` bigint(20) unsigned DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint(20) unsigned DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色与权限关联表';

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` char(64) DEFAULT NULL COMMENT '密码',
  `status` bigint(32) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户表';

/*Table structure for table `user_department` */

DROP TABLE IF EXISTS `user_department`;

CREATE TABLE `user_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `department_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表id',
  `user_id` bigint(20) unsigned DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) unsigned DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户与角色关联表';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
