-- ----------------------------
-- Table structure for b_chapter_0
-- ----------------------------
DROP TABLE IF EXISTS `b_chapter_0`;
CREATE TABLE `b_chapter_0` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `cCID` bigint(20) NOT NULL,
  `cBID` bigint(20) NOT NULL,
  `chaptersort` bigint(20) NULL,
  `chaptertitle` varchar(255) NULL,
  `originalwords` int(11) NULL,
  `vipflag` int(11) NULL,
  `cVID` bigint(20) DEFAULT NULL,
  `amount` int(11) NULL,
  `updatetime` varchar(255) DEFAULT NULL,
  `contentMd5` varchar(255) NULL,
  `contentIssave` int(1) NULL DEFAULT '0' COMMENT '内容是否已经存储',
  PRIMARY KEY (`id`),
  KEY `cCID` (`cCID`,`cBID`) USING BTREE,
  KEY `INDEX_CBID` (`cBID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7755258 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_chapter_1
-- ----------------------------
DROP TABLE IF EXISTS `b_chapter_1`;
CREATE TABLE `b_chapter_1` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `cCID` bigint(20) NOT NULL,
  `cBID` bigint(20) NOT NULL,
  `chaptersort` bigint(20) NULL,
  `chaptertitle` varchar(255) NULL,
  `originalwords` int(11) NULL,
  `vipflag` int(11) NULL,
  `cVID` bigint(20) DEFAULT NULL,
  `amount` int(11) NULL,
  `updatetime` varchar(255) DEFAULT NULL,
  `contentMd5` varchar(255) NULL,
  `contentIssave` int(1) NULL DEFAULT '0' COMMENT '内容是否已经存储',
  PRIMARY KEY (`id`),
  KEY `cCID` (`cCID`,`cBID`) USING BTREE,
  KEY `INDEX_CBID` (`cBID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6396898 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_chapter_2
-- ----------------------------
DROP TABLE IF EXISTS `b_chapter_2`;
CREATE TABLE `b_chapter_2` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `cCID` bigint(20) NOT NULL,
  `cBID` bigint(20) NOT NULL,
  `chaptersort` bigint(20) NULL,
  `chaptertitle` varchar(255) NULL,
  `originalwords` int(11) NULL,
  `vipflag` int(11) NULL,
  `cVID` bigint(20) DEFAULT NULL,
  `amount` int(11) NULL,
  `updatetime` varchar(255) DEFAULT NULL,
  `contentMd5` varchar(255) NULL,
  `contentIssave` int(1) NULL DEFAULT '0' COMMENT '内容是否已经存储',
  PRIMARY KEY (`id`),
  KEY `cCID` (`cCID`,`cBID`) USING BTREE,
  KEY `INDEX_CBID` (`cBID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7510029 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_chapter_3
-- ----------------------------
DROP TABLE IF EXISTS `b_chapter_3`;
CREATE TABLE `b_chapter_3` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `cCID` bigint(20) NOT NULL,
  `cBID` bigint(20) NOT NULL,
  `chaptersort` bigint(20) NULL,
  `chaptertitle` varchar(255) NULL,
  `originalwords` int(11) NULL,
  `vipflag` int(11) NULL,
  `cVID` bigint(20) DEFAULT NULL,
  `amount` int(11) NULL,
  `updatetime` varchar(255) DEFAULT NULL,
  `contentMd5` varchar(255) NULL,
  `contentIssave` int(1) NULL DEFAULT '0' COMMENT '内容是否已经存储',
  PRIMARY KEY (`id`),
  KEY `cCID` (`cCID`,`cBID`) USING BTREE,
  KEY `INDEX_CBID` (`cBID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7339093 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_chapter_4
-- ----------------------------
DROP TABLE IF EXISTS `b_chapter_4`;
CREATE TABLE `b_chapter_4` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `cCID` bigint(20) NOT NULL,
  `cBID` bigint(20) NOT NULL,
  `chaptersort` bigint(20) NULL,
  `chaptertitle` varchar(255) NULL,
  `originalwords` int(11) NULL,
  `vipflag` int(11) NULL,
  `cVID` bigint(20) DEFAULT NULL,
  `amount` int(11) NULL,
  `updatetime` varchar(255) DEFAULT NULL,
  `contentMd5` varchar(255) NULL,
  `contentIssave` int(1) NULL DEFAULT '0' COMMENT '内容是否已经存储',
  PRIMARY KEY (`id`),
  KEY `cCID` (`cCID`,`cBID`) USING BTREE,
  KEY `INDEX_CBID` (`cBID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6315587 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_chapter_5
-- ----------------------------
DROP TABLE IF EXISTS `b_chapter_5`;
CREATE TABLE `b_chapter_5` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `cCID` bigint(20) NOT NULL,
  `cBID` bigint(20) NOT NULL,
  `chaptersort` bigint(20) NULL,
  `chaptertitle` varchar(255) NULL,
  `originalwords` int(11) NULL,
  `vipflag` int(11) NULL,
  `cVID` bigint(20) DEFAULT NULL,
  `amount` int(11) NULL,
  `updatetime` varchar(255) DEFAULT NULL,
  `contentMd5` varchar(255) NULL,
  `contentIssave` int(1) NULL DEFAULT '0' COMMENT '内容是否已经存储',
  PRIMARY KEY (`id`),
  KEY `cCID` (`cCID`,`cBID`) USING BTREE,
  KEY `INDEX_CBID` (`cBID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6317216 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_chapter_6
-- ----------------------------
DROP TABLE IF EXISTS `b_chapter_6`;
CREATE TABLE `b_chapter_6` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `cCID` bigint(20) NOT NULL,
  `cBID` bigint(20) NOT NULL,
  `chaptersort` bigint(20) NULL,
  `chaptertitle` varchar(255) NULL,
  `originalwords` int(11) NULL,
  `vipflag` int(11) NULL,
  `cVID` bigint(20) DEFAULT NULL,
  `amount` int(11) NULL,
  `updatetime` varchar(255) DEFAULT NULL,
  `contentMd5` varchar(255) NULL,
  `contentIssave` int(1) NULL DEFAULT '0' COMMENT '内容是否已经存储',
  PRIMARY KEY (`id`),
  KEY `cCID` (`cCID`,`cBID`) USING BTREE,
  KEY `INDEX_CBID` (`cBID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6317197 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_chapter_7
-- ----------------------------
DROP TABLE IF EXISTS `b_chapter_7`;
CREATE TABLE `b_chapter_7` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `cCID` bigint(20) NOT NULL,
  `cBID` bigint(20) NOT NULL,
  `chaptersort` bigint(20) NULL,
  `chaptertitle` varchar(255) NULL,
  `originalwords` int(11) NULL,
  `vipflag` int(11) NULL,
  `cVID` bigint(20) DEFAULT NULL,
  `amount` int(11) NULL,
  `updatetime` varchar(255) DEFAULT NULL,
  `contentMd5` varchar(255) NULL,
  `contentIssave` int(1) NULL DEFAULT '0' COMMENT '内容是否已经存储',
  PRIMARY KEY (`id`),
  KEY `cCID` (`cCID`,`cBID`) USING BTREE,
  KEY `INDEX_CBID` (`cBID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6351091 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_chapter_8
-- ----------------------------
DROP TABLE IF EXISTS `b_chapter_8`;
CREATE TABLE `b_chapter_8` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `cCID` bigint(20) NOT NULL,
  `cBID` bigint(20) NOT NULL,
  `chaptersort` bigint(20) NULL,
  `chaptertitle` varchar(255) NULL,
  `originalwords` int(11) NULL,
  `vipflag` int(11) NULL,
  `cVID` bigint(20) DEFAULT NULL,
  `amount` int(11) NULL,
  `updatetime` varchar(255) DEFAULT NULL,
  `contentMd5` varchar(255) NULL,
  `contentIssave` int(1) NULL DEFAULT '0' COMMENT '内容是否已经存储',
  PRIMARY KEY (`id`),
  KEY `cCID` (`cCID`,`cBID`) USING BTREE,
  KEY `INDEX_CBID` (`cBID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6356765 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for b_chapter_9
-- ----------------------------
DROP TABLE IF EXISTS `b_chapter_9`;
CREATE TABLE `b_chapter_9` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `cCID` bigint(20) NOT NULL,
  `cBID` bigint(20) NOT NULL,
  `chaptersort` bigint(20) NULL,
  `chaptertitle` varchar(255) NULL,
  `originalwords` int(11) NULL,
  `vipflag` int(11) NULL,
  `cVID` bigint(20) DEFAULT NULL,
  `amount` int(11) NULL,
  `updatetime` varchar(255) DEFAULT NULL,
  `contentMd5` varchar(255) NULL,
  `contentIssave` int(1) NULL DEFAULT '0' COMMENT '内容是否已经存储',
  PRIMARY KEY (`id`),
  KEY `cCID` (`cCID`,`cBID`) USING BTREE,
  KEY `INDEX_CBID` (`cBID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6277241 DEFAULT CHARSET=utf8;

