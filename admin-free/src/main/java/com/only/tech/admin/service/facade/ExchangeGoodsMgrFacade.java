package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.ExchangeGoods;
import com.only.tech.exposeinfz.user.api.ExchangeGoodsInfz;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/22
 */
@Service
public class ExchangeGoodsMgrFacade {

    @Reference
    private ExchangeGoodsInfz exchangeGoodsInfz;

    public PageData<ExchangeGoods> page(Integer status, String exchangeType, PageReq pageReq) {
        return exchangeGoodsInfz.page(status,exchangeType,pageReq);
    }

    public ExchangeGoods getById(Integer id) {
        return exchangeGoodsInfz.getById(id);
    }

    public boolean add(ExchangeGoods goods) {
        return exchangeGoodsInfz.add(goods);
    }

    public boolean update(ExchangeGoods goods) {
        return exchangeGoodsInfz.update(goods);
    }

    public boolean updateStatus(Integer id, Integer status) {
        return exchangeGoodsInfz.updateStatus(id,status);
    }

    public boolean delete(Integer id) {
        return exchangeGoodsInfz.delete(id);
    }
}
