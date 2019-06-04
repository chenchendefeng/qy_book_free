package com.only.tech.entity.activity;

import com.only.tech.base.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 额外奖励
 * </p>
 *
 * @author zzb
 * @since 2019-05-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ExtraBonus extends SuperEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableField("cuId")
    private Long cuId;

    /**
     * 金额
     */
    private Long amount;

    /**
     * 倍数
     */
    private Integer multiple;

    /**
     * 状态（0：未兑现；1：已兑现）
     */
    private Integer status;

    /**
     * 过期时间
     */
    @TableField("expiryTime")
    private Date expiryTime;


}
