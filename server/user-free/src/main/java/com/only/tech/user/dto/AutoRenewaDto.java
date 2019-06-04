package com.only.tech.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/16
 */
@Data
@ApiModel(value = "自动续费状态")
public class AutoRenewaDto implements Serializable {

    @ApiModelProperty("续费状态：0：未续费；1：已续费")
    private Integer renewaStatus;


    @ApiModelProperty("微信绑定状态：0：未绑定；1：已绑定")
    private Integer wxBindStatus;
}
