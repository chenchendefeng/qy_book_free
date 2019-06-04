package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.user.CommunicationMrgAcountDto;
import com.only.tech.exposeinfz.user.api.CommunicationMrgAcountInfz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/15
 */
@Slf4j
@Service
public class CommunicationMrgAcountFacade {

    @Reference
    private CommunicationMrgAcountInfz communicationMrgAcountInfz;

    public PageData<CommunicationMrgAcountDto> getPage(PageReq pageReq) {
        return communicationMrgAcountInfz.getPage(pageReq);
    }

    public boolean insert(CommunicationMrgAcountDto dto) {
        return communicationMrgAcountInfz.insert(dto);
    }
}
