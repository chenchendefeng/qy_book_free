package com.only.tech.task.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.only.tech.task.manager.WxPayTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;

@JobHandler(value = "wxPayCheckBillJobHandler")
@Component
public class WxPayCheckBillJobHandler extends IJobHandler{

	@Autowired
	private WxPayTaskManager manager;
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		XxlJobLogger.log("XXL-JOB, Hello WxPayCheckBillJobHandler.");
		manager.executeCheckBill(param);
		return SUCCESS;
	}

}
