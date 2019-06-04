CREATE TABLE `b_bookinfo_label_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cBID` bigint(20) DEFAULT NULL COMMENT '书籍ID',
  `labelId` int(11) DEFAULT NULL COMMENT '标签ID',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `startTime` datetime DEFAULT NULL COMMENT '开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '结束时间',
  `price` decimal(10,0) DEFAULT NULL COMMENT '价格',
  `isEable` int(2) DEFAULT NULL COMMENT '是否可用 （0：不可用；1：可用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书籍与标签关系表';

