package com.only.tech.payment.service.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import com.only.tech.entity.payment.PCheckOrderDiff;
import com.only.tech.entity.payment.PWxBillCollect;
import com.only.tech.entity.payment.PWxBillDetail;
import com.only.tech.payment.service.handler.WeiXinPayResultHandler;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.only.tech.exposeinfz.common.utils.AmountUtils;
import com.only.tech.payment.common.constant.CommonConstants;
import com.only.tech.payment.common.constant.WXPayConstants;
import com.only.tech.payment.service.biz.IPCheckOrderDiffService;
import com.only.tech.payment.service.biz.IPWxBillCollectService;
import com.only.tech.payment.service.biz.IPWxBillDetailService;
import com.only.tech.payment.service.biz.GoodsOrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WeixinBillFacade {
	@Autowired
	private WeiXinPayResultHandler weiXinPayResultHandler;
	@Autowired
	private IPCheckOrderDiffService iPCheckOrderDiffService;
	@Autowired
	private IPWxBillDetailService iPWxBillDetailService;
	@Autowired
	private IPWxBillCollectService iPWxBillCollectService;
	@Autowired
	private GoodsOrderService goodsOrderService;
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	/**
	 * 对账开始
	 * @param billDate
	 */
	@Async
	public void executeCheckWeiXinBill(String billDate)
	{
		try {
			Map<String, String> resData = weiXinPayResultHandler.downLoadBill(billDate);
			log.info("executeCheckWeiXinBill download weixin bill resData={},billDate={}",resData,billDate);
			if(resData == null)
			{
				log.error("executeCheckWeiXinBill download weixin bill get an empty resData,billDate={}",billDate);
				return ;
			}
			String return_code = resData.get("return_code");
			if(StringUtils.isEmpty(return_code) || !CommonConstants.STR_SUCCESS.equals(return_code))
			{
				log.error("executeCheckWeiXinBill download weixin bill error, resData={},billDate={}",resData,billDate);
				return ;
			}
			String data = resData.get("data");
			if(data == null)
			{
				log.error("executeCheckWeiXinBill download weixin bill error, data is empty,resData={},billDate={}",resData,billDate);
				return ;
			}
			String fileRedisKey = saveBillDate(data, billDate);
			if(fileRedisKey == null)
			{
				log.info("executeCheckWeiXinBill download weixin bill end, resData={},billDate={}",resData,billDate);
				return ;
			}
			doCompareBill(billDate, fileRedisKey);
			log.info("executeCheckWeiXinBill download weixin bill success, resData={},billDate={}",resData,billDate);
		} catch (Exception e) {
			log.error("executeCheckWeiXinBill download weixin bill error,billDate={}",billDate,e);
		}
	}
	
	
	/**
	 * 比较账单
	 * @param billDate
	 */
	public void doCompareBill(String billDate,String fileRedisKey)
	{
		String dbRedisKey = WXPayConstants.WX_PAY_BILL_DB_KEY_PREFIX + billDate;
		Set<String> outTradeNoAndMoneyFromDb = goodsOrderService.queryOutTradeNoAndMoney(billDate, WXPayConstants.PAY_METHOD_WX);
		if(outTradeNoAndMoneyFromDb != null && !outTradeNoAndMoneyFromDb.isEmpty())
		{
			redisTemplate.opsForSet().add(dbRedisKey,outTradeNoAndMoneyFromDb.toArray(new String[outTradeNoAndMoneyFromDb.size()]));
			redisTemplate.expire(dbRedisKey, 5, TimeUnit.MINUTES);
		}
		Set<String> difference = redisTemplate.opsForSet().difference(fileRedisKey,dbRedisKey);
		handlerDiffOrder(difference,billDate);
	}
	/**
	 * 处理异常订单
	 * @param difference
	 * @param billDate
	 */
	public void handlerDiffOrder(Set<String> difference,String billDate) {
		if (difference == null || difference.size() == 0) {
			log.info("no differ order");
			return;
		}
		log.warn("executeCheck weixin Bill difference={},billDate={}", difference,billDate);
		Set<String> outTradeNoList = new LinkedHashSet<>();
		String[] outTradeNoAndMoney;
		for (String str : difference) {
			outTradeNoAndMoney = str.split(CommonConstants.SPILE_SYMBOL_SPLIT);
			if (outTradeNoAndMoney == null) {
				continue;
			}
			outTradeNoList.add(outTradeNoAndMoney[0]);
		}
		log.info("handlerDiffOrder diff outTradeNoList={},billDate={}", outTradeNoList,billDate);
		List<PWxBillDetail> queryByOutTradeNos = iPWxBillDetailService.queryByOutTradeNos(outTradeNoList);
		if (queryByOutTradeNos == null || queryByOutTradeNos.isEmpty()) {
			log.error("query order detail get an empty result, difference={},billDate={}", difference,billDate);
			return;
		}
		List<PCheckOrderDiff> diffOrderLists = new ArrayList<>(queryByOutTradeNos.size());
		PCheckOrderDiff diffOrder;
		for (PWxBillDetail billDetail : queryByOutTradeNos) {
			diffOrder = new PCheckOrderDiff();
			diffOrder.setBillId(billDetail.getId());
			diffOrder.setOutTradeNo(billDetail.getOutTradeNo());
			diffOrder.setPayMethod(WXPayConstants.PAY_METHOD_WX);
			diffOrder.setTradeFinishDate(billDetail.getTradeTime());
			diffOrder.setTradeNo(billDetail.getTradeNo());
			diffOrder.setBillDate(billDate);
			diffOrder.setBillFrom(CommonConstants.BILL_TYPE_DAY);
			diffOrder.setTotalAmount(billDetail.getTotalAmount());
			diffOrder.setCreateDate(new Date());
			diffOrderLists.add(diffOrder);
		}
		iPCheckOrderDiffService.saveBatch(diffOrderLists);
		log.info("handlerDiffOrder save diff orders success,outTradeNoList={},billDate={}", outTradeNoList,billDate);
	}


	/**
	 * 保存账单明细和汇总
	 * @param data
	 * @param billDate
	 * @return
	 */
	@Transactional
	public String saveBillDate(String data,String billDate)
	{
		String tradeMsg = data.substring(data.indexOf("`")).replace("`", "");
		String[] contentArray = tradeMsg.split("\n");
		int length = contentArray.length;
		PWxBillCollect collect = null;
		Set<PWxBillDetail> detailSet = new HashSet<>();
		Set<String> tradeNoAndMoneySet = new HashSet<>();
		if(length <= 1)
		{
			log.error("weixin pay saveBillDate data is error,data={},billDate={}",data,billDate);
			return null;
		}
		for(int i = 0;i < length ;i++)
		{
			if(i == length-2)
			{//倒数第二行
				continue;
			}
			if(i == length-1)
			{//最后一行，汇总数据
				String collectData = contentArray[i];
				collect = parseCollectData(collectData, billDate);
				continue;
			}
			parseDetailData(contentArray[i], billDate, detailSet, tradeNoAndMoneySet);
		}
		if(collect != null)
		{
			iPWxBillCollectService.save(collect);
		}
		if(!detailSet.isEmpty())
		{
			iPWxBillDetailService.saveBatch(detailSet, 1000);
		}
		if(tradeNoAndMoneySet.isEmpty())
		{
			return null;
		}
		String fileRedisKey = WXPayConstants.WX_PAY_BILL_FILE_KEY_PREFIX + billDate;
		redisTemplate.opsForSet().add(fileRedisKey, tradeNoAndMoneySet.toArray(new String[tradeNoAndMoneySet.size()]));
		redisTemplate.expire(fileRedisKey, 5, TimeUnit.MINUTES);
		return fileRedisKey;
	}
	
	/**
	 * 解析账单汇总
	 * @param collectData
	 * @param billDate
	 * @return
	 */
	public PWxBillCollect parseCollectData(String collectData,String billDate)
	{
		String[] collectArray = collectData.split(",");
		if(collectArray.length < 7)
		{
			log.error("weixin pay parseCollectData error,collectData={},billData={}",collectData,billDate);
			return null;
		}
		PWxBillCollect collect = new PWxBillCollect();
		collect.setTradeNCount(Integer.parseInt(collectArray[0]));
		collect.setBalanceTotalAmount(collectArray[1]);
		collect.setRefundTotalAmount(collectArray[2]);
		collect.setTicketRefundTotalAmount(collectArray[3]);
		collect.setTotalServerAmount(collectArray[4]);
		collect.setTotalAmount(collectArray[5]);
		collect.setApplyRefundTotalAmount(collectArray[6]);
		collect.setBillDate(billDate);
		collect.setCreateDate(new Date());
		return collect;
	}
	/**
	 * 解析账单详情
	 * @param lineContent
	 * @param billDate
	 * @return
	 */
	public void parseDetailData(String lineContent,String billDate,Set<PWxBillDetail> detailSet,
			Set<String> tradeNoAndMoneySet)
	{
		String[] detailArray = lineContent.split(",");
		if(detailArray.length < 20)
		{
			log.error("weixin pay parseCollectData error,lineContent={},billDate={}",lineContent,billDate);
			return;
		}
		PWxBillDetail detail = new PWxBillDetail();
		detail.setBillDate(billDate);
		detail.setTradeTime(detailArray[0]);
		detail.setDeviceInfo(detailArray[4]);
		detail.setTradeNo(detailArray[5]);
		detail.setOutTradeNo(detailArray[6]);
		detail.setUserFlag(detailArray[7]);
		detail.setPayBank(detailArray[10]);
		detail.setTradeMoney(detailArray[12]);
		detail.setGoodsName(detailArray[14]);
		detail.setAttach(detailArray[15]);
		detail.setServerAmount(detailArray[16]);
		detail.setRate(detailArray[17]);
		detail.setTotalAmount(detailArray[18]);
		detail.setRateRemarks(detailArray[19]);
		detail.setCreateDate(new Date());
		detailSet.add(detail);
		StringBuilder sb = new StringBuilder();
		sb.append(detail.getOutTradeNo()).append(CommonConstants.SPILE_SYMBOL_CONTANT);
		sb.append(AmountUtils.changeY2F(detail.getTotalAmount()));
		tradeNoAndMoneySet.add(sb.toString());
	}
}








