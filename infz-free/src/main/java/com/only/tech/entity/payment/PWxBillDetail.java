package com.only.tech.entity.payment;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 微信账单详情
 * </p>
 *
 * @author Mahone Wu
 * @since 2018-11-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PWxBillDetail extends SuperEntity<PWxBillDetail> {

    private static final long serialVersionUID = 1L;

    @TableField("billDate")
    private String billDate;

    /**
     * 交易时间
     */
    @TableField("tradeTime")
    private String tradeTime;

    /**
     * 设备号
     */
    @TableField("deviceInfo")
    private String deviceInfo;

    /**
     * 微信订单号
     */
    @TableField("tradeNo")
    private String tradeNo;

    /**
     * 商户订单号
     */
    @TableField("outTradeNo")
    private String outTradeNo;

    /**
     * 用户标识
     */
    @TableField("userFlag")
    private String userFlag;

    /**
     * 付款银行
     */
    @TableField("payBank")
    private String payBank;

    /**
     * 应结订单金额(元)
     */
    @TableField("tradeMoney")
    private String tradeMoney;

    /**
     * 商品名称
     */
    @TableField("goodsName")
    private String goodsName;

    /**
     * 商户数据包
     */
    private String attach;

    /**
     * 手续费
     */
    @TableField("serverAmount")
    private String serverAmount;

    /**
     * 费率
     */
    private String rate;

    /**
     * 本次交易支付的订单金额，单位为人民币（元）
     */
    @TableField("totalAmount")
    private String totalAmount;

    /**
     * 费率备注
     */
    @TableField("rateRemarks")
    private String rateRemarks;

    @TableField("createDate")
    private Date createDate;

    @TableField("updateDate")
    private Date updateDate;


}
