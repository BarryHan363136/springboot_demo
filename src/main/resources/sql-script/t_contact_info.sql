/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.102
Source Server Version : 50717
Source Host           : 192.168.1.102:3306
Source Database       : testdb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-08 10:40:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_contact_info
-- ----------------------------
DROP TABLE IF EXISTS `t_contact_info`;
CREATE TABLE `t_contact_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `sex` int(1) DEFAULT NULL COMMENT '0男1女',
  `age` int(11) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `zipcode` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_contact_info
-- ----------------------------
INSERT INTO `t_contact_info` VALUES ('1', '张三1', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark1');
INSERT INTO `t_contact_info` VALUES ('2', '张三2', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark2');
INSERT INTO `t_contact_info` VALUES ('3', '张三3', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark3');
INSERT INTO `t_contact_info` VALUES ('4', '张三4', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark4');
INSERT INTO `t_contact_info` VALUES ('5', '张三5', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark5');
INSERT INTO `t_contact_info` VALUES ('6', '张三6', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark6');
INSERT INTO `t_contact_info` VALUES ('7', '张三7', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark7');
INSERT INTO `t_contact_info` VALUES ('8', '张三8', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark8');
INSERT INTO `t_contact_info` VALUES ('9', '张三9', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark9');
INSERT INTO `t_contact_info` VALUES ('10', '张三10', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark10');
INSERT INTO `t_contact_info` VALUES ('11', '张三11', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark11');
INSERT INTO `t_contact_info` VALUES ('12', '张三12', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark12');
INSERT INTO `t_contact_info` VALUES ('13', '张三13', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark13');
INSERT INTO `t_contact_info` VALUES ('14', '张三14', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark14');
INSERT INTO `t_contact_info` VALUES ('15', '张三15', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark15');
INSERT INTO `t_contact_info` VALUES ('16', '张三16', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark16');
INSERT INTO `t_contact_info` VALUES ('17', '张三17', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark17');
INSERT INTO `t_contact_info` VALUES ('18', '张三18', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark18');
INSERT INTO `t_contact_info` VALUES ('19', '张三19', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark19');
INSERT INTO `t_contact_info` VALUES ('20', '张三20', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark20');
INSERT INTO `t_contact_info` VALUES ('21', '张三21', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark21');
INSERT INTO `t_contact_info` VALUES ('22', '张三22', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark22');
INSERT INTO `t_contact_info` VALUES ('23', '张三23', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark23');
INSERT INTO `t_contact_info` VALUES ('24', '张三24', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark24');
INSERT INTO `t_contact_info` VALUES ('25', '张三25', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark25');
INSERT INTO `t_contact_info` VALUES ('26', '张三26', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark26');
INSERT INTO `t_contact_info` VALUES ('27', '张三27', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark27');
INSERT INTO `t_contact_info` VALUES ('28', '张三28', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark28');
INSERT INTO `t_contact_info` VALUES ('29', '张三29', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark29');
INSERT INTO `t_contact_info` VALUES ('30', '张三30', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark30');
INSERT INTO `t_contact_info` VALUES ('31', '张三31', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark31');
INSERT INTO `t_contact_info` VALUES ('32', '张三32', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark32');
INSERT INTO `t_contact_info` VALUES ('33', '张三33', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark33');
INSERT INTO `t_contact_info` VALUES ('34', '张三34', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark34');
INSERT INTO `t_contact_info` VALUES ('35', '张三35', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark35');
INSERT INTO `t_contact_info` VALUES ('36', '张三36', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark36');
INSERT INTO `t_contact_info` VALUES ('37', '张三37', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark37');
INSERT INTO `t_contact_info` VALUES ('38', '张三38', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark38');
INSERT INTO `t_contact_info` VALUES ('39', '张三39', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark39');
INSERT INTO `t_contact_info` VALUES ('40', '张三40', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark40');
INSERT INTO `t_contact_info` VALUES ('41', '张三41', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark41');
INSERT INTO `t_contact_info` VALUES ('42', '张三42', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark42');
INSERT INTO `t_contact_info` VALUES ('43', '张三43', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark43');
INSERT INTO `t_contact_info` VALUES ('44', '张三44', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark44');
INSERT INTO `t_contact_info` VALUES ('45', '张三45', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark45');
INSERT INTO `t_contact_info` VALUES ('46', '张三46', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark46');
INSERT INTO `t_contact_info` VALUES ('47', '张三47', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark47');
INSERT INTO `t_contact_info` VALUES ('48', '张三48', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark48');
INSERT INTO `t_contact_info` VALUES ('49', '张三49', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark49');
INSERT INTO `t_contact_info` VALUES ('50', '张三50', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark50');
INSERT INTO `t_contact_info` VALUES ('51', '张三51', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark51');
INSERT INTO `t_contact_info` VALUES ('52', '张三52', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark52');
INSERT INTO `t_contact_info` VALUES ('53', '张三53', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark53');
INSERT INTO `t_contact_info` VALUES ('54', '张三54', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark54');
INSERT INTO `t_contact_info` VALUES ('55', '张三55', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark55');
INSERT INTO `t_contact_info` VALUES ('56', '张三56', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark56');
INSERT INTO `t_contact_info` VALUES ('57', '张三57', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark57');
INSERT INTO `t_contact_info` VALUES ('58', '张三58', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark58');
INSERT INTO `t_contact_info` VALUES ('59', '张三59', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark59');
INSERT INTO `t_contact_info` VALUES ('60', '张三60', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark60');
INSERT INTO `t_contact_info` VALUES ('61', '张三61', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark61');
INSERT INTO `t_contact_info` VALUES ('62', '张三62', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark62');
INSERT INTO `t_contact_info` VALUES ('63', '张三63', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark63');
INSERT INTO `t_contact_info` VALUES ('64', '张三64', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark64');
INSERT INTO `t_contact_info` VALUES ('65', '张三65', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark65');
INSERT INTO `t_contact_info` VALUES ('66', '张三66', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark66');
INSERT INTO `t_contact_info` VALUES ('67', '张三67', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark67');
INSERT INTO `t_contact_info` VALUES ('68', '张三68', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark68');
INSERT INTO `t_contact_info` VALUES ('69', '张三69', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark69');
INSERT INTO `t_contact_info` VALUES ('70', '张三70', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark70');
INSERT INTO `t_contact_info` VALUES ('71', '张三71', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark71');
INSERT INTO `t_contact_info` VALUES ('72', '张三72', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark72');
INSERT INTO `t_contact_info` VALUES ('73', '张三73', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark73');
INSERT INTO `t_contact_info` VALUES ('74', '张三74', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark74');
INSERT INTO `t_contact_info` VALUES ('75', '张三75', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark75');
INSERT INTO `t_contact_info` VALUES ('76', '张三76', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark76');
INSERT INTO `t_contact_info` VALUES ('77', '张三77', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark77');
INSERT INTO `t_contact_info` VALUES ('78', '张三78', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark78');
INSERT INTO `t_contact_info` VALUES ('79', '张三79', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark79');
INSERT INTO `t_contact_info` VALUES ('80', '张三80', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark80');
INSERT INTO `t_contact_info` VALUES ('81', '张三81', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark81');
INSERT INTO `t_contact_info` VALUES ('82', '张三82', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark82');
INSERT INTO `t_contact_info` VALUES ('83', '张三83', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark83');
INSERT INTO `t_contact_info` VALUES ('84', '张三84', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark84');
INSERT INTO `t_contact_info` VALUES ('85', '张三85', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark85');
INSERT INTO `t_contact_info` VALUES ('86', '张三86', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark86');
INSERT INTO `t_contact_info` VALUES ('87', '张三87', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark87');
INSERT INTO `t_contact_info` VALUES ('88', '张三88', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark88');
INSERT INTO `t_contact_info` VALUES ('89', '张三89', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark89');
INSERT INTO `t_contact_info` VALUES ('90', '张三90', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark90');
INSERT INTO `t_contact_info` VALUES ('91', '张三91', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark91');
INSERT INTO `t_contact_info` VALUES ('92', '张三92', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark92');
INSERT INTO `t_contact_info` VALUES ('93', '张三93', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark93');
INSERT INTO `t_contact_info` VALUES ('94', '张三94', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark94');
INSERT INTO `t_contact_info` VALUES ('95', '张三95', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark95');
INSERT INTO `t_contact_info` VALUES ('96', '张三96', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark96');
INSERT INTO `t_contact_info` VALUES ('97', '张三97', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark97');
INSERT INTO `t_contact_info` VALUES ('98', '张三98', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark98');
INSERT INTO `t_contact_info` VALUES ('99', '张三99', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark99');
INSERT INTO `t_contact_info` VALUES ('100', '张三100', '0', '20', '021-25635874', '13596554288', '上海市黄浦区', '200300', 'test@163.com', 'remark100');
