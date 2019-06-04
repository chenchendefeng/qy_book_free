package com.only.tech.entity.activity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.only.tech.base.SuperEntityWithIntegerID;
import com.only.tech.enums.ClientTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 弹窗
 * </p>
 *
 * @author zzb
 * @since 2019-04-29
 */
@Data
@ApiModel("弹窗模型")
public class PopupWindow extends SuperEntityWithIntegerID<PopupWindow> {

    private static final long serialVersionUID = 1L;


    @TableField("windowType")
    @ApiModelProperty("类型（0:大弹窗; 1:小弹窗）")
    private Integer windowType;

    @TableField("showType")
    @ApiModelProperty("显示类型 0：点击消失 1：一直显示")
    private Integer showType;


    @TableField("showPage")
    @ApiModelProperty("显示位置")
    private String showPage;


    @TableField("skipType")
    @ApiModelProperty("跳转类型 0：app内 1：h5")
    private Integer skipType;


    @TableField("skipPage")
    @ApiModelProperty("跳转地址")
    private String skipPage;


    @ApiModelProperty("状态（0：关闭；1启用）")
    private Integer status;


    @ApiModelProperty("图片")
    private String img;


    @ApiModelProperty("渠道号")
    private String channel;

    /**
     * 客户端类型(android，ios，H5，pc，all）
     */
    @TableField("clientType")
    @ApiModelProperty("客户端类型(Android，IOS，H5，PC，all）")
    private String clientType;

    @TableField("startTime")
    @ApiModelProperty("开始时间")
    private Date startTime;

    @TableField("endTime")
    @ApiModelProperty("结束时间")
    private Date endTime;

    @TableField("createTime")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 是否绑定活动 0：否；1：是
     */
    @TableField("bindActivity")
    @ApiModelProperty("是否绑定活动 0：否；1：是")
    private Integer bindActivity;

    /**
     * 活动id
     */
     @TableField("activityId")
     @ApiModelProperty("活动id")
    private Integer activityId;



}
