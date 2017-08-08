/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.102
Source Server Version : 50717
Source Host           : 192.168.1.102:3306
Source Database       : testdb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-08 11:40:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_task_info
-- ----------------------------
DROP TABLE IF EXISTS `t_task_info`;
CREATE TABLE `t_task_info` (
  `id` varchar(50) NOT NULL COMMENT 'id主键',
  `job_name` varchar(300) NOT NULL COMMENT '任务名称',
  `job_group` varchar(300) NOT NULL COMMENT '任务组名',
  `job_status` varchar(255) NOT NULL COMMENT '任务状态 1启用 2删除',
  `cron_expression` varchar(100) NOT NULL COMMENT '任务运行时间表达式',
  `job_description` varchar(255) DEFAULT NULL COMMENT '任务描述',
  `job_todourl` varchar(255) DEFAULT NULL COMMENT '任务执行调用链接',
  `create_by` bigint(20) DEFAULT '0' COMMENT '创建人ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间 - create_time',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人ID',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间 - modfiy_time',
  `is_deleted` char(1) DEFAULT NULL COMMENT '逻辑删除标志',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_group` (`job_name`,`job_group`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志信息表';

-- ----------------------------
-- Records of t_task_info
-- ----------------------------
