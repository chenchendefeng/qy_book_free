package com.only.tech.dto.user;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 实体类：用户业务相关信息
 *
 * @author shutong
 * @date 2019/05/20
 */
@Data
@ApiModel
public class CustomerAccountDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 基础信息 **/
	@ApiModelProperty("用户id")
	private Long cuId;

	@ApiModelProperty("昵称")
	private String nickName;

	@ApiModelProperty("用户名")
	private String cuName;

	@ApiModelProperty("头像路径")
	private String avatar;

	@ApiModelProperty("用户状态（ frozen:封号 | frozenByImei:封设备  | drawdown:账户注销  | normal:正常 ）")
	private String userStatus;

	@ApiModelProperty("用户类型（register: 注册用户  |  visitor: 游客  | qyer: 千阅小助手 ）")
	private String userType;

	@ApiModelProperty("vip标示 （vip：会员 | notvip： 非会员）")
	private String vipFlag;

	@ApiModelProperty("会员有效期-start")
	private Date vipStartDate;

	@ApiModelProperty("会员有效期-end")
	private Date vipEndDate;

	@ApiModelProperty("红包码（好友邀请码）")
	private String invitationCode;

	@ApiModelProperty("绑定手机")
	private String bindPhone;

	@ApiModelProperty("手机型号")
	private String phoneModel;

	@ApiModelProperty("客户端（ IOS | Android ）")
	private String source;

	@ApiModelProperty("注册时间")
	private Date regDate;


	/** 账户信息 **/
	@ApiModelProperty("现金")
	private Long rmb;

	@ApiModelProperty("金豆")
	private Long gold;

	@ApiModelProperty("人民币总额")
	private Long rmbTotal;

	/** 其它信息 **/
	@ApiModelProperty("邀请的好友ID集合")
	private List<Long> invitedCuidList;

}