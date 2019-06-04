package com.only.tech.exposeinfz.activity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * dto: 书籍评论列表
 * @author shutong
 * @since 2019-03-18
 */
@Data
@ApiModel
public class AwardItemResDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("奖品编码")
    private String awardCode;

    @ApiModelProperty("实体项目项")
    private List<AwardItemDto> awardItemDtoList;

}
