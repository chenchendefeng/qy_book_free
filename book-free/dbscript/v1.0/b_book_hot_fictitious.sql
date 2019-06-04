CREATE TABLE `b_book_hot_fictitious` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cBID` bigint(20) NOT NULL COMMENT '书籍ID',
  `count` int(11) DEFAULT NULL COMMENT '阅读次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书籍阅读热度--虚拟数据';
