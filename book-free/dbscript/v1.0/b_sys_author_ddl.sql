CREATE TABLE `b_sys_author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authorname` varchar(32) DEFAULT NULL COMMENT '作者名字',
  `avatar` varchar(255) DEFAULT NULL COMMENT '作者头像',
  `introduction` varchar(512) DEFAULT NULL COMMENT '作者简介',
  `categoryname` varchar(255) DEFAULT NULL,
  `categoryid` bigint(20) DEFAULT NULL COMMENT '分类ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `order_index` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='作者信息';

