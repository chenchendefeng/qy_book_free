package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 账户流水
 * </p>
 *
 * @author zzb
 * @since 2019-05-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AccountFlowRecord extends SuperEntity<AccountFlowRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableField("cuId")
    private Long cuId;

    /**
     * 标题
     */
    private String title;

    /**
     * 类型（recharge:充值;reward：奖励;consume:消费；）
     */
    @TableField("changeType")
    private String changeType;

    /**
     * 具体类型
     */
    @TableField("specificType")
    private String specificType;

    /**
     * 币种（cash：现金；gold：金币）
     */
    @TableField("currencyType")
    private String currencyType;

    /**
     * 金额
     */
    private Long amount;


    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;

    /**
     * 备注
     */
    private String remark;


}
