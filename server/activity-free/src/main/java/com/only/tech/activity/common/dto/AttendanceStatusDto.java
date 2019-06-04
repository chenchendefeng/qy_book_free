package com.only.tech.activity.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/23
 */
@Data
@ApiModel("签到状态数据模型")
public class AttendanceStatusDto implements Serializable {

    @ApiModelProperty("状态：0：未签；1：已签")
    private Integer status;

    @ApiModelProperty("是否首签：0：否；1:是")
    private Integer isFrist;

    @ApiModelProperty("连续签到次数")
    private Integer times;

    @ApiModelProperty("奖励金额")
    private Long goldAmount;

    @ApiModelProperty("漏签次数")
    private Integer missedTimes;

    @ApiModelProperty("补签后连续次数")
    private Integer afterCompensateTimes;

    @ApiModelProperty("最大奖励")
    private Long maxAmount;

}
