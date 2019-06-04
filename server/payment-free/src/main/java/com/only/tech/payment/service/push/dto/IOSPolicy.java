package com.only.tech.payment.service.push.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IOSPolicy extends Policy {
	//可选，多条带有相同apns_collapse_id的消息，iOS设备仅展示
    // 最新的一条，字段长度不得超过64bytes
	private String apnsCollapseId;
}
