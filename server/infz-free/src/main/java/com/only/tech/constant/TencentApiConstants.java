package com.only.tech.constant;

/**
 * 腾讯接口常量类
 * 
 * @author xiaoshiyilang
 * @date 2018/10/17
 * @version 1.0
 */
public interface TencentApiConstants {

	/** 微信appid*/
	String WX_APPID = "wx1f9ae90e23e42cb7";

	/** 公众号APP_ID*/
	String FREE_APP_ID = "wx52100139f9d474b8";

	/** 微信商户号*/
	String MCH_ID = "1492556692";

	/** 商户名称*/
	String MCH_NAME = "深圳市维奕科技";//商户名称

	/**发红包场景*/
	String PRODUCT_1 = "PRODUCT_1";//商品促销
	String PRODUCT_2 = "PRODUCT_2";//抽奖
	String PRODUCT_3 = "PRODUCT_3";//虚拟物品兑奖
	String PRODUCT_4 = "PRODUCT_4";//企业内部福利
	String PRODUCT_5 = "PRODUCT_5";//渠道分润
	String PRODUCT_6 = "PRODUCT_6";//保险回馈
	String PRODUCT_7 = "PRODUCT_7";//彩票派奖
	String PRODUCT_8 = "PRODUCT_8";//税务刮奖

	/**微信自动续费 - 签约模板id*/
	String PLAN_ID = "124103";

	/** 证书路径 */
	String CERT_URL = "/pay/wx/apiclient_cert.p12";

	/** 微信secret*/
	String WX_SECRET = "6bf3ed20191b5f5a93c44ec64abff9b3";

	/** access_token缓存key值*/
	String TOKEN_REDIS_KEY = "_TOKEN_REDIS_KEY";

	/** 安卓QQ的appid（oauth_consumer_key/client_id）*/
	Integer A_QQ_APPID = 1106608664;
	String A_QQ_APPID_STR = "1106608664";
	/*** 安卓QQ的appkey（auth_consumer_secret/client_secret）*/
	String A_QQ_APPKEY = "PjjNaQx5IgqtS5dm";

	/*** iosQQ的appid（oauth_consumer_key/client_id）*/
	Integer I_QQ_APPID = 1107961556;
	String I_QQ_APPID_STR = "1107961556";

	/** 安卓QQ的appkey（auth_consumer_secret/client_secret）*/
	String I_QQ_APPKEY = "I0hf7AhgVOg889Gf";

	/** 申请扣费返回uri*/
	String WX_DEDUCTION_NOTIFY_URL = "/renewa/deduction/notify";
	/** 查询签约关系的url*/
	String WX_CONTRACT_QUERY_RESULT_URL = "https://api.mch.weixin.qq.com/papay/querycontract";

	/** 微信自动扣款 URL*/
	String WX_DEDUTION_URL = "https://api.mch.weixin.qq.com/pay/pappayapply";

	/**微信红包 URL*/
	String WX_REDPACKET_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	String WX_REDPACKET_URL_SX = "https://api.mch.weixin.qq.com/sandboxnew/mmpaymkttransfers/sendredpack";

	/**检查红发送状态*/
	String WX_REDPACKET_CHECK_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";
	String WX_REDPACKET_CHECK_URL_SX = "https://api.mch.weixin.qq.com/sandboxnew/mmpaymkttransfers/gethbinfo";

	/** 沙箱获取key的接口，沙箱测试时要调它来获取key，替换配置在开放接口平台上的apikey*/
	String WX_GETSIGNKEY_URL = "https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey";

	/*** api key*/
	String API_KEY = "mukitechmukitechmukitechmukitech";


	/*** 腾讯 云通信私钥*/
	String PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n" +
			"MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgPG7BkzEe82AFtzpd\n" +
			"uXPnV4Drd+V4n5NTuVmWIK1yoOOhRANCAASKmi9UiHtJB/98sOfdac9nOSBLcsnV\n" +
			"/iir14sX63oGCmKV5hRdll72nLusPzKaDQ1KtJ7JMG2lEBHzMEYZ4d1d\n" +
			"-----END PRIVATE KEY-----\n";

	/** 管理员账号*/
	String IDENTIFIER = "admin";

	/** 腾讯 云通信sdkappid*/
	Long SDKAPPID = Long.parseLong("1400160343");

	/** 腾讯 云通讯导入单个用户接口 URL*/
	String COMMUNICATION_ACCOUNT_IMPORT_URL = "https://console.tim.qq.com/v4/im_open_login_svc/account_import";

	/*** 腾讯 云通信 签名有效时间*/
	Integer COMMUNICATION_EXPIRE = 3600;

	/*** 批量发送消息*/
	String COMMUNICATION_BATCH_SENDMSG = "https://console.tim.qq.com/v4/openim/batchsendmsg";

	/*** 发送消息*/
	String COMMUNICATION_SENDMSG = "https://console.tim.qq.com/v4/openim/sendmsg";

	/*** 云通信 管理账户标识前缀*/
	String COMMUNICATION_IDENTIFIER_PREFIX = "ADMGR_";

	/*** 云通信 用户账户前缀*/
	String IDENTIFIER_PREFIX = "AD_";

}
