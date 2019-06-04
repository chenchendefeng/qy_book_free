package com.only.tech.task.handler;

import com.only.tech.task.manager.BookHotTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/22
 */
@Component
@JobHandler("bookHotInitJobHandler")
public class BookHotInitJobHandler extends IJobHandler {

    @Autowired
    private BookHotTaskManager bookHotTaskManager;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello BookHotspotJobHandler.");
        bookHotTaskManager.initHot();
        return SUCCESS;
    }
}
