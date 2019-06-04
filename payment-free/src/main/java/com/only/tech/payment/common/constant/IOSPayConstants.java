package com.only.tech.payment.common.constant;

public class IOSPayConstants {
	
	/**
	 * App 专有的 ID, 此 ID 不会在 App Store 中显示
	 */
	public static final String SKU = "com.Weiyi.Qianyueshucheng";
	
	/**
	 * 套装 ID,必须与您在 Xcode 中使用的 ID 相符。该 ID 在您上传第一个构建版本后便无法更改。
	 */
	public static final String SUIT_ID = "com.Weiyi.Qianyue";
	
	/**
	 * 成功返回
	 */
	public static final String CHECK_CODE_SUCC = "0";
	
	/**
	 * 测试环境的支付数据，但是调到正式环境验证结果
	 */
	public static final String CHECK_CODE_TEST_ENV = "21007";
	
	public static final int PAY_METHOD_IOS = 2;
	/**
	 * 预下单记录状态：未验证
	 */
	public static final int PRE_PAY_STATUS_UNCHECKED = 0;
	/**
	 * 预下单记录状态：已验证
	 */
	public static final int PRE_PAY_STATUS_CHECKED = 1;
	
	
}
