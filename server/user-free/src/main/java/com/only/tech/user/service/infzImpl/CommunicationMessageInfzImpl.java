package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.user.CommunicationMessageDto;
import com.only.tech.exposeinfz.user.api.CommunicationMessageInfz;
import com.only.tech.user.service.facade.CommunicationMessageFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/15
 */
@Slf4j
@Component
@Service(interfaceClass = CommunicationMessageInfz.class)
public class CommunicationMessageInfzImpl implements CommunicationMessageInfz {

    @Autowired
    private CommunicationMessageFacade communicationMessageFacade;

    @Override
    public boolean insert(CommunicationMessageDto dto) {
        return communicationMessageFacade.insert(dto);
    }

    @Override
    public PageData getPage(Integer sendStatus, String startTime, String endTime, PageReq pageReq) {
        return communicationMessageFacade.getPage(sendStatus,startTime,endTime,pageReq);
    }

    @Override
    public boolean updateSendStatus(Integer id, Integer sendStatus) {
        return communicationMessageFacade.updateSendStatus(id,sendStatus);
    }
}
