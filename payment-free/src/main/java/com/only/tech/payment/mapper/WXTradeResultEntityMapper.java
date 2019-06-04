package com.only.tech.payment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.entity.payment.WXTradeResultEntity;

public interface WXTradeResultEntityMapper extends BaseMapper<WXTradeResultEntity>{
	WXTradeResultEntity findByOutTradeNo(String outTradeNo);
}
