package com.only.tech.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/6/3
 */
@Data
@ApiModel("用户账户")
public class AccountDto implements Serializable {

    @ApiModelProperty("金豆")
    private Long gold;

    @ApiModelProperty("人民币")
    private Double rmb;

}
