package com.only.tech.dto.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ZHI ZUN BAO
 * @since 2019/6/3
 */
@Data
@ApiModel("福利类型")
public class WelfareTypeDto {

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("名称")
    private String name;
}
