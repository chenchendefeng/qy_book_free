package com.only.tech.exposeinfz.user.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户响应实体类
 * 
 * @author xiaoshiyilang
 * @date 2018/10/23
 * @version 1.0
 */
@Data
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	private Long uid;

	/**
	 * 用户昵称
	 */
	private String name;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 头像路径
	 */
	private String avatar;

	/**
	 * 积分
	 */
	private Integer score;

	/**
	 * IOS, Android, H5
	 */
	private String source;

	/**
	 * 性别 1:男，2：女，3通吃
	 */
	private Integer sex;

	/**
	 * 设备码
	 */
	private String imei;

	/**
	 * 未知字段
	 */
	private Long guid;

	/**
	 * 未知字段
	 */
	private Float lat;

	/**
	 * 未知字段
	 */
	private Float lng;

	/**
	 * 未知字段
	 */
	private Integer ticket;

	/**
	 * 未知字段
	 */
	private Integer money;

	/**
	 * 注册时间
	 */
	private Date regDate;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 未知字段
	 */
	private String unionId;

	/**
	 * 书币余额
	 */
	private Long bookMoney;

	/**
	 * 赠币余额
	 */
	private Long bookBonus;

	/**
	 * 0：真账号,1：假账号
	 */
	private Byte isReal;

	/**
	 * 未知字段
	 */
	private String sn;

	/**
	 * 未知字段
	 */
	private Boolean isBind;

	/**
	 * 1代表电话2代表微信4代表qq3代表1+2...
	 */
	private Byte bindSource;

	/**
	 * 绑定手机号
	 */
	private String bindPhone;

	/**
	 * 绑定OpenID
	 */
	private String bindOpenid;

	/**
	 * 绑定QQ
	 */
	private String bindQq;

	/**
	 * 未知字段
	 */
	private String uuid;

	/**
	 * 用户是否是畅读卡0不是 1是
	 */
	private Integer isReadCard;

	/**
	 * 畅读卡过期时间
	 */
	private String userReadCardTime;

	/**
	 * 用户阅读时长
	 */
	private Long readingTime;
	
    private String registChannel;

	/**
	 * 用户状态：  frozen:封号 | frozenByImei:封设备  | drawdown:账户注销  | normal:正常
	 */
	private String userStatus;


	/**
	 * 手机型号
	 */
	private String phoneModel;

	/**
	 * 版本号
	 */
	private String regVersion;

}
