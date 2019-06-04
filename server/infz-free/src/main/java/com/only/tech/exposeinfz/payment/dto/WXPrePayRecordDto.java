package com.only.tech.exposeinfz.payment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * DTO: 订单管理
 * @author shutong
 * @since  2019/02/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class WXPrePayRecordDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品详情")
    private String detail;
    
    @ApiModelProperty("商户订单号")
    private String outTradeNo;
    
    @ApiModelProperty("货币类型")
    private String feeType;
    
    @ApiModelProperty("总金额")
    private Integer totalFee;

    @ApiModelProperty("订单开始时间")
    private String timeStart;
    
    @ApiModelProperty("订单失效时间")
    private String timeExpire;
    
    @ApiModelProperty("交易类型")
    private String tradeType;

    @ApiModelProperty("错误代码描述")
    private String errCodeDes;

    @ApiModelProperty("记录创建时间")
	private Date createDate;

    @ApiModelProperty("记录修改时间")
	private Date updateDate;

    @ApiModelProperty("用户ID")
	private Long uid;

    @ApiModelProperty(" 0-支付成功，1-未支付，2-已关闭，3-支付中，4-支付失败")
	private Integer tradeStatus;

    @ApiModelProperty("系统类型： Android | IOS ")
	private String systemType;
}
