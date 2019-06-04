package com.only.tech.payment.service.push.common;

public class PushConstants {
	public static final String APP_KEY = "5bf51581b465f52f7200017a";
	public static final String UMENG_MESSAGE_SECRET = "edd73e3ee91c0f0a71165ae1eecdce53";
	public static final String APP_MASTER_SECRET = "kbphq6vihnmw15qbb5wyekffnovypigf";
	

	// The host
	public static final String host = "http://msg.umeng.com";

	// The upload path
	public static final String uploadPath = "/upload";

	// The post path
	public static final String pushPath = "/api/send";
	
	public static final String tagPath = "/api/tag/";
	
	public static final String queryPath = "/api/status";
	public static final String cancelPath = "/api/cancel";
}
