package com.only.tech.payment.service.push.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AndroidPolicy extends Policy {
	//可选，发送限速，每秒发送的最大条数。最小值1000
    // 开发者发送的消息如果有请求自己服务器的资源，可以考虑此参数。
	private String maxSendNum;
}
