package com.only.tech.payment.service.push.common;

public enum AfterOpenAction {
	go_app, // 打开应用
	go_url, // 跳转到URL
	go_activity, // 打开特定的activity
	go_custom// 用户自定义内容。
}
