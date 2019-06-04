package com.only.tech.task.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.user.task.SendMsgTaskInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/18
 */
@Slf4j
@Service
public class SendMsgTaskManager {

    @Reference
    private SendMsgTaskInfz sendMsgTaskInfz;


    public void sendMsg() {
        sendMsgTaskInfz.sendMsg();
    }
}
