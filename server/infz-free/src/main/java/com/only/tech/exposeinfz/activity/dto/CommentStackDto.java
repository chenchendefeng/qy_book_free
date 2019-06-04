package com.only.tech.exposeinfz.activity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/7
 */
@Data
@ApiModel("评论模型")
public class CommentStackDto implements Serializable {

    @ApiModelProperty("id")
    private Integer id;

    /**
     * 评论星（0-5颗）
     */
    @ApiModelProperty("评论星（0-5颗）")
    private Integer starNum;

    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;

    /**
     * 状态（0：停用;1：启用）
     */
    @ApiModelProperty("状态（0：停用;1：启用）")
    private Integer status;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createDate;
}
