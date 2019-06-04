package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 阅读足迹
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019/5/19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class  ReadFootprint extends SuperEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long cuId;

    /**
     * 书籍id
     */
    @TableField("bid")
    private Long BID;

    /**
     * 创建时间
     */
    @TableField("createDate")
    private Date createDate;


}
