package com.only.tech.exposeinfz.activity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * DTO: 领奖记录表
 * @author shutong
 * @since 2019/03/12
 */
@Data
@ApiModel
public class AwardReceiveDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    private Long uid;

    @ApiModelProperty("状态：0：未领取；1：已领取")
    private Integer status;

    @ApiModelProperty("活动id")
    private String activityType;

    @ApiModelProperty("奖品id")
    private Long awardId;

    @ApiModelProperty("系统类型")
    private String  systemType;

    @ApiModelProperty("渠道")
    private String channel;

    @ApiModelProperty("创建时间")
    private Date createDate;

    /********其它属性************/
    @ApiModelProperty("活动名称")
    private String activityName;

    @ApiModelProperty("获奖人昵称")
    private String userName;

    @ApiModelProperty("奖品名称")
    private String awardName;


}
