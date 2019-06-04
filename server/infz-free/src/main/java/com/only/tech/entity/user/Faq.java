package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * FAQ
 * </p>
 *
 * @author shoujun.yang
 * @since 2018-10-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Faq extends SuperEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 创建人ID
     */
    @TableField("createUid")
    private Integer createUid;

    /**
     * 创建人logo
     */
    private String logo;

    /**
     * 问题
     */
    private String question;

    /**
     * 回答
     */
    private String answer;

    /**
     * 排序号
     */
    private Integer orderNo;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;

    @TableField("updateTime")
    private Date updateTime;

    /**
     * 渠道
     */
    private String channle;

    /**
     * 状态：0：无效；1：有效；
     */
    private Integer status;
}
