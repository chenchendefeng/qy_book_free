-- ----------------------------
-- Table structure for b_volumn
-- ----------------------------
DROP TABLE IF EXISTS `b_volumn`;
CREATE TABLE `b_volumn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cBID` bigint(20) NOT NULL,
  `cVID` bigint(20) NOT NULL,
  `volumesort` int(11) NULL,
  `volumename` varchar(255) NULL,
  `volumedesc` varchar(500) NULL,
  PRIMARY KEY (`id`),
  KEY `index_CVID` (`cVID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=622145 DEFAULT CHARSET=utf8;
