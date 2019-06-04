package com.only.tech.payment.service.biz;

import java.util.List;
import com.only.tech.entity.payment.WXPrePayRecord;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.payment.mapper.WXPrePayRecordMapper;

@Service
public class WXPrePayRecordServiceImpl extends ServiceImpl<WXPrePayRecordMapper, WXPrePayRecord>
implements WXPrePayRecordService{

	@Override
	public void updateByOutTradeNo(WXPrePayRecord record) {
		Wrapper<WXPrePayRecord> wrapper = new UpdateWrapper<WXPrePayRecord>().eq("out_trade_no", record.getOutTradeNo());
		super.update(record, wrapper);
	}

	@Override
	public List<WXPrePayRecord> queryRecordByUidAndStatus(Long uid, Integer tradeStatus) {
		
		QueryWrapper<WXPrePayRecord> wrapper = new QueryWrapper<WXPrePayRecord>();
		if(uid != null)
		{
			wrapper.eq("uid", uid);
		}
		wrapper.eq("trade_status", tradeStatus);
		return super.list(wrapper);
	}

	@Override
	public WXPrePayRecord queryRecordByOutTradeNo(String outTradeNo) {
		Wrapper<WXPrePayRecord> wrapper = new QueryWrapper<WXPrePayRecord>().eq("out_trade_no", outTradeNo);
		return super.getOne(wrapper);
	}

	@Override
	public int countOrderNumByDate(String analysisDate) {
		Wrapper<WXPrePayRecord> wrapper = new QueryWrapper<WXPrePayRecord>().like("create_date", analysisDate+"%");
		return super.count(wrapper);
	}

	@Override
	public boolean updateStatus(String outTradeNo, Integer tradeStatus) {
		WXPrePayRecord record = queryRecordByOutTradeNo(outTradeNo);
		if (record == null){
			return false;
		}
		record.setTradeStatus(tradeStatus);
		return updateById(record);
	}

	@Override
	public WXPrePayRecord queryTradeStatusByPrepayId(String prepayId) {
		Wrapper<WXPrePayRecord> wrapper = new QueryWrapper<WXPrePayRecord>().eq("prepay_id", prepayId);
		return super.getOne(wrapper);
	}

}
