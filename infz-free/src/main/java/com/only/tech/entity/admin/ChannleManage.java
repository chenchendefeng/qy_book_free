package com.only.tech.entity.admin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntityWithIntegerID;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 渠道管理
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019/5/15
 */
@Data
@TableName("channle_manage")
public class ChannleManage extends SuperEntityWithIntegerID<ChannleManage> {

    private static final long serialVersionUID = 1L;

    /**
     * 渠道号
     */
    private String channle;

    /**
     * 名称
     */
    private String name;

    /**
     * 创建时间
     */
    @TableField("createDate")
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    @TableField("updateDate")
    private LocalDateTime updateDate;

    /**
     * 有效状态(1:有效 0:无效)
     */
    private Integer valid;


}
