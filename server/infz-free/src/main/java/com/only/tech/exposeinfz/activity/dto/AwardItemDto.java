package com.only.tech.exposeinfz.activity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * DTO ：实物奖品表
 * @author shutong
 * @since 2019/03/13
 */
@Data
@ApiModel
public class AwardItemDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("奖品ID")
    private Long awardId;

    @ApiModelProperty("奖品名称")
    private String awardItemName;

    @ApiModelProperty("奖品数额")
    private Integer amount;

    @ApiModelProperty("中奖概率（eg: 0.1 ）")
    private Double odds;

}
