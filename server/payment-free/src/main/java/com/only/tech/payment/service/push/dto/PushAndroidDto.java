package com.only.tech.payment.service.push.dto;

import com.only.tech.payment.service.push.common.DisplayType;
import lombok.Data;
import org.json.JSONObject;

@Data
public class PushAndroidDto {
	private JSONObject filterJson;
	//通知栏提示文字
	private String ticker;
	// 必填，通知标题
	private String title;
	// 必填，通知文字描述 
	private String text;
	private String startTime;
	
	private Policy policy;
	
	private JSONObject extra;
	private String deviceToken;
	
	private String alias;
	private String aliasType;
	private String fileId;
	
	private DisplayType disPlayType;
	
	private String content;
}
