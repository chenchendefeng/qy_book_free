CREATE TABLE `b_famous_author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `authorId` bigint(20) NOT NULL COMMENT '作者ID',
  `shortIntro` varchar(20) DEFAULT NULL COMMENT '简短介绍',
  `orderNo` int(11) NOT NULL DEFAULT '0' COMMENT '排序号，倒叙排序',
  `valid` smallint(6) DEFAULT '1' COMMENT '是否有效',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='大神锦集';

