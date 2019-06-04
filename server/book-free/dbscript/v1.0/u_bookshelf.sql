-- 修改原有字段
ALTER TABLE u_bookshelf CHANGE s_id id BIGINT; -- 主键
ALTER TABLE u_bookshelf CHANGE u_id uid BIGINT; -- 用户uid
ALTER TABLE u_bookshelf CHANGE create_date createDate datetime; -- 创建时间



-- 新增字段
ALTER TABLE u_bookshelf ADD updateDate datetime DEFAULT NULL COMMENT '修改时间，用于置顶排序'; -- 
ALTER TABLE u_bookshelf ADD lastReadChapterId bigint(20) DEFAULT NULL COMMENT '最后阅读的章节id';
ALTER TABLE u_bookshelf ADD isTop INT DEFAULT 0 COMMENT '是否置顶  0：不置顶；1：置顶';


-- 设置将create_date 时间填入update_date 
UPDATE u_bookshelf SET updateDate = createDate;