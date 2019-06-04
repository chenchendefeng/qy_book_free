package com.only.tech.dto.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * @author HUA MAN LOU
 * @since 2019/5/15
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ApiModel(value = "渠道")
public class ChannleDto implements Serializable {

    @ApiModelProperty(value = "渠道号",name = "channle")
    private String channle;

    @ApiModelProperty(value = "名称",name = "name")
    private String name;
}
