/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.102
Source Server Version : 50717
Source Host           : 192.168.1.102:3306
Source Database       : testdb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-08 17:24:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_task_info
-- ----------------------------
DROP TABLE IF EXISTS `t_task_info`;
CREATE TABLE `t_task_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(100) NOT NULL,
  `job_group` varchar(100) NOT NULL,
  `job_description` varchar(200) DEFAULT NULL,
  `job_status` int(2) NOT NULL DEFAULT '0' COMMENT '任务状态: 1-启用2；2-停用；3-删除',
  `cron_expression` varchar(100) DEFAULT NULL,
  `create_time` varchar(64) DEFAULT NULL,
  `updata_time` varchar(64) DEFAULT NULL,
  `remark` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task_info
-- ----------------------------
INSERT INTO `t_task_info` VALUES ('1', 'Task测试job', 'JOB-GROUP-TEST', '测试数据', '1', '0/5 * * * * ?', null, null, null);
