-- ---------------------------------------------------------
-- Table structure for u_draw_read_card_record 用户领取畅读卡记录表
-- ---------------------------------------------------------
CREATE TABLE `u_draw_read_card_record` (
  `uid` bigint(20) NOT NULL COMMENT '用户id',
  `drawTime` datetime NOT NULL COMMENT '领取时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;