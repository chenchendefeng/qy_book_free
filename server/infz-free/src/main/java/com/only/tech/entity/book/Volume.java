package com.only.tech.entity.book;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 书籍 卷信息
 * </p>
 *
 * @author ZZB
 * @since 2019-04-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Volume extends SuperEntity<Volume> {

    private static final long serialVersionUID = 1L;

    private Long bid;

    private Long vid;

    @TableField("volumeTitle")
    private String volumeTitle;

    /**
     * 卷排序
     */
    @TableField("volumeSort")
    private Integer volumeSort;


}
