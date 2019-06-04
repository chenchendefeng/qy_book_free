package com.only.tech.entity.payment;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntityWithIntegerID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 订单支付成功添加会员失败记录表
 * </p>
 *
 * @author ZHI
 * @since 2019-03-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class OrderAddVipTimeFaillRecord extends SuperEntityWithIntegerID<OrderAddVipTimeFaillRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 订单号
     */
    @TableField("orderNo")
    private String orderNo;

    /**
     * 状态（0：未处理；1：处理成功；2：处理失败）
     */
    private Integer status;

    @TableField("createDate")
    private Date createDate;

    @TableField("updateDate")
    private Date updateDate;


}
