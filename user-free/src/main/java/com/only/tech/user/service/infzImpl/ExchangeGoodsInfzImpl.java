package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.ExchangeGoods;
import com.only.tech.exposeinfz.user.api.ExchangeGoodsInfz;
import com.only.tech.user.service.biz.ExchangeGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/22
 */
@Component
@Service(interfaceClass = ExchangeGoodsInfz.class)
public class ExchangeGoodsInfzImpl implements ExchangeGoodsInfz {

    @Autowired
    private ExchangeGoodsService exchangeGoodsService;

    @Override
    public PageData<ExchangeGoods> page(Integer status, String exchangeType, PageReq pageReq) {
        return exchangeGoodsService.pageByStatusAndType(status,exchangeType,pageReq);
    }

    @Override
    public ExchangeGoods getById(Integer id) {
        return exchangeGoodsService.getById(id);
    }

    @Override
    public boolean add(ExchangeGoods goods) {
        if (goods == null) {
            return false;
        }
        Date now = new Date();
        goods.setCreateTime(now);
        goods.setUpdateTime(now);
        return exchangeGoodsService.save(goods);
    }

    @Override
    public boolean update(ExchangeGoods goods) {
        if (goods == null) {
            return false;
        }
        Date now = new Date();
        goods.setUpdateTime(now);
        return exchangeGoodsService.updateById(goods);
    }

    @Override
    public boolean updateStatus(Integer id, Integer status) {
        ExchangeGoods goods = exchangeGoodsService.getById(id);
        if (goods != null){
            goods.setStatus(status);
            return exchangeGoodsService.updateById(goods);
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return exchangeGoodsService.removeById(id);
    }
}
