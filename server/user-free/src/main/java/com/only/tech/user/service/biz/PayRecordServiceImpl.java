package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.user.PayRecord;
import com.only.tech.user.mapper.PayRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

/**
 * 支付记录表 服务实现类
 * @author shoujun.yang
 * @since 2018-12-19
 */
@Service
public class PayRecordServiceImpl extends ServiceImpl<PayRecordMapper, PayRecord> implements PayRecordService {

	@Autowired
	PayRecordMapper payRecordMapper;

	@Override
	public PayRecord queryByPayOrderNo(String payOrderNo) {
		Wrapper<PayRecord> wrapper = new QueryWrapper<PayRecord>().eq("payOrderNo", payOrderNo);
		return super.getOne(wrapper);
	}

	@Override
	public int countPayByUidAndPayDate(Long uid, String payDate) {
		Wrapper<PayRecord> wrapper = new QueryWrapper<PayRecord>().eq("uid", uid).lt("createTime", payDate);
		return super.count(wrapper);
	}

	@Override
	public boolean isOutTradeNoUsed(String outTradeNo) {
		Wrapper<PayRecord> wrapper = new QueryWrapper<PayRecord>().eq("payOrderNo", outTradeNo);
		return super.count(wrapper) > 0;
	}

	@Override
	public void saveByOrderNo(Long uid, String payOrderNo, Long readCardId, Long vipId, Integer orderMoney,
			String systemType) {
		PayRecord payRecord = new PayRecord();
		payRecord.setUid(uid);
		payRecord.setReadCardId(readCardId);
		payRecord.setOrderMoney(orderMoney);
		payRecord.setPayOrderNo(payOrderNo);
		payRecord.setSystemType(systemType);
		payRecord.setVipId(vipId);
		payRecord.setCreateTime(LocalDateTime.now());
		super.save(payRecord);
	}

	@Override
	public void saveOrUpdateByOrderNo(Long uid, String payOrderNo, Long readCardId, Long vipId, Integer orderMoney,
			String systemType) {
		PayRecord payRecord = new PayRecord();
		payRecord.setUid(uid);
		payRecord.setReadCardId(readCardId);
		payRecord.setOrderMoney(orderMoney);
		payRecord.setPayOrderNo(payOrderNo);
		payRecord.setSystemType(systemType);
		payRecord.setVipId(vipId);
		Wrapper<PayRecord> wrapper = new QueryWrapper<PayRecord>().eq("payOrderNo", payOrderNo);
		if (super.count(wrapper) == 0) {
			payRecord.setCreateTime(LocalDateTime.now());
			super.save(payRecord);
		} else {
			payRecord.setUpdateTime(LocalDateTime.now());
			super.update(payRecord, wrapper);
		}
	}

}
