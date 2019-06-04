package com.only.tech.exposeinfz.user.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.user.CommunicationMessageDto;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/15
 */
public interface CommunicationMessageInfz {
    boolean insert(CommunicationMessageDto dto);

    PageData getPage(Integer sendStatus, String startTime, String endTime, PageReq pageReq);

    boolean updateSendStatus(Integer id, Integer sendStatus);
}
