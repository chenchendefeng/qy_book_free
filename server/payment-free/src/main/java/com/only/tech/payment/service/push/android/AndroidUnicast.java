package com.only.tech.payment.service.push.android;

import com.only.tech.payment.service.push.common.PushConstants;
import com.only.tech.payment.service.push.hanlder.AndroidNotification;

public class AndroidUnicast extends AndroidNotification {
	public AndroidUnicast() throws Exception {
			setAppMasterSecret();
			setPredefinedKeyValue("appkey", PushConstants.APP_KEY);
			this.setPredefinedKeyValue("type", "unicast");	
	}
	
	public void setDeviceToken(String token) throws Exception {
    	setPredefinedKeyValue("device_tokens", token);
    }

}