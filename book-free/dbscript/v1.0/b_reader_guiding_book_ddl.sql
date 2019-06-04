CREATE TABLE `b_reader_guiding_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `guidingId` bigint(20) NOT NULL DEFAULT '0' COMMENT '导读ID',
  `cBid` bigint(20) DEFAULT NULL COMMENT '书籍ID',
  `orderNo` int(11) DEFAULT NULL COMMENT '排序号(倒序)',
  `valid` smallint(6) DEFAULT '1' COMMENT '有效状态(1:有效 0:无效)',
  `createUid` bigint(20) DEFAULT '0' COMMENT '创建人ID',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_guidingId` (`guidingId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='导读项关联的书';

