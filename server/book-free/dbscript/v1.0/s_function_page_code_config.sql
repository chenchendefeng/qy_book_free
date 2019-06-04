/*
Navicat MySQL Data Transfer

Source Server         : 192.168.18.210
Source Server Version : 50560
Source Host           : 192.168.18.210:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-11-27 18:07:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_function_page_code_config
-- ----------------------------
DROP TABLE IF EXISTS `s_function_page_code_config`;
CREATE TABLE `s_function_page_code_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `name` varchar(50) NOT NULL COMMENT '功能页面名称',
  `code` varchar(50) NOT NULL COMMENT '功能页面编号',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_function_page_code_config
-- ----------------------------
INSERT INTO `s_function_page_code_config` VALUES ('1', '书架页', 'shu1001', '2018-11-27 16:05:39', '2018-11-27 16:05:42');
INSERT INTO `s_function_page_code_config` VALUES ('2', '热门推荐详情页', 'top2001', '2018-11-27 16:05:45', '2018-11-27 16:05:47');
INSERT INTO `s_function_page_code_config` VALUES ('3', '新书抢购详情页', 'top2002', '2018-11-27 16:08:24', '2018-11-27 16:08:27');
INSERT INTO `s_function_page_code_config` VALUES ('4', '精选好书详情页', 'top2003', '2018-11-27 16:08:52', '2018-11-27 16:08:55');
INSERT INTO `s_function_page_code_config` VALUES ('5', '畅销榜详情页', 'top2004', '2018-11-27 16:09:16', '2018-11-27 16:09:19');
INSERT INTO `s_function_page_code_config` VALUES ('6', '新书榜详情页', 'top2005', '2018-11-27 16:09:36', '2018-11-27 16:09:39');
INSERT INTO `s_function_page_code_config` VALUES ('7', '免费榜详情页', 'top2006', '2018-11-27 16:09:58', '2018-11-27 16:10:00');
INSERT INTO `s_function_page_code_config` VALUES ('8', '限时特价详情页', 'top2007', '2018-11-27 16:10:19', '2018-11-27 16:10:21');
INSERT INTO `s_function_page_code_config` VALUES ('9', '搜索页面', 'top2008', '2018-11-27 16:10:38', '2018-11-27 16:10:42');
INSERT INTO `s_function_page_code_config` VALUES ('10', '我的个人主页', 'my3001', '2018-11-27 16:11:03', '2018-11-27 16:11:05');
INSERT INTO `s_function_page_code_config` VALUES ('11', '我的账户页', 'my3002', '2018-11-27 16:11:21', '2018-11-27 16:11:23');
INSERT INTO `s_function_page_code_config` VALUES ('12', '个人资料编辑', 'my3003', '2018-11-27 16:11:42', '2018-11-27 16:11:44');
INSERT INTO `s_function_page_code_config` VALUES ('13', '畅读卡购买页', 'my3004', '2018-11-27 16:12:03', '2018-11-27 16:12:06');
INSERT INTO `s_function_page_code_config` VALUES ('14', '帮助中心页', 'my3005', '2018-11-27 16:12:21', '2018-11-27 16:12:24');
