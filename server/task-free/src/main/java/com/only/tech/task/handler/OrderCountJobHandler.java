package com.only.tech.task.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.only.tech.task.manager.OrderCountTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;

@JobHandler(value = "orderCountJobHandler")
@Component
public class OrderCountJobHandler extends IJobHandler{

	@Autowired
	private OrderCountTaskManager orderCountTaskManager;
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		XxlJobLogger.log("XXL-JOB, Hello OrderAnalysisJobHandler.");
		orderCountTaskManager.executeOrderCount(param);
		return SUCCESS;
	}

}
