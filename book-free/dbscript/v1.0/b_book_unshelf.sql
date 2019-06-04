/*
Navicat MySQL Data Transfer

Source Server         : 192.168.18.18
Source Server Version : 50715
Source Host           : 192.168.18.18:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-11-12 13:47:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_book_unshelf
-- ----------------------------
DROP TABLE IF EXISTS `b_book_unshelf`;
CREATE TABLE `b_book_unshelf` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cbid` bigint(20) NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
