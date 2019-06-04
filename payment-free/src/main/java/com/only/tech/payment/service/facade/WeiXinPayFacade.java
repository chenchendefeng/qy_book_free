package com.only.tech.payment.service.facade;

import java.util.List;

import com.only.tech.entity.payment.GoodsOrder;
import com.only.tech.entity.payment.WXPrePayRecord;
import com.only.tech.payment.service.handler.WeiXinPayResultHandler;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.only.tech.payment.common.constant.CommonConstants;
import com.only.tech.payment.common.constant.WXPayConstants;
import com.only.tech.payment.service.biz.WXPrePayRecordService;
import lombok.extern.slf4j.Slf4j;

/**
 * 微信支付
 * @author zhuozhuo
 *
 */
@Slf4j
@Service
public class WeiXinPayFacade{

	@Autowired
	WeiXinPayResultHandler weiXinPayResultHandler;
	

	@Autowired
	WXPrePayRecordService wXPrePayRecordService;
	
	//收到微信支付结果通知后，请严格按照示例返回参数给微信支付：
	private static final String NOTIFY_STR_SUCCESS = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	private static final String NOTIFY_STR_FAIL = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";

	/**
	 * 接受异步通知结果
	 * @param strXml
	 * @return
	 */
	public String parseTradeNotify(String strXml) {
		log.info("parseTradeNotify strXml ={}",strXml);
		try {	
			GoodsOrder GoodsOrder = weiXinPayResultHandler.saveTradeResult(strXml);
			if(GoodsOrder == null){
				log.info("repeat notify result,strXml = {}",strXml);
				return NOTIFY_STR_SUCCESS;
			}

			//todo
//			billAndMoneyFacade.addBillByMoneyOrderUid(GoodsOrder);

			return NOTIFY_STR_SUCCESS;

		} catch (Exception e) {
			log.error("parseTradeNotify error,strXml ={}",strXml,e);
			return NOTIFY_STR_FAIL;
		}
	}


	/**
	 * 查询交易结果(根据预订单ID)
	 * @param prepayId
	 * @return
	 */
	public Integer queryTradeStatusByPrepayId(String prepayId) {
		WXPrePayRecord record=this.wXPrePayRecordService.queryTradeStatusByPrepayId(prepayId);
		if(record==null){
			return -1; //下单失败
		}
		return record.getTradeStatus();
	}

	/**
	 * 批量查询订单结果，并充币
	 * @param cuId
	 */
	@Async
	public void executeQuery(Long cuId)
	{
		//查询为查询的预订单
		List<WXPrePayRecord> records = wXPrePayRecordService.queryRecordByUidAndStatus(cuId, WXPayConstants.TRADE_STATUS_NOT_QUERY);
		if(records == null || records.size()==0){
			return ;
		}

		for(WXPrePayRecord record : records){
			queryTradeResult(record);
		}
	}


	/**
	 * 查询支付结果
	 * @param record
	 */
	private void queryTradeResult(WXPrePayRecord record) {
		String outTradeNo = record.getOutTradeNo();
		if(StringUtils.isEmpty(outTradeNo))
		{
			log.error("queryTradeResult outTradeNo is null,record id={}",record.getId());
			return;
		}
		log.info("queryTradeResult outTradeNo ={}",outTradeNo);
		try {
			GoodsOrder order = weiXinPayResultHandler.saveTradeResultByQuery(record);
			if(order == null || order.getPaymentStatus() == null || !order.getPaymentStatus().equals(CommonConstants.SUCC_PAY))
			{
				log.info("queryTradeResult no need to add bill,outTradeNo = {}",outTradeNo);
				return ;
			}
			//todo 充值完成后异步充币
//			billAndMoneyFacade.addBillByMoneyOrderUid(order);
		} catch (Exception e) {
			log.error("parseTradeNotify error,outTradeNo ={}",outTradeNo,e);
			return ;
		}
	}


}
