package com.only.tech.payment.common.constant;

public interface WXPayConstants {

	/** 微信支付商户号 */
	String MCH_ID = "1492556692";

	/** 公众号APP_ID*/
	String FREE_APP_ID = "wx52100139f9d474b8";
	String MCH_NAME = "深圳市维奕科技";//商户名称


	/** 千阅书城APP_ID */
	String APP_ID = "wx08ad162781657c74";

	/** 交易类型*/
	String TRADE_TYPE_APP = "APP";  //APP支付
	String TRADE_TYPE_NATIVE = "NATIVE"; //Native支付

	/**发红包场景*/
	String PRODUCT_1 = "PRODUCT_1";//商品促销
	String PRODUCT_2 = "PRODUCT_2";//抽奖
	String PRODUCT_3 = "PRODUCT_3";//虚拟物品兑奖
	String PRODUCT_4 = "PRODUCT_4";//企业内部福利
	String PRODUCT_5 = "PRODUCT_5";//渠道分润
	String PRODUCT_6 = "PRODUCT_6";//保险回馈
	String PRODUCT_7 = "PRODUCT_7";//彩票派奖
	String PRODUCT_8 = "PRODUCT_8";//税务刮奖

	/** api key*/
	String API_KEY = "mukitechmukitechmukitechmukitech";
	
	String FIELD_SIGN = "sign";
	String SIGN_TYPE_MD5 = "MD5";
	String SIGN_TYPE_SHA = "HMACSHA256";
	String BODY = "千阅书城微信充值";
	
	/** 沙箱获取key的接口，沙箱测试时要调它来获取key，替换配置在开放接口平台上的apikey*/
	String SANDBOXNEW_URL = "https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey";

	/** 沙箱测试时拼接的url串*/
	String SAND_BOX = "sandboxnew";

	/** 支付接口域名*/
	String DOMAIN_URL = "https://api.mch.weixin.qq.com";
	/** 下单接口*/
	String UNDER_ORDER_URL = "pay/unifiedorder";
	/** 查询接口*/
	String ORDER_QUERY_URL = "pay/orderquery";
	/** 付款方式-微信*/
	int PAY_METHOD_WX = 1;
	
	/**0-下单中 1-未查询, 2-未支付, 3-交易关闭, 4-支付中, 5-支付失败, 6-支付成功 , -1-下单失败 , 7-其他*/
	int TRADE_STATUS_UNDER_BILL_FAIL = -1;
	int TRADE_STATUS_UNDER_BILL = 0;
	int TRADE_STATUS_NOT_QUERY = 1;
	int TRADE_STATUS_NOT_PAY = 2;
	int TRADE_STATUS_CLOSED = 3;
	int TRADE_STATUS_PAYING = 4;
	int TRADE_STATUS_PAY_FAIL = 5;
	int TRADE_STATUS_PAY_SUCC = 6;
	int TRADE_STATUS_OTHER = 7;
	
	/** 支付成功*/
	String TRADE_STR_SUCCESS = "SUCCESS";
	/** 转入退款*/
	String TRADE_STR_REFUND = "REFUND";
	/** 未支付*/
	String TRADE_STR_NO_PAY = "NOTPAY";
	/** 已关闭*/
	String TRADE_STR_CLOSED = "CLOSED";
	/** 已撤销（刷卡支付）*/
	String TRADE_STR_REVOKED = "REVOKED";
	/** 用户支付中*/
	String TRADE_STR_USERPAYING = "USERPAYING";
	/** 支付失败(其他原因，如银行返回失败)*/
	String TRADE_STR_PAYERROR = "PAYERROR";
	
	/**从文件中读取出来的交易数据  out_trade_no|^^|money*/
	String WX_PAY_BILL_FILE_KEY_PREFIX = "PAY_WX_BILL_FILE_DETAIL_LIST_";
	/**从p_order表中读取出来的交易数据*/
	String WX_PAY_BILL_DB_KEY_PREFIX = "PAY_WX_BILL_DB_DETAIL_LIST_";

	//收到微信支付结果通知后，请严格按照示例返回参数给微信支付：
	String NOTIFY_STR_SUCCESS = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	String NOTIFY_STR_FAIL = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
}
