package com.only.tech.task.handler;

import com.only.tech.task.manager.WXAutoRenewaTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 微信自动续费定时任务
 * @author ZHI ZUN BAO
 * @since 2019/1/18
 */
@JobHandler(value = "wXAutoRenewaJobHandler")
@Component
public class WXAutoRenewaJobHandler extends IJobHandler {

    @Autowired
    private WXAutoRenewaTaskManager wxAutoRenewaTaskManager;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello WXAutoRenewaJobHandler.");
        wxAutoRenewaTaskManager.autoDeduction(param);
        return SUCCESS;
    }

}
