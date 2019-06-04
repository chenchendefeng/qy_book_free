package com.only.tech.task.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.only.tech.task.manager.RegistAnalysisTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;

@JobHandler(value = "userRegistAnalysisJobHandler")
@Component
public class UserRegistAnalysisJobHandler extends IJobHandler{

	@Autowired
	private RegistAnalysisTaskManager registAnalysisTaskManager;
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		XxlJobLogger.log("XXL-JOB, Hello UserRegistAnalysisJobHandler.param={}",param);
		registAnalysisTaskManager.executeRegistAnalysis(param);
		return SUCCESS;
	}

}
