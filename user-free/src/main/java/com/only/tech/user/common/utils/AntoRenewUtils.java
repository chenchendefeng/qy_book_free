package com.only.tech.user.common.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.only.tech.entity.user.WxRenewaResultRecord;
import com.only.tech.user.dto.WxRenewaResultDto;
import org.apache.commons.lang.StringUtils;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import com.only.tech.constant.TencentApiConstants;
import com.only.tech.user.common.constant.WXConfigConstants;

import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.DateFormatUtil;

@Slf4j
public class AntoRenewUtils {
	/**
	 * 自动续费 签约/解约 基础参数
	 *
	 * @param params
	 */
	public static void putBaseParams(Map<String, String> params) {
		params.put("appid", TencentApiConstants.WX_APPID);
		params.put("mch_id", TencentApiConstants.MCH_ID);
		params.put("version", WXConfigConstants.VERSION);
	}
	

	/**
	 * 获取签名
	 *
	 * @param params
	 * @return
	 */
	public static String getSign(Map<String, String> params) {
		WXPayConstants.SignType signType = WXPayConstants.SignType.MD5;
		String sign = null;
		try {
			sign = WXPayUtil.generateSignature(params, WXConfigConstants.API_KEY, signType);
		} catch (Exception e) {
			log.error("AntoRenewUtils getSign error",e);
		}
		return sign;
	}
	
	/**
	 * 申请解约
	 *
	 * @param contractId
	 * @return
	 */
	public static Map<String, String> applyRescission(String contractId,String contractCode) {
		// 组织参数
		Map<String, String> params = new HashMap<>();
		putBaseParams(params);
		params.put("plan_id",TencentApiConstants.PLAN_ID);
		params.put("contract_code",contractCode);
		params.put("contract_id", contractId);
		params.put("contract_termination_remark", WXConfigConstants.RESCISSION_REMARK);
		String sign = getSign(params);
		params.put("sign", sign);

		return params;
	}
	
	/**
	 * 解析结果集合
	 *
	 * @param notifyMap
	 * @return
	 */
	public static WxRenewaResultRecord praseResultMap(Map<String, String> notifyMap, String changeType) {
		WxRenewaResultRecord wxRenewaResultRecord = null;// 处理业务
		// 返回状态码 SUCCESS/FAIL
		String returnCode = notifyMap.get("return_code");
		if (returnCode != null && WXConfigConstants.SUCCESS.equals(returnCode)) {
			// 业务结果 SUCCESS/FAIL
			String resultCode = notifyMap.get("result_code");
			if (StringUtils.isNotBlank(resultCode) && WXConfigConstants.SUCCESS.equals(resultCode)) {

				wxRenewaResultRecord = new WxRenewaResultRecord();

				// 签约协议号
				String contractCode = notifyMap.get("contract_code");
				wxRenewaResultRecord.setContractCode(contractCode);
				if(changeType == null){
					// 变更类型 ADD--签约 DELETE--解约
					changeType = notifyMap.get("change_type");
					wxRenewaResultRecord.setChangeType(changeType);
					//根据变更类型来插入签约状态
					wxRenewaResultRecord.setContractState(changeType.equals(WXConfigConstants.CHANGE_TYPE_DELETE)?1:0);
				}else{
					wxRenewaResultRecord.setChangeType(changeType);
					String contractState = notifyMap.get("contract_state");
					wxRenewaResultRecord.setContractState(Integer.parseInt(contractState));
				}

				// 委托代扣协议id
				String contractId = notifyMap.get("contract_id");
				wxRenewaResultRecord.setContractId(contractId);

				// 协议到期时间
				String contractExpiredTime = notifyMap.get("contract_expired_time");
				if (StringUtils.isNotBlank(contractExpiredTime)) {
					Date date = DateFormatUtil.parse(contractExpiredTime);
					wxRenewaResultRecord.setContractExpiredTime(date);
				}

				// 协议解约方式
				String contractTerminationMode = notifyMap.get("contract_termination_mode");
				wxRenewaResultRecord.setContractTerminationMode(contractTerminationMode);

				// 请求序列
				String requestSerial = notifyMap.get("request_serial");
				wxRenewaResultRecord.setRequestSerial(requestSerial);

			} else {
				log.info("签约/解约，微信失败");
			}
		} else {
			// 返回信息
			String returnMsg = notifyMap.get("return_msg");
			log.info("签约/解约  微信返回失败，信息：{}", returnMsg);
		}

		return wxRenewaResultRecord;
	}
}
