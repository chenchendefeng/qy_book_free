package com.only.tech.activity.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/9
 */
@Data
@ApiModel("签到日历")
public class AttendanceCalendarDto implements Serializable {

    @ApiModelProperty("日期")
    private String date;

    @ApiModelProperty("状态（0：未签到；1：已签到）")
    private Integer status;

    @ApiModelProperty("是否可以补签（0：否；1：是）")
    private Integer compensateStatus;

}
