package com.only.tech.payment.service.handler;

import com.only.tech.entity.payment.*;
import com.only.tech.exposeinfz.common.constants.RedisCons.SysName;
import com.only.tech.exposeinfz.common.utils.AmountUtils;
import com.only.tech.payment.common.constant.CommonConstants;
import com.only.tech.payment.common.constant.CommonConstants.GoodsType;
import com.only.tech.payment.common.constant.WXPayConstants;
import com.only.tech.payment.common.utils.DateUtils;
import com.only.tech.payment.configuration.WXPayConfigBean;
import com.only.tech.payment.service.biz.*;
import com.only.tech.payment.wxsdk.WXPay;
import com.only.tech.payment.wxsdk.WXPayConfig;
import com.only.tech.payment.wxsdk.WXPayConstants.SignType;
import com.only.tech.payment.wxsdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class WeiXinPayResultHandler {

	@Autowired
	WXTradeResultService wXTradeResultService;

	@Autowired
    GoodsOrderService goodsOrderService;

	@Autowired
	WXPayConfigBean wXPayConfigBean;

	@Autowired
	WXPayConfig wxPayConfig;

	@Autowired
    OrderHandler orderHandler;

	@Autowired
	WXPrePayRecordService wXPrePayRecordService;

	@Autowired
	GoodsService goodsService;

	private static WXPay wxpay;


	/**
	 * 下单
	 * @param ipAddr
	 * @param cuId
	 * @param goodsId
	 * @param deviceInfo
	 * @param systemType
	 * @param tradeType ( JSAPI -js支付 |  NATIVE -Native支付 |  APP -APP支付 )
	 */
	public Map<String, String> weixinUnifiedOrder(String ipAddr,Long cuId,Long goodsId,String deviceInfo,String systemType,String tradeType) throws Exception {
		log.info(wXPayConfigBean.toString());
		Long readCardId = null;

		//查询费用
		Goods goods=this.goodsService.getOneById(goodsId);
		if(goods==null){
			throw new Exception("商品配置异常");
		}
		Long totalFee=goods.getGoodsPrice();
		String totalFeeStr = AmountUtils.changeF2Y(totalFee);
		String goodsCode=goods.getGoodsCode();

		//创建预订单
		WXPrePayRecord record = fillData(totalFeeStr,cuId,readCardId,ipAddr,deviceInfo,goodsCode,tradeType);
		Map<String, String> condition = getUnderOrderMap(record, totalFeeStr);
		if (wxpay == null) {
			wxpay = new WXPay(wxPayConfig, wXPayConfigBean.getNotifyUrl(), true, wXPayConfigBean.isSandbox());
		}
		wXPrePayRecordService.save(record);

		//微信下单
		Map<String, String> resuleMap = wxpay.unifiedOrder(condition);

		//解析返回数据
		String prepayId = fillResponseData(resuleMap, record);
		record.setSystemType(systemType);
		wXPrePayRecordService.updateById(record);
		Map<String, String> resultMap = getPayMap(prepayId, WXPayConstants.API_KEY, record.getOutTradeNo());

		return resultMap;
	}

	/**
	 * 请求对账单
	 * 
	 * @param billDate
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> downLoadBill(String billDate) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("bill_date", billDate);
		data.put("bill_type", "SUCCESS");
		if (wxpay == null) {
			wxpay = new WXPay(wxPayConfig, wXPayConfigBean.getNotifyUrl(), true, wXPayConfigBean.isSandbox());
		}
		return wxpay.downloadBill(data);
	}

	/**
	 * 封装下单接口map参数
	 * 
	 * @param record
	 * @return
	 */
	private Map<String, String> getUnderOrderMap(WXPrePayRecord record, String totalFeeStr) {
		Map<String, String> condition = new HashMap<String, String>();
		// 1应用ID
		condition.put("appid", record.getAppid());
		// 2商户号
		condition.put("mch_id", record.getMchId());
		// 3随机字符串
		condition.put("nonce_str", WXPayUtil.generateNonceStr());
		// 4商品描述
		condition.put("body", WXPayConstants.BODY + totalFeeStr + "元");
		// 5商户订单号
		condition.put("out_trade_no", record.getOutTradeNo());
		// 6订单总金额，单位为分
		condition.put("total_fee", String.valueOf(record.getTotalFee()));
		// 7终端IP
		condition.put("spbill_create_ip", record.getSpbillCreateIp());
		// 8接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
		condition.put("notify_url", record.getNotifyUrl());
		// 9支付类型
		condition.put("trade_type", record.getTradeType());
		condition.put("fee_type", record.getFeeType());
		condition.put("attach", record.getAttach());
		condition.put("detail", record.getDetail());
		condition.put("device_info", record.getDeviceInfo());
		return condition;
	}

	/**
	 * 异步通知，并插入订单表&支付结果表
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public GoodsOrder saveTradeResult(String xmlStr) throws Exception {

		if (StringUtils.isEmpty(xmlStr)) {
			log.error("WeiXinPayResultHandler.queryOrSaveTradeResult param is null");
			return null;
		}

		Map<String, String> notifyMap = WXPayUtil.xmlToMap(xmlStr);
		if (wxpay == null) {
			wxpay = new WXPay(wxPayConfig, wXPayConfigBean.getNotifyUrl(), true, wXPayConfigBean.isSandbox());
		}

		String tradeType=notifyMap.get("trade_type");
		if(!WXPayConstants.TRADE_TYPE_NATIVE.equals(tradeType)){
			if (!wxpay.isPayResultNotifySignatureValid(notifyMap)) {// 异步通知时延签不通过，直接返回
			   log.error("wei xin pay notify result checkSign illegal,outTradeNo={},xmlStr={}", xmlStr);
			    throw new Exception("wei xin pay notify result checkSign illegal 1");
		    }
		}

		String outTradeNo = notifyMap.get("out_trade_no");
		WXTradeResultEntity tradeResult = wXTradeResultService.findByOutTradeNo(outTradeNo);

		// 异步通知已经入库
		if (  null != tradeResult && tradeResult.getResultType() != null && tradeResult.getResultType() == CommonConstants.RESULT_TYPE_NOTIFY) {
			log.info("weixin pay notify result already in table, outTradeNo ={}", outTradeNo);
			return null;
		}


		if (tradeResult == null) { // 异步通知未入库

			tradeResult = mapToTradeResult(notifyMap, null);
			tradeResult.setCreateDate(new Date());
			wXTradeResultService.save(tradeResult);
			String resultCode = tradeResult.getResultCode();
			if (StringUtils.isEmpty(resultCode) || !resultCode.equals(WXPayConstants.TRADE_STR_SUCCESS)) {
				log.error("notify result not in table,weixin pay fail ,outTradeNo={},tradeState={}", outTradeNo,
						resultCode);
				return null;
			}
			GoodsOrder goodsOrder = this.mapToGoodsOrder(notifyMap);
			goodsOrderService.save(goodsOrder);
			return goodsOrder;

		} else { // 已经主动查询入库了

			tradeResult = mapToTradeResult(notifyMap, null);

			// 用异步通知的结果覆盖主动查询
			tradeResult.setUpdateDate(new Date());
			wXTradeResultService.updateByOutTradeNo(tradeResult);
			String resultCode = tradeResult.getResultCode();
			if (StringUtils.isEmpty(resultCode) || !resultCode.equals(WXPayConstants.TRADE_STR_SUCCESS)) {
				log.error("notify result already in table,weixin pay fail ,outTradeNo={},tradeState={}", outTradeNo,
						resultCode);
				return null;
			}

			//商品订单
			GoodsOrder goodsOrder = goodsOrderService.queryOrderByOutTradeNo(tradeResult.getOutTradeNo());
			if (goodsOrder != null) {
				log.error("weixin pay order already in table ,outTradeNo={}", outTradeNo);
				return null;
			}
			goodsOrder = this.mapToGoodsOrder(notifyMap);
			goodsOrderService.save(goodsOrder);
			return goodsOrder;
		}
	}

	/**
	 * 主动查询
	 * @param record
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public GoodsOrder saveTradeResultByQuery(WXPrePayRecord record) throws Exception {
		String outTradeNo = record.getOutTradeNo();
		WXTradeResultEntity tradeResult = wXTradeResultService.findByOutTradeNo(outTradeNo);
		if (null != tradeResult) {// 已经入库，无需再次操作
			log.info("weixin pay queryOrSaveTradeResult result already in table, outTradeNo ={}", outTradeNo);
			record.setTradeStatus(parseTradeStatus(tradeResult.getTradeState()));
			wXPrePayRecordService.updateByOutTradeNo(record);
			return null;
		}
		// 未入库
		Map<String, String> xmlToMap = queryTradeResult(outTradeNo);
		tradeResult = mapToTradeResult(xmlToMap, record);
		tradeResult.setCreateDate(new Date());
		wXTradeResultService.save(tradeResult);
		String tradeState = tradeResult.getTradeState();
		if (StringUtils.isEmpty(tradeState) || !tradeState.equals(WXPayConstants.TRADE_STR_SUCCESS)) {
			log.info("weixin pay not success ,outTradeNo={}", outTradeNo);
			return null;
		}
		// 支付成功的才生成订单
		GoodsOrder goodsOrder = this.mapToGoodsOrder(xmlToMap);
		goodsOrderService.save(goodsOrder);
		return goodsOrder;
	}

	/**
	 * 调用查询订单结果接口
	 * 
	 * @param outTradeNo
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> queryTradeResult(String outTradeNo) throws Exception {
		Map<String, String> paramMap = new HashMap<>();
		try {
			paramMap.put("out_trade_no", outTradeNo);
			log.info("weixin underOrder outTradeNo ={}", outTradeNo);
			if (wxpay == null) {
				wxpay = new WXPay(wxPayConfig, wXPayConfigBean.getNotifyUrl(), true, wXPayConfigBean.isSandbox());
			}
			Map<String, String> resp = wxpay.orderQuery(paramMap);
			log.info("weixin pay queryTradeResult  outTradeNo ={}, response ={}", outTradeNo, resp);
			return resp;
		} catch (Exception e) {
			log.error("queryTradeResult error,outTradeNo ={}", outTradeNo, e);
			throw e;
		}
	}

	/**
	 * 解析交易结果到WXTradeResultEntity
	 * 
	 * @param xmlToMap
	 * @return
	 */
	private WXTradeResultEntity mapToTradeResult(Map<String, String> xmlToMap, WXPrePayRecord record) {
		WXTradeResultEntity entity = new WXTradeResultEntity();
		String returnCode = xmlToMap.get("return_code");
		String outTradeNo = xmlToMap.get("out_trade_no");
		entity.setOutTradeNo(outTradeNo);
		if (null == record) {
			entity.setResultType(CommonConstants.RESULT_TYPE_NOTIFY);
			// 异步通知的字段
			String resultCode = xmlToMap.get("result_code");
			record = new WXPrePayRecord();
			record.setOutTradeNo(outTradeNo);
			if (StringUtils.isNotEmpty(returnCode) && CommonConstants.STR_SUCCESS.equals(returnCode)
					&& StringUtils.isNotEmpty(resultCode) && CommonConstants.STR_SUCCESS.equals(resultCode)) {
				record.setTradeStatus(WXPayConstants.TRADE_STATUS_PAY_SUCC);
			} else {
				record.setTradeStatus(WXPayConstants.TRADE_STATUS_PAY_FAIL);
			}
			entity.setResultCode(resultCode);
		} else {
			entity.setResultType(CommonConstants.RESULT_TYPE_QUERY);
			// 主动查询的字段
			String tradeState = xmlToMap.get("trade_state");
			if (StringUtils.isNotEmpty(returnCode) && CommonConstants.STR_SUCCESS.equals(returnCode)) {
				record.setTradeStatus(parseTradeStatus(tradeState));
			} else {
				record.setTradeStatus(WXPayConstants.TRADE_STATUS_PAY_FAIL);
			}

		}
		entity.setReturnCode(returnCode);
		entity.setReturnMsg(xmlToMap.get("return_msg"));

		entity.setAppid(xmlToMap.get("appid"));
		entity.setMchId(xmlToMap.get("mch_id"));
		entity.setErrCode(xmlToMap.get("err_code"));
		entity.setErrCodeDes(xmlToMap.get("err_code_des"));
		entity.setOpenid(xmlToMap.get("openid"));
		entity.setTradeState(xmlToMap.get("trade_state"));
		entity.setBankType(xmlToMap.get("bank_type"));
		String totalFee = xmlToMap.get("total_fee");
		if (StringUtils.isNotEmpty(totalFee)) {
			entity.setTotalFee(Integer.valueOf(totalFee));
		}
		entity.setTransactionId(xmlToMap.get("transaction_id"));

		entity.setAttach(xmlToMap.get("attach"));
		entity.setTimeEnd(xmlToMap.get("time_end"));
		entity.setTradeStateDesc(xmlToMap.get("trade_state_desc"));

		wXPrePayRecordService.updateByOutTradeNo(record);
		return entity;
	}
	/**
	 * 根据map解析成订单表数据
	 * 
	 * @param xmlToMap
	 * @return
	 * @throws ParseException
	 */
	private GoodsOrder mapToGoodsOrder(Map<String, String> xmlToMap) throws ParseException {

		GoodsOrder goodsOrder = new GoodsOrder();
		String outTradeNo = xmlToMap.get("out_trade_no");
		goodsOrder.setOrderNum(outTradeNo);

		String attach = xmlToMap.get("attach");

		//用户 & 商品编号
		if (StringUtils.isNotEmpty(attach)) {
			String[] attachArray = attach.split(CommonConstants.SPILE_SYMBOL_SPLIT);
			goodsOrder.setCuId(Long.parseLong(attachArray[0]));
			goodsOrder.setGoodsCode(attachArray[1]);
		}

		//费用 & 支付方式
		String totalFee = xmlToMap.get("total_fee");
		if (StringUtils.isNotEmpty(totalFee)) {
			goodsOrder.setGoodsPrice(Long.parseLong(totalFee));
		}
		goodsOrder.setPayMethod(WXPayConstants.PAY_METHOD_WX);

		//交易状态
		String tradeState = xmlToMap.get("trade_state");
		// 主动查询时的判断逻辑
		if (StringUtils.isNotEmpty(tradeState)) {
			if (CommonConstants.STR_SUCCESS.equals(tradeState)) {
				goodsOrder.setPaymentStatus(CommonConstants.SUCC_PAY);
			} else {
				goodsOrder.setPaymentStatus(CommonConstants.FAIL_PAY);
			}
		}
		// 微信异步通知时的逻辑
		else {
			String resultCode = xmlToMap.get("result_code");
			if (StringUtils.isNotEmpty(resultCode) && CommonConstants.STR_SUCCESS.equals(resultCode)) {
				goodsOrder.setPaymentStatus(CommonConstants.SUCC_PAY);
			} else {
				goodsOrder.setPaymentStatus(CommonConstants.FAIL_PAY);
			}
		}
		String endTime = xmlToMap.get("time_end");
		if (StringUtils.isNotEmpty(endTime)) {
			goodsOrder.setPayTime(DateUtils.timeStrToDate(endTime, DateUtils.NO_SYMBLE_FORMAT));
		}
		goodsOrder.setCreateDate(new Date());
		WXPrePayRecord queryRecordByOutTradeNo = wXPrePayRecordService.queryRecordByOutTradeNo(outTradeNo);
		if (queryRecordByOutTradeNo != null) {
			goodsOrder.setSystemType(queryRecordByOutTradeNo.getSystemType());
		}
		return goodsOrder;
	}

	/**
	 * 获取支付接口map，返回给app,使用时要remove out_trade_no，并在查询订单结果时传入
	 * 
	 * @param prepayid
	 * @return
	 * @throws Exception
	 */
	private Map<String, String> getPayMap(String prepayid, String apikey, String orderNo) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("prepayid", prepayid);
		params.put("appid", WXPayConstants.APP_ID);
		params.put("partnerid", WXPayConstants.MCH_ID);
		params.put("package", "Sign=WXPay");
		params.put("noncestr", WXPayUtil.generateNonceStr());
		params.put("timestamp", String.valueOf(DateUtils.getCurrentTimestamp()));
		log.info("WeiXinPay getPayMap ={}", params);
		SignType signType = wXPayConfigBean.isSandbox() ? SignType.MD5 : SignType.HMACSHA256;
		String sign = WXPayUtil.generateSignature(params, apikey, signType);
		params.put("sign", sign);
		params.put("out_trade_no", orderNo);
		return params;
	}

	/**
	 * 解析返回数据
	 * 
	 * @param resuleMap
	 * @param record
	 * @return
	 */
	private String fillResponseData(Map<String, String> resuleMap, WXPrePayRecord record) {
		String prepayId = null;
		String returnCode = resuleMap.get("return_code");
		record.setReturnCode(returnCode);
		record.setUpdateDate(new Date());
		if (returnCode != null && CommonConstants.STR_SUCCESS.equals(returnCode)) {
			String resultCode = resuleMap.get("result_code");
			String errCode = resuleMap.get("err_code");
			String errCodeDes = resuleMap.get("err_code_des");
			record.setResultCode(resultCode);
			record.setErrCode(errCode);
			record.setErrCodeDes(errCodeDes);
			// 成功
			if (resultCode != null && CommonConstants.STR_SUCCESS.equals(resultCode)) {
				prepayId = resuleMap.get("prepay_id");
				record.setPrepayId(prepayId);
				record.setTradeStatus(WXPayConstants.TRADE_STATUS_NOT_QUERY);
				log.info("weixin pay fillResponseData success,uid ={},prepayId={}", record.getAttach(), prepayId);
				return prepayId;
			} else {
				log.error("weixin pay fillResponseData error,uid={},err_code_des={}", record.getAttach(),
						record.getErrCodeDes());
			}
		} else {
			record.setReturnMsg(resuleMap.get("return_msg"));
			log.error("weixin pay fillResponseData error,uid={},return_msg={}", record.getAttach(),
					record.getReturnMsg());
		}
		record.setTradeStatus(WXPayConstants.TRADE_STATUS_UNDER_BILL_FAIL);
		return prepayId;
	}


	/**
	 * 组装下单接口参数
	 * @param totalFeeStr
	 * @param uid
	 * @param ip
	 * @return
	 */
	private WXPrePayRecord fillData(String totalFeeStr, Long uid, Long readCardId, String ip, String deviceInfo,
			String goodsCode,String tradeType) {

		WXPrePayRecord record = new WXPrePayRecord();
		record.setAppid(WXPayConstants.APP_ID);
		record.setMchId(WXPayConstants.MCH_ID);

		String attach = uid + CommonConstants.SPILE_SYMBOL_CONTANT+goodsCode + CommonConstants.SPILE_SYMBOL_CONTANT + GoodsType.VIP; // 参数格式是 uid|^^|cardId|^^|type
		record.setAttach(attach);
		record.setOutTradeNo(orderHandler.getOrderNoByRedis(SysName.PAYMENT));
		Long totalFee = Long.parseLong(AmountUtils.changeY2F(totalFeeStr));
		record.setTotalFee(totalFee.intValue());
		record.setSpbillCreateIp(ip);
		record.setNotifyUrl(wXPayConfigBean.getNotifyUrl());
		record.setTradeType(tradeType);
		if (wXPayConfigBean.isSandbox()) {
			record.setSignType(WXPayConstants.SIGN_TYPE_MD5);
		} else {
			record.setSignType(WXPayConstants.SIGN_TYPE_SHA);
		}
		record.setTimeStart(DateUtils.getTimeStr(DateUtils.NO_SYMBLE_FORMAT));
		record.setTimeExpire(DateUtils.getTimeByMinute(wXPayConfigBean.getExpireMinute(), DateUtils.NO_SYMBLE_FORMAT));
		record.setFeeType("CNY");
		record.setDetail("充值" + totalFeeStr + "元");
		record.setDeviceInfo(deviceInfo);
		record.setUid(uid);
		record.setCreateDate(new Date());
		return record;
	}

	/**
	 * SUCCESS—支付成功 ---6 REFUND—转入退款 ----7 NOTPAY—未支付 -----2 CLOSED—已关闭 -----3
	 * REVOKED—已撤销（刷卡支付）---7 USERPAYING--用户支付中 ----4
	 * PAYERROR--支付失败(其他原因，如银行返回失败)---5
	 * 
	 * @param tradeState
	 * @return
	 */
	private Integer parseTradeStatus(String tradeState) {
		if (StringUtils.isEmpty(tradeState)) {
			return WXPayConstants.TRADE_STATUS_OTHER;
		}
		switch (tradeState) {
		case WXPayConstants.TRADE_STR_SUCCESS:
			return WXPayConstants.TRADE_STATUS_PAY_SUCC;
		case WXPayConstants.TRADE_STR_NO_PAY:
			return WXPayConstants.TRADE_STATUS_NOT_PAY;
		case WXPayConstants.TRADE_STR_CLOSED:
			return WXPayConstants.TRADE_STATUS_CLOSED;
		case WXPayConstants.TRADE_STR_USERPAYING:
			return WXPayConstants.TRADE_STATUS_PAYING;
		case WXPayConstants.TRADE_STR_PAYERROR:
			return WXPayConstants.TRADE_STATUS_PAY_FAIL;
		default:
			return WXPayConstants.TRADE_STATUS_OTHER;
		}
	}
}
