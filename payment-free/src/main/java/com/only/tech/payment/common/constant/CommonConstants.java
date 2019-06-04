package com.only.tech.payment.common.constant;

public class CommonConstants {
	public static final String STR_SUCCESS = "SUCCESS";
	public static final String STR_FAIL = "FAIL";

	public static final int UN_PAY = 0;// 未支付
	public static final int SUCC_PAY = 1;// 支付完成
	public static final int FAIL_PAY = 2;// 支付失败


	public static final String PAY_TYPE_ALI="ali";      //支付类型-支付宝
	public static final String PAY_TYPE_WX="wx";        //支付类型-支付宝
	public static final String PAY_TYPE_APPLE="apple";  //支付类型-苹果内购

	public static final String PAY_STATUS_DOING="doing";      //支付状态-支付中
	public static final String PAY_STATUS_SUCCESS="success";  //支付状态-支付成功
	public static final String PAY_STATUS_FAIL="fail";        //支付状态-支付失败


	/**
	 * 充币状态
	 * 
	 * @author Lenovo
	 *
	 */
	public enum AddBillStatus {
		FAIL(0), SUCC(1);
		private int value;

		public int getValue() {
			return value;
		}

		private AddBillStatus(int value) {
			this.value = value;
		}
	}

	/**
	 * 分隔符--拼接串
	 */
	public static final String SPILE_SYMBOL_CONTANT = "|^^|";
	/**
	 * 分隔符--分割串
	 */
	public static final String SPILE_SYMBOL_SPLIT = "\\|\\^\\^\\|";

	/**
	 * 异步通知
	 */
	public static final Integer RESULT_TYPE_NOTIFY = 0;
	/**
	 * 主动查询
	 */
	public static final Integer RESULT_TYPE_QUERY = 1;
	/**
	 * 月账单
	 */
	public static final Integer BILL_TYPE_MONTH = 0;
	/**
	 * 日账单
	 */
	public static final Integer BILL_TYPE_DAY = 1;

	public static final String SYSTEM_TYPE_IOS = "iOS";

	public static final String SYSTEM_TYPE_ANDROID = "Android";

	/**
	 * 充值商品类型
	 *  1:VIP
	 * @author Lenovo
	 *
	 */
	public enum GoodsType {

		VIP(1);

		private int value;

		public int getValue() {
			return value;
		}

		private GoodsType(int value) {
			this.value = value;
		}
	}

}
