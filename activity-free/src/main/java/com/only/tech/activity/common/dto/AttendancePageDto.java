package com.only.tech.activity.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/9
 */
@Data
@ApiModel("签到页数据")
public class AttendancePageDto implements Serializable {

    @ApiModelProperty("连续签到次数")
    private Integer times;

    @ApiModelProperty("奖励列表")
    private List<AttendanceRewardDto> rewardList;

    @ApiModelProperty("签到日历")
    private List<AttendanceCalendarDto> attendanceCalendar;

}
