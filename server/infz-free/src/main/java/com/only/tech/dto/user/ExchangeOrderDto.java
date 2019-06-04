package com.only.tech.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/22
 */
@Data
@ApiModel("兑换订单数据模型")
public class ExchangeOrderDto implements Serializable {


    @ApiModelProperty("用户ID")
    private Long cuId;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像路径")
    private String avatar;

    @ApiModelProperty("注册时间")
    private Date regDate;

    @ApiModelProperty("订单号")
    private String orderNo;

    @ApiModelProperty("礼品名称")
    private String goodsName;

    @ApiModelProperty("礼品类型（gold:金豆 | rmb:人民币）")
    private String exchangeType;

    @ApiModelProperty("消耗量")
    private Integer cost;

    @ApiModelProperty("审核时间")
    private Date auditTime;

    @ApiModelProperty("订单状态(0：审核中 | 1：审核成功 | 2：审核失败 | 3：微信发送处理中 | 4：红包发送成功 | 5：红包发送失败  ）")
    private Integer orderStatus;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("扣除前余额")
    private Long noDeduction;

    @ApiModelProperty("扣除后余额")
    private Long deductioned;

}
