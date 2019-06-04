package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.dto.user.ExchangeOrderDto;
import com.only.tech.entity.user.ExchangeOrder;

import java.util.List;

/**
 * <p>
 * 兑换订单 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-22
 */
public interface ExchangeOrderService extends IService<ExchangeOrder> {

    List<ExchangeOrderDto> dtoList(Long cuId, Integer orderStatus, String startTime, String endTime);

    ExchangeOrder getByOrderNo(String orderNo);
}
