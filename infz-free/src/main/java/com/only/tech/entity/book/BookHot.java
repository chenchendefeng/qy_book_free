package com.only.tech.entity.book;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 书籍热度统计
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019/4/29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("book_hot")
public class BookHot extends SuperEntity {

    private static final long serialVersionUID = 1L;

    @TableField("bid")
    private Long bid;

    /**搜索次数*/
    @TableField("searchCount")
    private Long searchCount;

    /**分享次数*/
    @TableField("shareCount")
    private Long shareCount;

    /**收藏次数*/
    @TableField("collectionCount")
    private Long collectionCount;

    /**阅读次数*/
    @TableField("readedCount")
    private Long readedCount;

    /**在读次数*/
    @TableField("readingCount")
    private Long readingCount;
}
