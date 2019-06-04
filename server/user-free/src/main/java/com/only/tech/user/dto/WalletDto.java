package com.only.tech.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/5
 */
@Data
@ApiModel("钱包模型")
public class WalletDto implements Serializable {

    @ApiModelProperty("人民币余额")
    private double rmbalance;

    @ApiModelProperty("金币余额")
    private Long goldBalance;

    @ApiModelProperty("人民币总额")
    private double rmbTotal;

}
