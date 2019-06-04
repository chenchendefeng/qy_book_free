package com.only.tech.payment.common.constant;

public class AliPayConfigConstants {
	/*
	 * 支付宝支付appid
	 */
	public static final String APP_ID_PRODUCT = "2017120800446870";
	public static final String APP_ID_SANDBOX = "2016091400507059";
	/*
	 * 支付宝支付pid,一个appid下可能有多个pid
	 */
	public static final String PID = "2088821621302683";
	/*
	 * 支付宝支付秘钥
	 */
	public static final String SECRET = "";
	/*
	 * 支付宝
	 */
	public static final int PAY_METHOD_AL = 0;
	/*
	 * 支付宝公钥
	 */
	public static final String ALIPAY_PUBLIC_KEY_PRODUCT = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk75U5jP/fluHl9f8/dIFW0iPnc3vIysafoSmctP/US/SjUnH0818Bf6h4QXUMTWnx3CwxXRUTQdDP6DgUSPlXjkOISxqDSKWwO2LLeYR6JK9RISsd/eiGLeeC4P1lI17PuyHzSkxZbxwn4ra5Lz6sA00+645Y1DpXootDCAfYBALVXj6ZXIyNsmnG83ZdJvGVGwHeEIt/D4EuXyVqw8l05nfhaR/9YTXiXNDJFKsAN4iu3hWJtbanUhNuevZOkUPKREGlQKzvuxssB1R5UVaxnB4sDpPk01bGmd+il7ipXvOcTE4h2YCU6J2gSKFe4ZF6R/xxYmwrs9EfkidSktzvQIDAQAB";
	public static final String ALIPAY_PUBLIC_KEY_SANDBOX = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5P/WvTPwqFxVvjN7gA2ixKn4JiNG8X4oHWtvvfyhLtrxxeVRw0JI3XacziNxZyGIWtR8PONASBpzWbmWRS6M8wxYJ+uQyRq3oFmmncW0+oPiILF88xo3j+Qn5tYo94MUkOv+0dNJOz7XkaZBWwlo8R2qjCvkLoI9tYk473LIzXMLCV0Pm4V0lz9YGqzB8HgnExq2dWhKDarHT2CNh0IWNug4M8kW9vmGezN93K0M/RFXch0YWXiilvF9ovyMEFErlvVWnQLK8sPELmf7xrwD2H9NqixTr6drq/wrCk6mIRi+YPsRM7TR0kLZvuKEfCzUYIHAu5lI1OwDNpftAdjHNQIDAQAB";
	/*
	 * 应用私钥
	 */
	public static final String APP_PRIVATE_KEY = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCmxHt2d+SCrTouuvJ56dS9ufTwvXbhs0PnZHaDOGAEoBoDbdSpuPoicdErDtXTLbbl77wP95RMyiINAJCtMDMp+GTT2PZKcIryDELs6HE2HoKaWHEgSITrLEQU2vtxJTdPuhx0Im8qlma/B6lyXxR2kEHd7/xOR70HLfo8wNQp/uB5uV2g49b6encrDlomUiNI1o061QzY4LoEa+syoAmWW+/AI6ulZfnmFhuaBOCBp66S6zm2nB1scmLmGFh1ta3Bzyw/9Mp3nJnOEG0Abuu2YoobnN8smzhhF0a/dRdz2jIYBYh30lYffW9/6VIXi7WmGzcbuWilLW9ubCnfCVfPAgMBAAECggEBAINuyStGNHd1FSztM9s3me5pl40AlaguA69jcy/aB3q9v6LCNeAJpEHvV/3KdGU6WzJ/LcWbx2p5yDpdHqkQGtLSLIz2Kq3iYu9/EGPskgUoKKCCYa4i2XcLbSDOsWqr/Rq9wF0bImf7H0EhRb+ZBeSnrvG+iSgcy/LTnquxAcWSCkCqgN2D3HuLyGHn8ApK3Y6YD7AiUHlj9d8sMSTqMVTHlMhNRNgOhNWw2byWOy0f0Nymgs7//bVLMLeLMXcpwEvHPn+Pv9St/Kwn29BNOOVU2qrHB/M5sxT7/DDk9OlK1lPyAz+qdJ2/G+EGlz7s/AD/AonyA/WTZCyJWz2NxGkCgYEA+co2Py8y02xguUNl4ztsLs16379YwytQB3uZKvPawce04bfR9eCTGdO83eainU7CL4doDg3G7Y6J1N6Ier9rbAmt6iQaaPxwt8SYmdtnXQA/GYTcf4jOfYotVx1nYaYDb7ZECQiuBPN8qR6DziF5/a7ZZgSfYIL/fW7x6SGqLA0CgYEAqunf0xzSBzDmcvEZKsMiTd4BjhuV0eJ6GueJ4t6iwN74IgCOqtfsdeBFcr8L2EsxR19+6ShhWAbS0jmkLBHvy9cHr+XO0NF6Iwss5RxPpsRODe9Jv/cO3uYBaxiZPffo2hG9LgruWd1DU1kaLYAOvX4FG9yhBKlAvvZ+eMqcMEsCgYEAvsAz4tZpStkll/SnFvrm52rVHY6i+w/VYpF5azqjYH3gXMqiVNC1pPBz90TMA7MESYVu6eSNeBX0nZF+ybXqE6vkmrwNSwUUEtHX8w6AhZ3NkfBK7j2L6oSdkTwMGZ7MWv/mPrvZIEDMft2lq8EWxqpCrEx1ZR9EegZCSFUD/fUCgYEAmHZ0wcBt4xhOGq7UQn87tLacMIaPCWG8hw+Qwx7TlLXSJ5LTsbdYKnbbvNaL3HCHDyIy9g6dd4buvbXJq758aRvysYiRC1oyV9x6Og8dRqjK8EdLRMFBNLl8/mo9GThzMUStu8rogKWOj2Vmorwfag5mxEn2IVBSf4cnnt0uoy0CgYEAr0EunZslqSH6djNaFL5d3dN/t522wgVvbxIpaMN9Bc4+8bdQ5/XR0Cnm7Zmc64ESD8r3rXvMts81Q4DaQU/R+JIKo8T4+o2a2CdD8/TcFmod+RVjt6zMPvI8wjp5wsDxbotSpl1uhhd7LYN4TlBPDic3HHpNIBmGU54MGlMsACQ=";
	/*
	 * 加签
	 */
	public static final String SIGNTYPE = "RSA2";
	
