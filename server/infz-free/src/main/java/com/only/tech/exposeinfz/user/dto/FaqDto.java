package com.only.tech.exposeinfz.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HUA MAN LOU
 * @since 2019/5/7
 */
@Data
@ApiModel(value = "帮助反馈")
public class FaqDto implements Serializable {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("创建人id")
    private Integer createUid;

    @ApiModelProperty("创建人头像")
    private String logo;

    @ApiModelProperty("问题")
    private String question;

    @ApiModelProperty("回答")
    private String answer;

    /**
     * 排序号
     */
    @ApiModelProperty("排序号")
    private Integer orderNo;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 渠道
     */
    @ApiModelProperty("渠道")
    private String channle;

    @ApiModelProperty("状态：0：无效；1：有效")
    private Integer status;
}
