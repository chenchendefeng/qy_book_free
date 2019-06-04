package com.only.tech.task.handler;

import com.only.tech.task.manager.BookToEsTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/19
 */
@Component
@JobHandler("bookDeleteFromEsJobHandler")
public class BookDeleteFromEsJobHandler extends IJobHandler {

    @Autowired
    private BookToEsTaskManager bookToEsTaskManager;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello BookDeleteFromEsJobHandler.");
        try {
            bookToEsTaskManager.deleteAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
}
