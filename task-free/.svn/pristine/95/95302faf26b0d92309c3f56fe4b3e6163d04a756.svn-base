package com.only.tech.task.handler;

import com.only.tech.task.manager.NewBookUpdateTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2018/11/28
 */
@JobHandler(value = "newBookUpdateJobHandler")
@Component
public class NewBookUpdateJobHandler  extends IJobHandler {


    @Autowired
    private NewBookUpdateTaskManager newBookUpdateTaskManager;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello NewBookUpdateJobHandler.");

        try {
            newBookUpdateTaskManager.updateNewBook();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }
}
