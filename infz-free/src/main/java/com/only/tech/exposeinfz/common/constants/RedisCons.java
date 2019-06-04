package com.only.tech.exposeinfz.common.constants;

public class RedisCons {
	/**
	 * 系统名称
	 * @author Lenovo
	 *
	 */
	public enum SysName {
		BOOK("ORDERNO_BOOK"), PAYMENT("ORDERNO_PAY"),USER("ORDERNO_USER");
		private String value;

		public String getValue() {
			return value;
		}
		private SysName(String value) {
			this.value = value;
		}
	}
	/*
	 * 订单前缀
	 */
	public static final String PREFIX_BOOK="book_";
	public static final String PREFIX_USER="user_";
	public static final String PREFIX_PAYMENT="pay_";
	
	/*
	 * 开始值，往上累加
	 */
	public static final String ORDERNO_SUFFER="0";
	
	/*
	 * 一天的秒  24*60*60
	 */
	public static final int ONE_DAY_SECONDS = 86400;
	
	/*
	 * 五分钟的秒 5*60
	 */
	public static final int FINE_MINUTES_SECONDS = 300;
	
	/*
	 * 下划线分隔符
	 */
	public static final String SPIL_LINE = "_";
	
	
}
