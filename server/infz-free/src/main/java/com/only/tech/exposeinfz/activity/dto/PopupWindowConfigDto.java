package com.only.tech.exposeinfz.activity.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("弹窗数据模型")
public class PopupWindowConfigDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;

	@ApiModelProperty("窗口类型 0：大窗 1：小窗")
	private Integer windowType;

	@ApiModelProperty("小窗显示类型 0：一直显示 1：点击消失")
	private Integer showType;

	@ApiModelProperty("跳转地址")
	private String skipUrl;

	@ApiModelProperty("跳转类型 0：app内 1：h5")
	private Integer skipType;

	@ApiModelProperty("展示页面 0：书库1：精选2：导读3：我的4：书架")
	private Integer showPage;

	@ApiModelProperty("图片")
	private String img;

	@ApiModelProperty("渠道")
	private String channel;

	@ApiModelProperty("系统类型 0：全部 1：安卓2：ios")
	private Integer systemType;

	@ApiModelProperty("状态 0：启用1：停用")
	private Integer status;

	@ApiModelProperty("展示开始时间")
	private LocalDateTime showStartDate;

	@ApiModelProperty("展示结束时间")
	private LocalDateTime showEndDate;

	@ApiModelProperty("")
	private LocalDateTime createDate;

	@ApiModelProperty("是否绑定活动 （0：否 | 1：是）")
	private Integer bindActivity;

	@ApiModelProperty("活动类型")
	private String activityType;
}
