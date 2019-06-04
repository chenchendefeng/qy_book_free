package com.only.tech.entity.payment;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 对账异常记录表
 * </p>
 *
 * @author Mahone Wu
 * @since 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("p_check_order_diff")
public class PCheckOrderDiff extends SuperEntity<PCheckOrderDiff> {

    private static final long serialVersionUID = 1L;

    /**
     * 账单id
     */
    @TableField("billId")
    private Long billId;

    /**
     * 支付宝交易号or微信订单号
     */
    @TableField("tradeNo")
    private String tradeNo;

    /**
     * 商户订单号
     */
    @TableField("outTradeNo")
    private String outTradeNo;
    private String billDate;
    /**
     * 来源  0-月账单 1-日账单
     */
    private Integer billFrom;
    
    /**
     * 订单完成时间
     */
    @TableField("tradeFinishDate")
    private String tradeFinishDate;

    /**
     * 支付方式：0支付宝 1微信
     */
    @TableField("payMethod")
    private Integer payMethod;
    
    private String totalAmount;

    @TableField("createDate")
    private Date createDate;

    @TableField("updateDate")
    private Date updateDate;


}
