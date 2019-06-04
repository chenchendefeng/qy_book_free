package com.only.tech.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/17
 */
@Data
@ApiModel("自动续费VIP 信息")
public class RenewaVipInfoDto {

    @ApiModelProperty("金额")
    private Double amount;

    @ApiModelProperty("扣费时间")
    private String vipExpireDate;
}
