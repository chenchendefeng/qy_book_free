package com.only.tech.user.service.biz;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.dto.user.ExchangeOrderDto;
import com.only.tech.entity.user.ExchangeOrder;
import com.only.tech.user.mapper.ExchangeOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 兑换订单 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-22
 */
@Service
public class ExchangeOrderServiceImpl extends ServiceImpl<ExchangeOrderMapper, ExchangeOrder> implements ExchangeOrderService {

    @Autowired
    private ExchangeOrderMapper exchangeOrderMapper;

    @Override
    public List<ExchangeOrderDto> dtoList(Long cuId, Integer orderStatus, String startTime, String endTime) {
        return exchangeOrderMapper.dtoList(cuId,orderStatus,startTime,endTime);
    }

    @Override
    public ExchangeOrder getByOrderNo(String orderNo) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("orderNo",orderNo);
        return this.getOne(qw);
    }
}
