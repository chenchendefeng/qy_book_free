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
 * @since 2018/11/17
 */
@JobHandler(value = "bookLoadToEsJobHandler")
@Component
public class BookLoadToEsJobHandler extends IJobHandler {

    @Autowired
    private BookToEsTaskManager bookToEsTaskManager;

    @Override
    public ReturnT<String> execute(String s){
        XxlJobLogger.log("XXL-JOB, Hello BookLoadToEsJobHandler.");
        try {
            bookToEsTaskManager.loadBookToEs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
}
