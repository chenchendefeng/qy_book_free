package com.only.tech.payment.service.push.dto;


import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

@Data
public class PushResponse {
	private String ret;
	
	private PushResponseData data;
	
	@Data
	public class PushResponseData {
		// 当"ret"为"SUCCESS"时，包含如下参数:
	    // 单播类消息(type为unicast、listcast、customizedcast且不带file_id)返回：
		@JsonFilter("msg_id")
		private String msgId;
		
		// 任务类消息(type为broadcast、groupcast、filecast、customizedcast且file_id不为空)返回：
		@JsonFilter("task_id")
		private String taskId;
		
	}
}
