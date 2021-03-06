-- ----------------------------
-- Table structure for b_book_info
-- ----------------------------
DROP TABLE IF EXISTS `b_book_info`;
CREATE TABLE `b_book_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cBID` bigint(20) NOT NULL COMMENT '书号',
  `allwords` int(11) DEFAULT NULL COMMENT '总字数',
  `authorid` bigint(20) DEFAULT NULL COMMENT '作者id',
  `authorname` varchar(255) DEFAULT NULL COMMENT '作者名',
  `categoryid` int(11) DEFAULT NULL COMMENT '二级分类',
  `coverurl` varchar(255) DEFAULT NULL COMMENT '封面图',
  `createtime` varchar(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `subcategoryid` int(11) DEFAULT NULL COMMENT '三级分类',
  `title` varchar(255) DEFAULT NULL COMMENT '小说名',
  `vipstatus` int(11) DEFAULT NULL COMMENT '-1:公众 1:VIP',
  `viptime` varchar(20) DEFAULT NULL,
  `intro` mediumtext COMMENT '书籍简介',
  `keyword` varchar(255) DEFAULT NULL COMMENT '关键字',
  `tag` varchar(255) DEFAULT NULL COMMENT '标签',
  `updatetime` varchar(20) DEFAULT NULL COMMENT '更新时间',
  `site` int(11) DEFAULT NULL COMMENT '5:起点男生 1:创世 2:云起 3:起点女生 6:阅文集团 9:起点文学网',
  `cPID` bigint(20) DEFAULT NULL,
  `form` int(11) DEFAULT NULL,
  `chargetype` varchar(255) DEFAULT NULL,
  `unitprice` int(11) DEFAULT NULL COMMENT '千字价格（单位：分）',
  `totalprice` int(11) DEFAULT NULL COMMENT '按本计费价格',
  `fileFormat` int(11) DEFAULT NULL COMMENT '按位标识本书全部文件格式',
  `monthlyallowed` int(11) DEFAULT NULL COMMENT '是否允许包月 -1: 否 1:是',
  `monthlytime` varchar(255) DEFAULT NULL,
  `cancelmonthlytime` varchar(255) DEFAULT NULL,
  `tokens` varchar(255) DEFAULT NULL COMMENT '配置显示的标签',
  `buyTimes` int(11) DEFAULT '0' COMMENT '购买次数',
  `lastUpdateContent` varchar(255) DEFAULT NULL,
  `chapterImported` tinyint(4) DEFAULT '0',
  `volumeImported` tinyint(4) DEFAULT '0',
  `contentImported` tinyint(4) DEFAULT '0',
  `importedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cbid` (`cBID`) USING BTREE,
  KEY `content_imported` (`contentImported`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=275617 DEFAULT CHARSET=utf8 COMMENT='书籍信息';
