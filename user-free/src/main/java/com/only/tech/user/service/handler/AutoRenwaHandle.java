package com.only.tech.user.service.handler;

import com.github.wxpay.sdk.WXPayUtil;
import com.only.tech.base.result.ResultDto;
import com.only.tech.constant.TencentApiConstants;
import com.only.tech.entity.user.WxAutoRenewaApplicationAgreement;
import com.only.tech.entity.user.WxRenewaResultRecord;
import com.only.tech.user.common.constant.WXConfigConstants;
import com.only.tech.user.common.utils.AntoRenewUtils;
import com.only.tech.user.service.biz.WxRenewaResultRecordService;
import com.only.tech.user.service.facade.AutoRenewaFacade;
import com.only.tech.user.service.facade.WxAutoRenewaApplicationAgreementFacade;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.HttpUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AutoRenwaHandle {
	
	@Autowired
	WxRenewaResultRecordService wxRenewaResultRecordService;
	
	@Autowired
    AutoRenewaFacade autoRenewaFacade;

	@Autowired
	private WxAutoRenewaApplicationAgreementFacade wxAutoRenewaApplicationAgreementFacade;

	/**
	 * 查询签约/解约，微信返回结果
	 *
	 * @param uid
	 * @param contractCode
	 * @param changeType
	 * @return
	 * @throws Exception
	 */
	public ResultDto checkWxResult(Long uid, String contractCode, String changeType) throws Exception {

		WxRenewaResultRecord resultRecord = wxRenewaResultRecordService.getByContractCodeChangeType(contractCode, changeType);
		if (resultRecord != null) {
			log.info("checkWxResult result already in DB,no need to query,uid={},contractCode={}",uid,contractCode);
			return checkRenewaResult(changeType,contractCode);
		}
		//签约or解约未收到返回,主动去查询
		String resultXml = queryContractResult(contractCode);
		log.info("主动查询微信签约状态结果：{}",resultXml);
		String checkResult = autoRenewaFacade.parseResult(resultXml,changeType,contractCode);

		return checkRenewaResult(changeType,contractCode);

		/*if(WXConfigConstants.NOTIFY_STR_SUCCESS.equals(checkResult)){
			return ResultDto.succesResult();
		}else{
			return ResultDto.errorResult();
		}*/
	}


	/**
	 * 检查协议的状态
	 * @param changeType
	 * @param contractCode
	 * @return
	 */
	private ResultDto checkRenewaResult(String changeType,String contractCode){
		WxAutoRenewaApplicationAgreement agreement = wxAutoRenewaApplicationAgreementFacade.getByContractCode(contractCode);
		if (agreement != null){
			Integer renewaStatus = agreement.getRenewaStatus();
			if (StringUtils.isNotBlank(changeType) && WXConfigConstants.CHANGE_TYPE_ADD.equals(changeType)){
				//签约
				if (renewaStatus.equals(1)){
					//成功
					return ResultDto.succesResult();
				}else {
					//失败
					return ResultDto.errorResult();
				}
			}else if (WXConfigConstants.CHANGE_TYPE_DELETE.equals(changeType)){
				//解约
				if (renewaStatus.equals(0)){
					//成功
					return ResultDto.succesResult();
				}else {
					//失败
					return ResultDto.errorResult();
				}
			}
		}
		return ResultDto.errorResult();
	}

	/**
	 * 获取查询签约结果
	 *
	 * @param contractCode
	 * @return
	 * @throws Exception
	 */
	public String queryContractResult(String contractCode) throws Exception {
		// 组织参数
		Map<String, String> params = new HashMap<>();
		AntoRenewUtils.putBaseParams(params);
		params.put("contract_code", contractCode);
		params.put("plan_id", TencentApiConstants.PLAN_ID);
		String sign = AntoRenewUtils.getSign(params);
		params.put("sign", sign);
		String xmlStr = WXPayUtil.mapToXml(params);
		return HttpUtils.httpPost(TencentApiConstants.WX_CONTRACT_QUERY_RESULT_URL, xmlStr);
	}
}
