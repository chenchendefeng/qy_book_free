package com.only.tech.payment.service.push.common;

public enum HandleTagType {
	ADD("add"), DELETE("delete"),CLEAR("clear");
	private String value;

	public String getValue() {
		return value;
	}
	private HandleTagType(String value) {
		this.value = value;
	}
}
