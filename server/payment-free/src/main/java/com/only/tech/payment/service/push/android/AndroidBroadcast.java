package com.only.tech.payment.service.push.android;

import com.only.tech.payment.service.push.common.PushConstants;
import com.only.tech.payment.service.push.hanlder.AndroidNotification;
import org.springframework.stereotype.Component;

@Component
public class AndroidBroadcast extends AndroidNotification {
	public AndroidBroadcast() throws Exception {
			setAppMasterSecret();
			setPredefinedKeyValue("appkey", PushConstants.APP_KEY);
			this.setPredefinedKeyValue("type", "broadcast");	
	}
}
