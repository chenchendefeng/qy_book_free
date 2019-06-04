package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntityWithIntegerID;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 个人中心配置
 * </p>
 *
 * @author zzb
 * @since 2019-04-30
 */
@Data
@ApiModel("个人中心模块模型")
public class PersonalCenter extends SuperEntityWithIntegerID<PersonalCenter> {

    private static final long serialVersionUID = 1L;

    @TableField("mainTitle")
    @ApiModelProperty("主标题")
    private String mainTitle;

    @TableField("mainTitleColor")
    @ApiModelProperty("主标题字色")
    private String mainTitleColor;

    @TableField("subTitle")
    @ApiModelProperty("副标题")
    private String subTitle;

    @TableField("subTitleColor")
    @ApiModelProperty("副标题字色")
    private String subTitleColor;

    @TableField("threeTitle")
    @ApiModelProperty("三标题")
    private String threeTitle;

    @TableField("threeTitleColor")
    @ApiModelProperty("三标题字色")
    private String threeTitleColor;

    @TableField("picUrl")
    @ApiModelProperty("图标")
    private String picUrl;

    /**
     * 跳转去向(VIP+:会员+ ; BOOK_MONEY_RECHARGE:充值书币; MSG_CENTER:消息中心; HELP_FEEDBACK:帮助反馈; BIND_PHONE:绑定手机; SET_UP: 设置; READING_FOOTPRINT:阅读足迹;INVITE_FRIEND:邀请好友；WRITE_INVITATION_CODE:填邀请码)
     */
    @ApiModelProperty("跳转去向")
    private String direction;

    @TableField("directionPath")
    @ApiModelProperty("链接路径")
    private String directionPath;

    @ApiModelProperty("状态（0：停用；1：启用）")
    private Integer status;


    @ApiModelProperty("排序")
    private Integer sort;

    @TableField("createDate")
    @ApiModelProperty("创建时间")
    private Date createDate;

    @TableField("updateDate")
    @ApiModelProperty("更新时间")
    private Date updateDate;


}
