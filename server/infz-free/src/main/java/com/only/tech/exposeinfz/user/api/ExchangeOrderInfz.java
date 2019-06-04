package com.only.tech.exposeinfz.user.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.user.ExchangeOrderDto;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/22
 */
public interface ExchangeOrderInfz {
    PageData<ExchangeOrderDto> page(Long cuId, Integer status, String startTime, String endTime, PageReq pageReq);

    ResultDto audit(String orderNo, Integer status, String remark);

    void sendRedPacket();

    void sendCheck();
}
