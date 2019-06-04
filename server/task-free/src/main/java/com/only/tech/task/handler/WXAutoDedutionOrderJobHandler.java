package com.only.tech.task.handler;

import com.only.tech.task.manager.WXAutoDedutionOrderTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/21
 */
@JobHandler(value = "wXAutoDedutionOrderJobHandler")
@Component
public class WXAutoDedutionOrderJobHandler extends IJobHandler {

    @Autowired
    private WXAutoDedutionOrderTaskManager wxAutoDedutionOrderTaskManager;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello WXAutoDedutionOrderJobHandler.");
        wxAutoDedutionOrderTaskManager.checkOrder();
        return SUCCESS;
    }
}
