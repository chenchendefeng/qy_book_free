package com.only.tech.payment.service.push.android;

import com.only.tech.payment.service.push.common.PushConstants;
import com.only.tech.payment.service.push.hanlder.AndroidNotification;

public class AndroidFilecast extends AndroidNotification {
	public AndroidFilecast() throws Exception {
			setAppMasterSecret();
			setPredefinedKeyValue("appkey", PushConstants.APP_KEY);
			this.setPredefinedKeyValue("type", "filecast");	
	}
	
	public void setFileId(String fileId) throws Exception {
    	setPredefinedKeyValue("file_id", fileId);
    }
}