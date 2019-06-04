package com.only.tech.payment.service.push.ios;

import com.only.tech.payment.service.push.common.PushConstants;
import com.only.tech.payment.service.push.hanlder.IOSNotification;

public class IOSFilecast extends IOSNotification {
	public IOSFilecast() throws Exception {
			setAppMasterSecret();
			setPredefinedKeyValue("appkey", PushConstants.APP_KEY);
			this.setPredefinedKeyValue("type", "filecast");	
	}
	
	public void setFileId(String fileId) throws Exception {
    	setPredefinedKeyValue("file_id", fileId);
    }
}
