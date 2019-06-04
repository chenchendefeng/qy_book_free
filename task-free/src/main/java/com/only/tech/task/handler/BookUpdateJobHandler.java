package com.only.tech.task.handler;

import com.only.tech.task.manager.BookTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 书籍更新定时任务
 * @author ZHI ZUN BAO
 * @since 2019/4/17
 */
@Component
@JobHandler(value = "bookUpdateJobHandler")
public class BookUpdateJobHandler extends IJobHandler {

    @Autowired
    private BookTaskManager bookTaskManager;

    @Override
    public ReturnT<String> execute(String date) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello BookUpdateJobHandler.");
        bookTaskManager.bookUpdate(date);
        return SUCCESS;
    }
}
