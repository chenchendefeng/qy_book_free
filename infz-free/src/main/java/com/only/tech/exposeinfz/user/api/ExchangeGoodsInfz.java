package com.only.tech.exposeinfz.user.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.ExchangeGoods;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/22
 */
public interface ExchangeGoodsInfz {
    PageData<ExchangeGoods> page(Integer status, String exchangeType, PageReq pageReq);

    ExchangeGoods getById(Integer id);

    boolean add(ExchangeGoods goods);

    boolean update(ExchangeGoods goods);

    boolean updateStatus(Integer id, Integer status);

    boolean delete(Integer id);
}
