package com.only.tech.task.handler;

import com.only.tech.task.manager.SendMsgTaskManager;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/18
 */
@Component
@JobHandler(value = "communicationSendMsgHandler")
public class SendMsgJobHandler extends IJobHandler {

    @Autowired
    private SendMsgTaskManager sendMsgTaskManager;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello CommunicationSendMsgHandler.");
        sendMsgTaskManager.sendMsg();
        return SUCCESS;
    }
}
