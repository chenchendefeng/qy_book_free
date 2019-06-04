package com.only.tech.user.service.handler;

import com.only.tech.user.common.constant.MobApiConstants;
import com.only.tech.user.common.constant.MobApiUrlConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import ooh.chaos.util.HttpUtils;

import java.util.concurrent.Callable;

@Data
@AllArgsConstructor
public class MobCheckTask implements Callable<String> {

	private String phone;
	private String zone;
	private String code;

	@Override
	public String call() throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append("appkey=").append(MobApiConstants.appkey);
		buffer.append("&").append("phone=").append(phone);
		buffer.append("&").append("zone=").append(zone);
		buffer.append("&").append("code=").append(code);
		return HttpUtils.httpPost(MobApiUrlConstants.SMS_VERIFY_URL, buffer.toString());
	}

}
