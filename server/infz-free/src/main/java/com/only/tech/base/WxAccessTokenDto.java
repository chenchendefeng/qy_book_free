package com.only.tech.base;

import lombok.Data;

/**
 * ACCESS_TOKEN响应实体类
 * 
 * @author xiaoshiyilang
 * @date 2018/10/17
 * @version 1.0
 */
@Data
public class WxAccessTokenDto {

	/**
	 * 接口调用凭证
	 */
	private String accessToken;

	/**
	 * access_token接口调用凭证超时时间，单位（秒）
	 */
	private Integer expiresIn;

	/**
	 * 用户刷新access_token
	 */
	private String refreshToken;

	/**
	 * 授权用户唯一标识
	 */
	private String openid;

	/**
	 * 用户授权的作用域，使用逗号（,）分隔
	 */
	private String scope;

}
