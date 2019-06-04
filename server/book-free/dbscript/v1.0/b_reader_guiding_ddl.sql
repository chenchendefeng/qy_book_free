CREATE TABLE `b_reader_guiding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bannerImageUrl` varchar(1024) NOT NULL COMMENT '导读栏图片url',
  `detailImageUrl` varchar(1024) NOT NULL COMMENT '详情页图片URL',
  `title` varchar(64) DEFAULT NULL COMMENT '导读标题',
  `intro` varchar(1024) DEFAULT NULL COMMENT '介绍',
  `orderNo` int(11) DEFAULT '0' COMMENT '排序号(倒序)',
  `valid` smallint(6) NOT NULL DEFAULT '1' COMMENT '有效状态(1:有效 0:无效)',
  `createUid` bigint(20) DEFAULT '0' COMMENT '创建人ID',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='导读';

