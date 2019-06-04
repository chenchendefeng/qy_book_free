package com.only.tech.entity.payment;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("p_wx_trade_result")
public class WXTradeResultEntity extends SuperEntity<GoodsOrder> {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /*
     * 返回状态码，此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    @TableField("return_code")
    private String returnCode;
    /*
     * 返回信息，如非空，为错误原因签名失败,参数格式校验错误
     */
    @TableField("return_msg")
    private String returnMsg;
    /*
     * 应用APPID
     */
    @TableField("appid")
    private String appid;
    /*
     * 商户号
     */
    @TableField("mch_id")
    private String mchId;
    /*
     * 业务结果
     */
    @TableField("result_code")
    private String resultCode;
    /*
     * 错误代码
     */
    @TableField("err_code")
    private String errCode;
    /*
     * 错误代码描述
     */
    @TableField("err_code_des")
    private String errCodeDes;
    /*
     * 用户标识
     */
    @TableField("openid")
    private String openid;
    /*
     * 交易状态
     * SUCCESS—支付成功 REFUND—转入退款 NOTPAY—未支付 CLOSED—已关闭 REVOKED—已撤销（刷卡支付） USERPAYING--用户支付中 PAYERROR--支付失败(其他原因，如银行返回失败)
     */
    @TableField("trade_state")
    private String tradeState;
    /*
     * 付款银行
     */
    @TableField("bank_type")
    private String bankType;
    /*
     * 总金额
     */
    @TableField("total_fee")
    private Integer totalFee;
    /*
     * 微信支付订单号
     */
    @TableField("transaction_id")
    private String transactionId;
    /*
     * 商户订单号
     */
    @TableField("out_trade_no")
    private String outTradeNo;
    /*
     * 附加数据
     */
    @TableField("attach")
    private String attach;
    /*
     * 支付完成时间
     */
    @TableField("time_end")
    private String timeEnd;
    /*
     * 交易状态描述
     */
    @TableField("trade_state_desc")
    private String tradeStateDesc;

    /**
     * 委托协议
     */
    @TableField("contract_id")
    private String contractId;


    /**
     * 结果类型 0：异步通知 1：主动查询
     */
    @TableField("result_type")
    private Integer resultType;

    @TableField("create_date")
    private Date createDate;
    @TableField("update_date")
    private Date updateDate;
}
