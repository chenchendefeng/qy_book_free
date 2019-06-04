CREATE TABLE `b_user_read_book_process` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `uid` bigint(20) DEFAULT NULL COMMENT '用户id',
  `cBID` bigint(20) DEFAULT NULL COMMENT '书籍id',
  `cCID` bigint(20) DEFAULT NULL COMMENT '章节id',
  `readWords` int(10) DEFAULT NULL COMMENT '阅读了多少字',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateDate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid_cBID` (`uid`,`cBID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户阅读书籍进度表';