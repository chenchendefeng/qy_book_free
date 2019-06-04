CREATE TABLE `b_faq` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `createUid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `logo` varchar(255) DEFAULT NULL COMMENT '创建人logo',
  `question` varchar(255) DEFAULT NULL COMMENT '问题',
  `answer` varchar(255) DEFAULT NULL COMMENT '回答',
  `orderNo` int(11) DEFAULT NULL COMMENT '排序号',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

