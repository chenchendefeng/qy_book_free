package com.only.tech.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/30
 */
@Data
@ApiModel("兑换礼品模型")
public class ExchangeGoodsDto implements Serializable {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("标记")
    private String marker;

    @ApiModelProperty("金豆数量")
    private Integer cost;
}
