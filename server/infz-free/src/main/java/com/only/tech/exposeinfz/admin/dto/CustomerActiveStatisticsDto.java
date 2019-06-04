package com.only.tech.exposeinfz.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2018/12/22
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ApiModel(value = "用户活跃统计")
public class CustomerActiveStatisticsDto implements Serializable {


    private Integer id;

    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private String date;

    /**
     * 客户端
     */
    @ApiModelProperty(value = "客户端")
    private String clientType;

    /**
     * 渠道
     */
    @ApiModelProperty(value = "渠道")
    private String channel;

    /**
     * 注册数量
     */
    @ApiModelProperty(value = "注册数量")
    private Integer registerCount;

    /**
     * 当前活跃数量
     */
    @ApiModelProperty(value = "当前活跃数量")
    private Integer currentActiveCount;

    /**
     * 平均登录次数
     */
    @ApiModelProperty(value = "平均登录次数")
    private Integer avgLoginCount;

    /**
     * 平均阅读时常
     */
    @ApiModelProperty(value = "平均阅读时常  秒")
    private Long avgReadTime;

    /**
     * 3日活跃
     */
    @ApiModelProperty(value = "3日活跃")
    private Integer threeDayActive;

    /**
     * 7天活跃量
     */
    @ApiModelProperty(value = "7天活跃量")
    private Integer sevenDayActive;
}
