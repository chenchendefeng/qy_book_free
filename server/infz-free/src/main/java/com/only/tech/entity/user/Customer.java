package com.only.tech.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类：用户实体类
 *
 * @author shutong
 * @date 2019/04/28
 */
@Data
@ApiModel
public class Customer implements Serializable {

	@ApiModelProperty("用户id")
	private Long cuId;

	@ApiModelProperty("昵称")
	private String nickName;

	@ApiModelProperty("用户名")
	private String cuName;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("地址")
	private String address;

	@ApiModelProperty("头像路径")
	private String avatar;

	@ApiModelProperty(" 终端：( IOS | Android | H5 )")
	private String source;

	@ApiModelProperty("性别 1:男，2：女，3:其他")
	private Integer sex;

	@ApiModelProperty("机器码")
	private String imei;

	@ApiModelProperty("注册时间")
	private Date regDate;

	@ApiModelProperty("绑定来源：1：代表电话；2：代表微信；4：代表qq；3：代表1+2...")
	private Byte bindSource;

	@ApiModelProperty("绑定手机号")
	private String bindPhone;

	@ApiModelProperty("微信绑定OpenID")
	private String bindOpenid;

	@ApiModelProperty("绑定QQ")
	private String bindQq;

	@ApiModelProperty("注册渠道")
    private String registChannel;

	@ApiModelProperty("手机型号")
	private String phoneModel;

	@ApiModelProperty("用户状态（ frozen:封号 | frozenByImei:封设备  | drawdown:账户注销  | normal:正常 ）")
	private String userStatus;

	@ApiModelProperty("用户类型（register: 注册用户  |  visitor: 游客  | qyer: 千阅小助手 ）")
	private String userType;

	@ApiModelProperty("版本号")
	private String regVersion;

	@ApiModelProperty("vip标示 （vip：会员 | notvip： 非会员）")
	private String vipFlag;

	@ApiModelProperty("会员有效期-start")
	private Date vipStartDate;

	@ApiModelProperty("会员有效期-end")
	private Date vipEndDate;

	@ApiModelProperty("邀请码")
	private String invitationCode;

}