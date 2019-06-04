package com.only.tech.task.handler;

import com.only.tech.task.manager.BookTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@JobHandler(value = "bookChoiceCountJobHandler")
public class ChoiceBookCountJobHandler extends IJobHandler {

	@Autowired
	private BookTaskManager bookTaskManager;

	@Override
	public ReturnT<String> execute(String s) throws Exception {
		XxlJobLogger.log("XXL-JOB, Hello BookChoiceCountJobHandler.");
		bookTaskManager.executeReloadChoiceBookCount();
		return SUCCESS;
	}
}
