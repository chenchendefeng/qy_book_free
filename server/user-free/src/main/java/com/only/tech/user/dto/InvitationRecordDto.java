package com.only.tech.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/14
 */
@Data
@ApiModel("邀请记录数据")
public class InvitationRecordDto implements Serializable {

    @ApiModelProperty("用户id")
    private Long cuId;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像路径")
    private String avatar;

    @ApiModelProperty("是否提醒(0:否|1:是)")
    private Integer remind;

    @ApiModelProperty("完成天数")
    private Integer finishTimes;

    @ApiModelProperty("奖励金额")
    private Long rewardAmount;

}
