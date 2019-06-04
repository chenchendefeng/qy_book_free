package com.only.tech.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HUA MAN LOU
 * @since 2019/5/14
 */
@Data
@ApiModel("阅读足迹模型")
public class ReadFootprintDto implements Serializable {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long cuId;

    @ApiModelProperty(value = "书籍id")
    private Long BID;

    @ApiModelProperty(value = "书籍名")
    private String name;

    @ApiModelProperty(value = "封面图")
    private String coverImg;

    @ApiModelProperty(value = "时间")
    private Date createDate;
}
