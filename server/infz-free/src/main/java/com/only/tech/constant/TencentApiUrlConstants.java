package com.only.tech.constant;

/**
 * 腾讯请求URL常量类
 *
 * @author xiaoshiyilang
 * @dete 2018/10/17
 * @version 1.0
 *
 */
public interface TencentApiUrlConstants {

	/**
	 * 通过code获取微信access_token
	 */
	String WX_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

	String WX_TOKEN_URL_NO_PARAM = "https://api.weixin.qq.com/sns/oauth2/access_token";

	/**
	 * 通过access_token获取微信用户个人信息（单应用）
	 */
	String WX_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
	String WX_USERINFO_URL_NO_PARAM = "https://api.weixin.qq.com/sns/userinfo";

	/**
	 * 通过access_token获取QQ用户个人信息
	 */
	String QQ_USERINFO_URL = "https://graph.qq.com/user/get_user_info?access_token=ACCESS_TOKEN&oauth_consumer_key=OAUTH_CONSUMER_KEY&openid=OPENID";

	String QQ_USERINFO_URL_NO_PARAM = "https://graph.qq.com/user/get_simple_userinfo";

}
