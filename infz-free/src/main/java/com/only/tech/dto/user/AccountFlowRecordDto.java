package com.only.tech.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/5
 */
@Data
@ApiModel("账户流水数据")
public class AccountFlowRecordDto implements Serializable {

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("类型（recharge:充值;reward：奖励;consume:消费；）")
    private String changeType;

    @ApiModelProperty("币种")
    private String currencyType;

    @ApiModelProperty("金额")
    private Double amount;

    @ApiModelProperty("时间")
    private Date createTime;

}
