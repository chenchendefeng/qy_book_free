package com.only.tech.user.common.utils;

import java.util.HashMap;
import java.util.Map;

import com.only.tech.constant.TencentApiConstants;
import com.only.tech.user.common.constant.MobApiConstants;
import com.only.tech.user.common.constant.MobApiUrlConstants;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import ooh.chaos.util.HttpUtils;

/**
 * 服务端发起验证请求验证移动端(手机)发送的短信
 * 
 * @author xiaoshiyilang
 * @date 2018/11/05
 * @version 1.0
 */
public class SmsVerifyKit {

	private String appkey;
	private String phone;
	private String zone;
	private String code;

	/**
	 * 
	 * @param appkey
	 *            应用KEY
	 * @param phone
	 *            电话号码 xxxxxxxxx
	 * @param zone
	 *            区号 86
	 * @param code
	 *            验证码 xx
	 */
	public SmsVerifyKit(String appkey, String phone, String zone, String code) {
		super();
		this.appkey = appkey;
		this.phone = phone;
		this.zone = zone;
		this.code = code;
	}

	/**
	 * 服务端发起验证请求验证移动端(手机)发送的短信
	 * 
	 * @return
	 * @throws Exception
	 */
	public String go() throws Exception {

		String address = MobApiUrlConstants.SMS_VERIFY_URL;
		MobClient client = null;
		try {
			client = new MobClient(address);
			client.addParam("appkey", appkey).addParam("phone", phone).addParam("zone", zone).addParam("code", code);
			client.addRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			client.addRequestProperty("Accept", "application/json");
			String result = client.post();
			return result;
		} finally {
			client.release();
		}
	}
	
}
