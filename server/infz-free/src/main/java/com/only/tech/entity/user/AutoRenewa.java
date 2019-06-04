package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 自动续费
 * </p>
 *
 * @author ZHI
 * @since 2019-01-15
 */
@Data
public class AutoRenewa extends SuperEntity<AutoRenewa> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableField("cuId")
    private Long cuId;

    /**
     * 状态（0：已关闭;1：已开通）
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("createDate")
    private Date createDate;

    /**
     * 更新时间
     */
    @TableField("updateDate")
    private Date updateDate;


}
