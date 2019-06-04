package com.only.tech.payment.service.biz;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.payment.WXPrePayRecord;

public interface WXPrePayRecordService extends IService<WXPrePayRecord>{
	
	public void updateByOutTradeNo(WXPrePayRecord record);
	
	public List<WXPrePayRecord> queryRecordByUidAndStatus(Long uid,Integer tradeStatus);
	
	public WXPrePayRecord queryRecordByOutTradeNo(String outTradeNo);
	
	public int countOrderNumByDate(String analysisDate);

    boolean updateStatus(String outTradeNo, Integer parseTradeStatus);

	WXPrePayRecord queryTradeStatusByPrepayId(String prepayId);
}