package com.only.tech.exposeinfz.payment.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.dto.payment.GoodsDto;
import com.only.tech.entity.payment.Goods;
import com.only.tech.entity.payment.GoodsOrder;

/**
 * infz: 商品订单
 * @author shutong
 * @since 2019/05/20
 */
public interface GoodsOrderInfz {


    /**
     * 分页查询
     * @param pageReq
     * @param createDateStart
     * @param createDateEnd
     * @param cuId
     * @param paymentStatus
     * @return
     */
    PageData<GoodsOrder> pageListByCondition(PageReq pageReq, String createDateStart, String createDateEnd, Long cuId, Integer paymentStatus);
}