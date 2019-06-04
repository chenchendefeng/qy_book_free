package com.only.tech.entity.payment;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 微信支付下单记录表
 * @author Lenovo
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("p_wx_pre_pay_record")
public class WXPrePayRecord extends SuperEntity<WXPrePayRecord> {

    private static final long serialVersionUID = 1L;

    @TableField("appid")
    private String appid;

    /**
     * 商户号
     */
    @TableField("mch_id")
    private String mchId;
    
    /**
     * 设备号
     */
    @TableField("device_info")
    private String deviceInfo;
    
    @TableField("sign_type")
    private String signType;
    
    /**
     * 商品详情
     */
    @TableField("detail")
    private String detail;
    
    /**
     * 附加数据
     */
    @TableField("attach")
    private String attach;
    
    /**
     * 商户订单号
     */
    @TableField("out_trade_no")
    private String outTradeNo;
    
    /**
     * 货币类型
     */
    @TableField("fee_type")
    private String feeType;
    
    /**
     * 总金额
     */
    @TableField("total_fee")
    private Integer totalFee;
    
    /**
     * 终端IP
     */
    @TableField("spbill_create_ip")
    private String spbillCreateIp;
    
    /**
     * 订单开始时间
     */
    @TableField("time_start")
    private String timeStart;
    
    /**
     * 订单失效时间
     */
    @TableField("time_expire")
    private String timeExpire;
    
    /**
     * 通知url
     */
    @TableField("notify_url")
    private String notifyUrl;
    
    @TableField("trade_type")
    private String tradeType;
    
    /**
     * 返回状态码,此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    @TableField("return_code")
    private String returnCode;
    
    /**
     * 返回信息，如非空，为错误原因签名失败,参数格式校验错误
     */
    @TableField("return_msg")
    private String returnMsg;
    
    /**
     * 业务结果	SUCCESS/FAIL
     */
    @TableField("result_code")
    private String resultCode;
    
    /**
     * 错误代码	
     */
    @TableField("err_code")
    private String errCode;
    
    /**
     * 错误代码描述	
     */
    @TableField("err_code_des")
    private String errCodeDes;
    
    /**
     * 预支付交易会话标识
     */
    @TableField("prepay_id")
    private String prepayId;
    
	@TableField("create_date")
	private Date createDate;
	@TableField("update_date")
	private Date updateDate;
	private Long uid;
	/**
	 * 0-支付成功，1-未支付，2-已关闭，3-支付中，4-支付失败
	 */
	@TableField("trade_status")
	private Integer tradeStatus;
	
	private String systemType;
}
