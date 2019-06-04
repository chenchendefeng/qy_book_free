package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;

/**
 * 支付记录表
 * @author shoujun.yang
 * @since 2018-12-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PayRecord extends SuperEntity<PayRecord> {

    private static final long serialVersionUID = 1L;

    private Long uid;

    /**
     * 订单号
     */
    @TableField("payOrderNo")
    private String payOrderNo;

    /**
     * 充值金额，单位分
     */
    @TableField("orderMoney")
    private Integer orderMoney;

    @TableField("readCardId")
    private Long readCardId;
    private Long vipId;

    @TableField("createTime")
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    
    private String systemType;


}
