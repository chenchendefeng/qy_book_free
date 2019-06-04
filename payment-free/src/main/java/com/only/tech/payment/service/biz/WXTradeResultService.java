package com.only.tech.payment.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.payment.WXTradeResultEntity;

public interface WXTradeResultService extends IService<WXTradeResultEntity>{

	WXTradeResultEntity findByOutTradeNo(String outTradeNo);
	
	void updateByOutTradeNo(WXTradeResultEntity entity);
}
