package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.user.CommunicationMessageDto;
import com.only.tech.exposeinfz.user.api.CommunicationMessageInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/15
 */
@Slf4j
@Service
public class CommunicationMessageFacade {

    @Reference
    private CommunicationMessageInfz communicationMessageInfz;


    public boolean insert(CommunicationMessageDto dto) {
        return communicationMessageInfz.insert(dto);
    }

    public PageData getPage(Integer sendStatus, String startTime, String endTime, PageReq pageReq) {
        return communicationMessageInfz.getPage(sendStatus,startTime,endTime,pageReq);
    }

    public boolean updateSendStatus(Integer id, Integer sendStatus) {
        return communicationMessageInfz.updateSendStatus(id,sendStatus);
    }
}
