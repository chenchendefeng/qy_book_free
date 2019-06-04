package com.only.tech.dto.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("弹窗模型")
public class PopupWindowReq implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("id")
	private Integer id;

	@ApiModelProperty("类型（0:大弹窗; 1:小弹窗）")
	private Integer windowType;

	@ApiModelProperty("显示类型 0：点击消失 1：一直显示")
	private Integer showType;

	@ApiModelProperty("显示位置")
	private String showPage;

	@ApiModelProperty("跳转类型 0：app内 1：h5")
	private Integer skipType;

	@ApiModelProperty("跳转地址")
	private String skipPage;

	@ApiModelProperty("状态（0：关闭；1启用）")
	private Integer status;

	@ApiModelProperty("图片")
	private String img;

	@ApiModelProperty("渠道号")
	private String channel;

	@ApiModelProperty("客户端类型(Android，IOS，H5，PC，all）")
	private String clientType;

	@ApiModelProperty("开始时间")
	private String startTimeStr;

	@ApiModelProperty("结束时间")
	private String endTimeStr;

	@ApiModelProperty("是否绑定活动 0：否；1：是")
	private Integer bindActivity;

	@ApiModelProperty("活动id")
	private Integer activityId;
}
