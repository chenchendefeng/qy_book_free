package com.only.tech.admin.common.targetMethod;

public enum HandleType {
	ADD(0), DELETE(1), UPDATE(2);

	private final int value;

	HandleType(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}
}
