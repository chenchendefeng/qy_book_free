package com.only.tech.user.service.handler;

import com.alibaba.fastjson.JSONObject;
import com.only.tech.base.WxAccessTokenDto;
import com.only.tech.base.WxUserInfoDto;
import com.only.tech.constant.TencentApiConstants;
import com.only.tech.constant.TencentApiUrlConstants;
import com.only.tech.user.common.utils.HttpUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Data
@Slf4j
@AllArgsConstructor
public class QueryWXUserInfoTask implements Callable<WxUserInfoDto> {

	private String code;

	private String getAccessUrl() {
		StringBuilder sb = new StringBuilder(TencentApiUrlConstants.WX_TOKEN_URL_NO_PARAM);
		sb.append("?").append("APPID=").append(TencentApiConstants.WX_APPID);
		sb.append("&").append("SECRET=").append(TencentApiConstants.WX_SECRET);
		sb.append("&").append("CODE=").append(this.code);
		sb.append("&").append("&grant_type=authorization_code");
		return sb.toString();
	}
	
	private String getInfoUrl(WxAccessTokenDto tokenDto){
		StringBuilder sb = new StringBuilder(TencentApiUrlConstants.WX_USERINFO_URL_NO_PARAM);
		sb.append("?").append("ACCESS_TOKEN=").append(tokenDto.getAccessToken());
		sb.append("&").append("OPENID=").append(tokenDto.getOpenid());
		return sb.toString();
		
	}
	/**
	 * 获取access_token
	 * @return
	 */
	private WxAccessTokenDto getWxAccessToken(){
		// 调用腾讯接口重新获取token
		String sendGetRequest = HttpUtils.sendGetRequest(getAccessUrl());
		log.info("=======================>获取的token:" + sendGetRequest);
		if (sendGetRequest.indexOf("access_token") > 0) {
			WxAccessTokenDto dto = new WxAccessTokenDto();
			JSONObject jsonObject = JSONObject.parseObject(sendGetRequest);
			dto.setAccessToken(jsonObject.getString("access_token"));
			dto.setOpenid(jsonObject.getString("openid"));
			return dto;
		}
		log.error("QueryWXUserInfoTask getWxAccessToken get an empty WxAccessTokenDto,code={}",this.code);
		return null;
	}

	@Override
	public WxUserInfoDto call() throws Exception {
		WxAccessTokenDto accessDto = getWxAccessToken();
		WxUserInfoDto dto = new WxUserInfoDto();
		if(accessDto == null){
			return dto;
		}
		// 调用腾讯微信接口获取用户信息
		String sendGetRequest = HttpUtils.sendGetRequest(getInfoUrl(accessDto));
		log.info("=======================>获取的userinfo:" + sendGetRequest + "accessDto:" + accessDto);
		if (sendGetRequest.indexOf("unionid") > 0) {
			JSONObject parse = JSONObject.parseObject(sendGetRequest);
			dto.setOpenid(parse.getString("openid"));
			dto.setNickname(parse.getString("nickname"));
			dto.setSex(parse.getInteger("sex"));
			dto.setProvince(parse.getString("province"));
			dto.setCity(parse.getString("city"));
			dto.setCountry(parse.getString("country"));
			dto.setHeadimgurl(parse.getString("headimgurl"));
			dto.setPrivilege(parse.getJSONArray("privilege").toJavaList(String.class));
			dto.setUnionid(parse.getString("unionid"));
		}
		return dto;
	}

}
