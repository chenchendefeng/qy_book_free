package com.only.tech.task.handler;

import com.only.tech.task.manager.InviteRankListTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/30
 */
@JobHandler(value = "inviteRankListJobHandler")
@Component
public class InviteRankListJobHandler extends IJobHandler {

    @Autowired
    private InviteRankListTaskManager inviteRankListTaskManager;


    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello InviteRankListJobHandler.");
        inviteRankListTaskManager.execute(param);
        return SUCCESS;
    }
}
