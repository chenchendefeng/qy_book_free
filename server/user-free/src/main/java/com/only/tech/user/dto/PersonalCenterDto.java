package com.only.tech.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/30
 */
@Data
@ApiModel("个人中心模型")
public class PersonalCenterDto implements Serializable {

    @ApiModelProperty("主标题")
    private String mainTitle;

    @ApiModelProperty("主标题字色")
    private String mainTitleColor;

    @ApiModelProperty("副标题")
    private String subTitle;

    @ApiModelProperty("副标题字色")
    private String subTitleColor;

    @ApiModelProperty("三标题")
    private String threeTitle;

    @ApiModelProperty("三标题字色")
    private String threeTitleColor;

    @ApiModelProperty("图标")
    private String picUrl;

    @ApiModelProperty("跳转去向(VIP+:会员+ ; BOOK_MONEY_RECHARGE:充值书币; MSG_CENTER:消息中心; HELP_FEEDBACK:帮助反馈; BIND_PHONE:绑定手机; SET_UP: 设置; READING_FOOTPRINT:阅读足迹;INVITE_FRIEND:邀请好友；WRITE_INVITATION_CODE:填邀请码)")
    private String direction;


    @ApiModelProperty("链接路径")
    private String directionPath;
}
