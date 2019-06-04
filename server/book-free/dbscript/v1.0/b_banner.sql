-- ----------------------------
-- Table structure for b_banner
-- ----------------------------
DROP TABLE IF EXISTS `b_banner`;
CREATE TABLE `b_banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `img` varchar(255) NOT NULL COMMENT '图片URL',
  `url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `position` varchar(255) NOT NULL COMMENT '位置(bookStore书库、choice精选、readerGuiding导读)',
  `type` varchar(255) NOT NULL COMMENT 'banner对象类型（book书籍详情、readerGuiding导读详情、famousAuthor大神详情、url链接地址、function功能页面、getReadCard免费领取畅读卡页面 ）',
  `associatedId` varchar(20) DEFAULT NULL COMMENT '关联id,code等',
  `beginTime` datetime DEFAULT NULL COMMENT '轮播图开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '轮播图结束时间',
  `validStatus` int(11) DEFAULT NULL COMMENT '有效状态 1：有效；0；无效',
  `channel` varchar(20) DEFAULT NULL COMMENT '渠道',
  `orderIndex` int(11) DEFAULT NULL COMMENT '排序',
  `bgColor` varchar(255) DEFAULT NULL COMMENT '背景色',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_banner
-- ----------------------------
INSERT INTO `b_banner` VALUES ('56', 'https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/banner_1.png', '', 'bookStore', 'getReadCard', '11023567603485803', '2018-11-27 14:12:41', '2018-12-31 14:12:44', '1', '', null, 'https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/banner1_bg.png', '2018-11-27 14:14:25', '2018-11-27 14:14:27');
INSERT INTO `b_banner` VALUES ('61', 'https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/banner_1.png', null, 'choice', 'getReadCard', null, '2018-11-26 16:08:37', '2018-12-31 16:08:42', '1', null, null, 'https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/banner1_bg.png', '2018-11-27 16:24:24', '2018-11-27 16:24:27');
INSERT INTO `b_banner` VALUES ('63', 'https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/banner_2.png', null, 'choice', 'book', '22344671000280502', '2018-11-29 10:11:51', '2018-12-31 10:14:57', '1', null, null, 'https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/banner2_bg.png', '2018-11-29 13:39:39', '2018-11-29 13:39:42');
INSERT INTO `b_banner` VALUES ('64', 'https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/banner_3.png', null, 'choice', 'book', '2754073000320102', '2018-11-29 10:17:28', '2018-12-31 10:17:34', '1', null, null, 'https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/banner3_bg.png', '2018-11-29 13:39:45', '2018-11-29 13:39:47');
INSERT INTO `b_banner` VALUES ('65', 'https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/banner_4.png', null, 'bookStore', 'book', '4643230703440403', '2018-11-29 11:34:43', '2018-12-31 11:34:46', '1', null, null, 'https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/banner4_bg.png', '2018-11-29 13:39:50', '2018-11-29 13:39:54');
INSERT INTO `b_banner` VALUES ('66', 'https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/banner_5.png', null, 'bookStore', 'book', '9956816804887403', '2018-11-29 11:35:26', '2018-12-31 11:35:29', '1', null, null, 'https://qy-pic.oss-cn-shenzhen.aliyuncs.com/banner/banner5_bg.png', '2018-11-29 13:39:56', '2018-11-29 13:39:59');
