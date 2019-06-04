package com.only.tech.task.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.only.tech.task.manager.WxPayTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;

@JobHandler(value = "wxPayQueryJobHandler")
@Component
public class WxPayQueryJobHandler extends IJobHandler{

	@Autowired
	private WxPayTaskManager manager;
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		XxlJobLogger.log("XXL-JOB, Hello WxPayQueryJobHandler.");
		manager.execute();
		return SUCCESS;
	}

}
