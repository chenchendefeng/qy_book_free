/*
Navicat MySQL Data Transfer

Source Server         : 192.168.18.210
Source Server Version : 50560
Source Host           : 192.168.18.210:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-11-30 17:44:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_user_book_update_time
-- ----------------------------
DROP TABLE IF EXISTS `b_user_book_update_time`;
CREATE TABLE `b_user_book_update_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `cBID` bigint(20) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='用户对书操作的最近时间';
