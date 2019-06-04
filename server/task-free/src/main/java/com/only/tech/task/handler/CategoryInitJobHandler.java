package com.only.tech.task.handler;

import com.only.tech.task.manager.CategoryTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@JobHandler(value = "categoryInitJobHandler")
@Component
public class CategoryInitJobHandler extends IJobHandler {
    @Autowired
    private CategoryTaskManager categoryTaskManager;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello CategoryInitJobHandler.");
        categoryTaskManager.execute();
        return SUCCESS;
    }

}
