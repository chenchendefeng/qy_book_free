package com.only.tech.user.service.task;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.entity.user.CommunicationMessage;
import com.only.tech.exposeinfz.user.task.SendMsgTaskInfz;
import com.only.tech.user.service.biz.CommunicationMessageService;
import com.only.tech.user.service.facade.CommunicationMessageFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/18
 */
@Slf4j
@Component
@Service(interfaceClass = SendMsgTaskInfz.class)
public class SendMsgTaskInfzImpl implements SendMsgTaskInfz {

    @Autowired
    private CommunicationMessageFacade communicationMessageFacade;

    @Autowired
    private CommunicationMessageService communicationMessageService;

    @Override
    @Async
    public void sendMsg() {

        List<CommunicationMessage> messageList = communicationMessageFacade.getMessagerList();

        if (!messageList.isEmpty()){
            for (CommunicationMessage message: messageList) {
                boolean send = communicationMessageFacade.sendMsgByMessage(message);
                if (send){
                    message.setSendStatus(1);
                    communicationMessageService.updateById(message);
                }
            }
        }
    }
}
