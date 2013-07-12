/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50130
Source Host           : localhost:3306
Source Database       : adsp

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2013-07-08 10:44:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `adsp_client_authority_info`
-- ----------------------------
DROP TABLE IF EXISTS `adsp_client_authority_info`;
CREATE TABLE `adsp_client_authority_info` (
  `id` varchar(100) NOT NULL COMMENT 'ID',
  `client_id` varchar(100) DEFAULT NULL COMMENT '子系统id',
  `service_id` varchar(100) DEFAULT NULL COMMENT '服务ID',
  `service_name` varchar(100) DEFAULT NULL COMMENT '服务名称',
  `note` varchar(500) DEFAULT NULL COMMENT '服务描述',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(100) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(100) DEFAULT NULL COMMENT '建立者IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='子系统权限配置表';

-- ----------------------------
-- Records of adsp_client_authority_info
-- ----------------------------

-- ----------------------------
-- Table structure for `adsp_client_info`
-- ----------------------------
DROP TABLE IF EXISTS `adsp_client_info`;
CREATE TABLE `adsp_client_info` (
  `id` varchar(100) NOT NULL COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT 'version',
  `client_ip` varchar(100) NOT NULL COMMENT '子系统IP',
  `client_code` varchar(100) DEFAULT NULL COMMENT '子系统编号',
  `client_name` varchar(100) DEFAULT NULL COMMENT '子系统名称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(100) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(100) DEFAULT NULL COMMENT '建立者IP',
  `last_updated` datetime DEFAULT NULL COMMENT '资料更新日期',
  `update_id` varchar(100) DEFAULT NULL COMMENT '修改者ID',
  `update_ip` varchar(100) DEFAULT NULL COMMENT '修改者IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='子系统信息';

-- ----------------------------
-- Records of adsp_client_info
-- ----------------------------

-- ----------------------------
-- Table structure for `adsp_data_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `adsp_data_dictionary`;
CREATE TABLE `adsp_data_dictionary` (
  `id` varchar(100) NOT NULL COMMENT 'id',
  `version` int(11) DEFAULT NULL COMMENT 'version',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `note` varchar(100) DEFAULT NULL COMMENT '描述',
  `type_key` varchar(100) NOT NULL COMMENT '分类key',
  `type_name` varchar(100) DEFAULT NULL COMMENT '分类名称',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(100) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(100) DEFAULT NULL COMMENT '建立者IP',
  `last_updated` datetime DEFAULT NULL COMMENT '资料更新日期',
  `update_id` varchar(100) DEFAULT NULL COMMENT '修改者ID',
  `update_ip` varchar(100) DEFAULT NULL COMMENT '修改者IP',
  PRIMARY KEY (`id`,`type_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of adsp_data_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for `adsp_service_config_info`
-- ----------------------------
DROP TABLE IF EXISTS `adsp_service_config_info`;
CREATE TABLE `adsp_service_config_info` (
  `id` varchar(100) NOT NULL COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT 'version',
  `type` varchar(100) DEFAULT NULL COMMENT '类型',
  `db_name` varchar(255) DEFAULT NULL COMMENT '数据库名',
  `db_table_name` varchar(255) DEFAULT NULL COMMENT '数据表名',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `config` longtext COMMENT '配置信息',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  `status` char(1) DEFAULT NULL COMMENT '状态',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(100) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(100) DEFAULT NULL COMMENT '建立者IP',
  `last_updated` datetime DEFAULT NULL COMMENT '资料更新日期',
  `update_id` varchar(100) DEFAULT NULL COMMENT '修改者ID',
  `update_ip` varchar(100) DEFAULT NULL COMMENT '修改者IP',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_adsp_service_config_info_name` (`name`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务配置信息表';

-- ----------------------------
-- Records of adsp_service_config_info
-- ----------------------------

-- ----------------------------
-- Table structure for `adsp_service_logs`
-- ----------------------------
DROP TABLE IF EXISTS `adsp_service_logs`;
CREATE TABLE `adsp_service_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `version` int(11) DEFAULT NULL COMMENT 'version',
  `system` varchar(200) DEFAULT NULL COMMENT '调用系统',
  `port_name` varchar(200) DEFAULT NULL COMMENT '接口名称',
  `service_name` varchar(100) DEFAULT NULL COMMENT '服务名称',
  `service_argument` varchar(5000) DEFAULT NULL COMMENT '调用参数',
  `process_time` bigint(20) DEFAULT NULL COMMENT '处理时间',
  `error_msg` varchar(6000) DEFAULT NULL COMMENT '异常信息',
  `language` varchar(100) DEFAULT NULL COMMENT '接口语言',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(100) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(100) DEFAULT NULL COMMENT '建立者IP',
  `sql_info` text COMMENT 'sql信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8 COMMENT='接口监控日志表';

-- ----------------------------
-- Records of adsp_service_logs
-- ----------------------------

-- ----------------------------
-- Table structure for `adsp_service_sub_info`
-- ----------------------------
DROP TABLE IF EXISTS `adsp_service_sub_info`;
CREATE TABLE `adsp_service_sub_info` (
  `id` varchar(100) NOT NULL COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT 'version',
  `config_id` varchar(100) DEFAULT NULL COMMENT '主服务',
  `sub_config_id` varchar(100) DEFAULT NULL COMMENT '下级服务',
  `node_name` varchar(100) DEFAULT NULL COMMENT '节点名称',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(100) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(100) DEFAULT NULL COMMENT '建立者IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='子服务配置信息表';

-- ----------------------------
-- Records of adsp_service_sub_info
-- ----------------------------

-- ----------------------------
-- Table structure for `adsp_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `adsp_user_info`;
CREATE TABLE `adsp_user_info` (
  `id` varchar(100) NOT NULL COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT 'version',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `pwd` varchar(100) NOT NULL COMMENT '密码',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(100) DEFAULT NULL COMMENT '最后登录IP',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(100) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(100) DEFAULT NULL COMMENT '建立者IP',
  `last_updated` datetime DEFAULT NULL COMMENT '资料更新日期',
  `update_id` varchar(100) DEFAULT NULL COMMENT '修改者ID',
  `update_ip` varchar(100) DEFAULT NULL COMMENT '修改者IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员用户表';

-- ----------------------------
-- Records of adsp_user_info
-- ----------------------------

-- ----------------------------
-- Table structure for `adsp_user_logs`
-- ----------------------------
DROP TABLE IF EXISTS `adsp_user_logs`;
CREATE TABLE `adsp_user_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `type` varchar(100) DEFAULT NULL COMMENT '类型',
  `note` varchar(5000) DEFAULT NULL COMMENT '描述',
  `date_created` datetime DEFAULT NULL COMMENT '数据输入日期',
  `create_id` varchar(100) DEFAULT NULL COMMENT '建立者ID',
  `create_ip` varchar(100) DEFAULT NULL COMMENT '建立者IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=utf8 COMMENT='管理员操作日志表';

-- ----------------------------
-- Records of adsp_user_logs
-- ----------------------------
