package com.only.tech.payment.service.push.ios;

import com.only.tech.payment.service.push.common.PushConstants;
import com.only.tech.payment.service.push.hanlder.IOSNotification;

public class IOSBroadcast extends IOSNotification {
	public IOSBroadcast() throws Exception {
			setAppMasterSecret();
			setPredefinedKeyValue("appkey", PushConstants.APP_KEY);
			this.setPredefinedKeyValue("type", "broadcast");	
		
	}
}
