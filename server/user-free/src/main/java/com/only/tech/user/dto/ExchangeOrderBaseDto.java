package com.only.tech.user.dto;

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
@ApiModel("兑换记录数据模型")
public class ExchangeOrderBaseDto implements Serializable {

    @ApiModelProperty("兑换名称")
    private String goodsName;

    @ApiModelProperty("时间")
    private Date createTime;

    @ApiModelProperty("订单状态(0：审核中 | 1：审核成功 | 2：审核失败 | 3：红包发送成功 | 4：红包发送失败 ")
    private Integer orderStatus;

}
