package com.only.tech.task.handler;

import com.only.tech.task.manager.BookTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 热点书籍数据同步任务调度
 * 
 * @author xiaoshiyilang
 * @date 2018/11/10
 * @version 1.0
 */
@JobHandler(value = "bookHotspotJobHandler")
@Component
public class BookHotspotJobHandler extends IJobHandler {

	@Autowired
	private BookTaskManager bookTaskManager;

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		XxlJobLogger.log("XXL-JOB, Hello BookHotspotJobHandler.");
		bookTaskManager.executeHotspotBook();
		return SUCCESS;
	}

}
