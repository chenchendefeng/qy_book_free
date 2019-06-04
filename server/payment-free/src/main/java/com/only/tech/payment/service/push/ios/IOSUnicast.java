package com.only.tech.payment.service.push.ios;

import com.only.tech.payment.service.push.common.PushConstants;
import com.only.tech.payment.service.push.hanlder.IOSNotification;

public class IOSUnicast extends IOSNotification {
	public IOSUnicast() throws Exception{
			setAppMasterSecret();
			setPredefinedKeyValue("appkey", PushConstants.APP_KEY);
			this.setPredefinedKeyValue("type", "unicast");	
	}
	
	public void setDeviceToken(String token) throws Exception {
    	setPredefinedKeyValue("device_tokens", token);
    }
}
