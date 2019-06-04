package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.dto.user.ExchangeOrderDto;
import com.only.tech.entity.user.ExchangeGoods;
import com.only.tech.entity.user.ExchangeOrder;
import com.only.tech.exposeinfz.user.api.ExchangeOrderInfz;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/22
 */
@Service
public class ExchangeOrderMgrFacade {

    @Reference
    private ExchangeOrderInfz exchangeOrderInfz;

    public PageData<ExchangeOrderDto> page(Long cuId, Integer orderStatus, String startTime, String endTime, PageReq pageReq) {
        return exchangeOrderInfz.page(cuId,orderStatus,startTime,endTime,pageReq);
    }

    public ResultDto audit(String orderNo, Integer orderStatus, String remark) {
        return exchangeOrderInfz.audit(orderNo,orderStatus,remark);
    }
}
