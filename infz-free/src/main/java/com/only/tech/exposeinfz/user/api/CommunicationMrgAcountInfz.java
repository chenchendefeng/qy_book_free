package com.only.tech.exposeinfz.user.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.user.CommunicationMrgAcountDto;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/15
 */
public interface CommunicationMrgAcountInfz {
    PageData<CommunicationMrgAcountDto> getPage(PageReq pageReq);

    boolean insert(CommunicationMrgAcountDto dto);
}
