package com.only.tech.task.handler;

import com.only.tech.task.manager.VisitorStatisticsTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2019/2/26
 */
@JobHandler(value = "visitorStatisticsJobHandler")
@Component
public class VisitorStatisticsJobHandler extends IJobHandler {

    @Autowired
    private VisitorStatisticsTaskManager visitorStatisticsTaskManager;


    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello VisitorStatisticsJobHandler.");
        visitorStatisticsTaskManager.visitorStatistics(param);
        return SUCCESS;
    }
}
