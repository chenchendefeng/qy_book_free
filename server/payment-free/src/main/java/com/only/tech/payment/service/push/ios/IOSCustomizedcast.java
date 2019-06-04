package com.only.tech.payment.service.push.ios;

import com.only.tech.payment.service.push.common.PushConstants;
import com.only.tech.payment.service.push.hanlder.IOSNotification;

public class IOSCustomizedcast extends IOSNotification {
	public IOSCustomizedcast() throws Exception {
			setAppMasterSecret();
			setPredefinedKeyValue("appkey", PushConstants.APP_KEY);
			this.setPredefinedKeyValue("type", "customizedcast");	
	}
	
	public void setAlias(String alias,String aliasType) throws Exception {
    	setPredefinedKeyValue("alias", alias);
    	setPredefinedKeyValue("alias_type", aliasType);
    }
		
	public void setFileId(String fileId, String aliasType) throws Exception {
		setPredefinedKeyValue("file_id", fileId);
		setPredefinedKeyValue("alias_type", aliasType);
	}

}
