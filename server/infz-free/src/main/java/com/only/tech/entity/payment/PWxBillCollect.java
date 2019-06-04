package com.only.tech.entity.payment;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 微信账单汇总
 * </p>
 *
 * @author Mahone Wu
 * @since 2018-11-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PWxBillCollect extends SuperEntity<PWxBillCollect> {

    private static final long serialVersionUID = 1L;

    /**
     * 总交易单数
     */
    @TableField("tradeNCount")
    private Integer tradeNCount;

    /**
     * 应结订单总金额
     */
    @TableField("balanceTotalAmount")
    private String balanceTotalAmount;

    /**
     * 退款总金额
     */
    @TableField("refundTotalAmount")
    private String refundTotalAmount;

    /**
     * 充值券退款总金额
     */
    @TableField("ticketRefundTotalAmount")
    private String ticketRefundTotalAmount;

    /**
     * 手续费总金额
     */
    @TableField("totalServerAmount")
    private String totalServerAmount;

    /**
     * 订单总金额
     */
    @TableField("totalAmount")
    private String totalAmount;

    /**
     * 申请退款总金额
     */
    @TableField("applyRefundTotalAmount")
    private String applyRefundTotalAmount;

    /**
     * 账单日期
     */
    @TableField("billDate")
    private String billDate;

    @TableField("createDate")
    private Date createDate;

    @TableField("updateDate")
    private Date updateDate;


}
