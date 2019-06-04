package com.only.tech.payment.service.biz;

import com.only.tech.entity.payment.WXTradeResultEntity;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.payment.mapper.WXTradeResultEntityMapper;

@Service
public class WXTradeResultServiceImpl extends ServiceImpl<WXTradeResultEntityMapper, WXTradeResultEntity>
		implements WXTradeResultService {

	@Override
	public WXTradeResultEntity findByOutTradeNo(String outTradeNo) {
        Wrapper<WXTradeResultEntity> wrapper = new QueryWrapper<WXTradeResultEntity>().eq("out_trade_no", outTradeNo);
        return super.getOne(wrapper);
	}

	@Override
	public void updateByOutTradeNo(WXTradeResultEntity entity) {
		 Wrapper<WXTradeResultEntity> wrapper = new UpdateWrapper<WXTradeResultEntity>().eq("out_trade_no", entity.getOutTradeNo());
		 super.update(entity, wrapper);
	}

}