	/*
	 * 沙箱支付接口url
	 */
	public static final String PAY_URL_SANDBOX = "https://openapi.alipaydev.com/gateway.do";
//	public static String PAY_URL_SANDBOX = "http://openapi.alipaydev.com/gateway.do";
	public static final String PAY_URL_PRODUCT = "https://openapi.alipay.com/gateway.do";
	/*
	 * 交易完成
	 */
	public static final String TRADE_SUCCESS = "TRADE_SUCCESS";
	/*
	 * 支付成功
	 */
	public static final String TRADE_FINISHED = "TRADE_FINISHED";
	/*
	 * 异步通知返回--失败
	 */
	public static final String NOTIFY_RESPONE_FAIL = "failure";
	/*
	 * 异步通知返回--成功
	 */
	public static final String NOTIFY_RESPONE_SUCC = "success";
	/*
	 * 订单支付成功code
	 */
	public static final String PAY_SUCC_CODE = "9000";
	
	/*
	 *从文件中读取出来的交易数据  out_trade_no|^^|money
	 */
	public static final String ALI_PAY_BILL_FILE_KEY_PREFIX = "PAY_ALI_BILL_FILE_DETAIL_LIST_";
	/*
	 *从p_order表中读取出来的交易数据 
	 */
	public static final String ALI_PAY_BILL_DB_KEY_PREFIX = "PAY_ALI_BILL_DB_DETAIL_LIST_";
}
