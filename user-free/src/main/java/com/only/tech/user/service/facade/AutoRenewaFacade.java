package com.only.tech.user.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.base.result.ResultDto;
import com.only.tech.constant.ClientTypeConstants;
import com.only.tech.constant.TencentApiConstants;
import com.only.tech.entity.payment.Goods;
import com.only.tech.entity.user.AutoRenewa;
import com.only.tech.entity.user.Customer;
import com.only.tech.entity.user.WxAutoRenewaApplicationAgreement;
import com.only.tech.entity.user.WxRenewaResultRecord;
import com.only.tech.exposeinfz.payment.api.DedutionInfz;
import com.only.tech.exposeinfz.payment.api.GoodsInfz;
import com.only.tech.user.common.constant.WXConfigConstants;
import com.only.tech.user.common.enums.RenewaAgreementStatusEnum;
import com.only.tech.user.common.enums.RenewaStatusEnum;
import com.only.tech.user.common.enums.WXBindStatusEnum;
import com.only.tech.user.common.utils.AntoRenewUtils;
import com.only.tech.user.configuration.DomainUrlConfig;
import com.only.tech.user.dto.AutoRenewaDto;
import com.only.tech.user.service.biz.AutoRenewaService;
import com.only.tech.user.service.biz.CustomerService;
import com.only.tech.user.service.biz.WxRenewaResultRecordService;
import com.only.tech.user.wxsdk.WXPay;
import com.only.tech.user.wxsdk.WXPayConfig;
import com.only.tech.user.wxsdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.DateFormatUtil;
import ooh.chaos.util.ProfileUtil;
import ooh.chaos.util.UuidUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/15
 */
@Service
@Slf4j
public class AutoRenewaFacade {

	@Autowired
	private AutoRenewaService autoRenewaService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private WxAutoRenewaApplicationAgreementFacade wxAutoRenewaApplicationAgreementFacade;

	@Autowired
	private WxRenewaResultRecordFacade wxRenewaResultRecordFacade;

	@Reference
	private GoodsInfz goodsInfz;

//	@Autowired
//	private VipRecordFacade vipRecordFacade;

	@Autowired
	private WxRenewaResultRecordService wxRenewaResultRecordService;

	@Autowired
    private DomainUrlConfig domainUrlConfig;

	@Reference
	private DedutionInfz dedutionInfz;

    @Autowired
    private WXPayConfig wxPayConfig;

	private static WXPay wxPay;

	public AutoRenewa getOne(Long cuId) {
		Wrapper qw = new QueryWrapper<AutoRenewa>().eq("cuId", cuId);

		return autoRenewaService.getOne(qw);
	}

	/**
	 * 检查连续包月状态
	 *
	 * @param cuId
	 * @return 0:未开通；1：已开通
	 */
	public AutoRenewaDto check(Long cuId) {

		AutoRenewaDto autoRenewaDto = new AutoRenewaDto();

		// 续费状态
		autoRenewaDto.setRenewaStatus(
				isAutoRenewa(cuId) ? RenewaStatusEnum.OPEN.getStatus() : RenewaStatusEnum.OFF.getStatus());

		// 微信绑定状态
		Boolean bind = customerService.isBindWX(cuId);
		autoRenewaDto.setWxBindStatus(bind ? WXBindStatusEnum.BIND.getStatus() : WXBindStatusEnum.UNBIND.getStatus());

		return autoRenewaDto;
	}

	/**
	 * 是否是自动续费状态
	 *
	 * @param cuId
	 * @return
	 */
	public boolean isAutoRenewa(Long cuId) {
		AutoRenewa autoRenewa = getOne(cuId);
		if (autoRenewa != null) {
			Integer status = autoRenewa.getStatus();
			if (status != null && status.equals(1)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 申请签约
	 *
	 * @param cuId
	 * @param goodsId
	 * @param clientType
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public ResultDto applyRenewa(Long cuId, Long goodsId, String clientType) {

		Customer customer = customerService.getByCuId(cuId);
		if (customer == null) {
			return ResultDto.errorResult("用户不存在");
		}

		// 检查用户是否续费状态
		boolean isAutoRenewa = isAutoRenewa(cuId);

		if (isAutoRenewa){
			return ResultDto.errorResult("已经签约，无需重复签约");
		}

		//处理正在签约的协议
		List<Map<String,String>> mapList = wxAutoRenewaApplicationAgreementFacade.doUnfinishedAgreement(cuId);
		if (mapList != null){
			for (Map<String, String> map : mapList) {
				String resultXml = map.get("resultXml");
				String contractCode = map.get("contractCode");
				log.info("处理正在签约的 结果XML：{}",resultXml);
				parseResult(resultXml,"ADD",contractCode);
			}
			// 检查用户是否续费状态
			isAutoRenewa = isAutoRenewa(cuId);
			if (isAutoRenewa){
				return ResultDto.errorResult("已经签约，无需重复签约");
			}
		}

		Map<String, String> resultMap = getParamsMap(cuId,goodsId, clientType);
		return resultMap != null?ResultDto.succesResult(resultMap):ResultDto.errorResult("商品错误");
	}

	/**
    * 组织参数
    * @param cuId
    * @param goodsId
	 * @return
    */
   private Map<String, String> getParamsMap(Long cuId, Long goodsId, String clientType) {

	   Goods goods = goodsInfz.getOneById(goodsId);
	   if (goods == null){
	   		return null;
	   }

       Map<String, String> params = new HashMap<>();

       //组织签约数据
       AntoRenewUtils.putBaseParams(params);

	   params.put("plan_id", TencentApiConstants.PLAN_ID);
	   params.put("return_app", WXConfigConstants.RETURN_APP.toString());

       String notifyUrl = domainUrlConfig.getDomainUrl()+ WXConfigConstants.RENEWA_NOTIFY_URL;
       params.put("notify_url",notifyUrl);

       WxAutoRenewaApplicationAgreement agreement = wxAutoRenewaApplicationAgreementFacade.getUnApplyAgreementByCuid(cuId);
       //签约协议号
       String contractCode = null;
       //请求序列号
       Long requestSerial = null;
       if (agreement != null){
           contractCode = agreement.getContractCode();
           requestSerial = agreement.getRequestSerial();

       }else {
           contractCode = UuidUtil.getCodeByCuid(cuId);
           //请求序列号
           requestSerial = ProfileUtil.getAtomicCounter();

           agreement = new WxAutoRenewaApplicationAgreement();
           agreement.setCuId(cuId);
           agreement.setContractCode(contractCode);
           agreement.setRequestSerial(requestSerial);
           agreement.setStatus(RenewaAgreementStatusEnum.APPLY.getStatus());
           Date now = new Date();
           agreement.setCreateDate(now);
           agreement.setUpdateDate(now);

           agreement.setGoodsId(goodsId);

           wxAutoRenewaApplicationAgreementFacade.save(agreement);
       }

       params.put("contract_code",contractCode);
       params.put("request_serial",String.valueOf(requestSerial));

       //用户账户展示名称
       Customer customer = customerService.getByCuId(cuId);
       String userName = "";
       if (customer != null){
           userName = customer.getNickName();
       }
       params.put("contract_display_account",userName);
       params.put("timestamp",String.valueOf(DateFormatUtil.getCurrentTimestamp()));

       String sign = AntoRenewUtils.getSign(params);
       params.put("sign",sign);

       try {
           if (ClientTypeConstants.IOS.equalsIgnoreCase(clientType)){
                   notifyUrl = URLEncoder.encode(notifyUrl, "utf-8");
                   notifyUrl = URLEncoder.encode(notifyUrl, "utf-8");
           }else if (ClientTypeConstants.ANDROID.equalsIgnoreCase(clientType)){
               notifyUrl = URLEncoder.encode(notifyUrl, "utf-8");
           }
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }

       params.put("notify_url",notifyUrl);
       return params;
   }




	/**
	 * 解析签约/解约结果
	 * changeType =null 时是主动查询
	 * @param xmlStr
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public String parseResult(String xmlStr,String changeType,String contractCode) {

		try {
			Map<String, String> notifyMap = WXPayUtil.xmlToMap(xmlStr);
			log.info("结果map:{}" + notifyMap);
			if (notifyMap != null) {
				String returnCode = notifyMap.get("return_code");
				if (returnCode != null && WXConfigConstants.SUCCESS.equals(returnCode)){
					String resultCode = notifyMap.get("result_code");
					//签约失败
					if (resultCode != null && WXConfigConstants.FAIL.equals(resultCode)){
						log.info("签约失败notifyMap={}",notifyMap);
						wxAutoRenewaApplicationAgreementFacade.updateBychangeTypeAndCode(changeType, contractCode);
						WxRenewaResultRecord wxRenewaResultRecord = new WxRenewaResultRecord();
						wxRenewaResultRecord.setContractCode(contractCode);
						wxRenewaResultRecord.setContractState(1);
						wxRenewaResultRecordFacade.save(wxRenewaResultRecord);
						return WXConfigConstants.NOTIFY_STR_SUCCESS;
					}
				}

				if (wxPay == null){
					wxPay = new WXPay(wxPayConfig);
				}
				// 校验验签
				if (wxPay.isPayResultNotifySignatureValid(notifyMap)) {
					WxRenewaResultRecord wxRenewaResultRecord = AntoRenewUtils.praseResultMap(notifyMap,changeType);
					if (wxRenewaResultRecord != null) {
						if(changeType == null){//异步通知，先查询是否已经拿到结果
							// 判断是否已经拿到结果了
							WxRenewaResultRecord record= wxRenewaResultRecordService.getByContractCodeChangeType(
									wxRenewaResultRecord.getContractCode(), wxRenewaResultRecord.getChangeType());
							if (record != null) {
								//已经处理过了，不再处理
								log.info("AutoRenewaFacade.parseResult already in DB,xmlStr={}", xmlStr);
								return WXConfigConstants.NOTIFY_STR_SUCCESS;
							}
						}
						//保存微信返回结果
						wxRenewaResultRecordFacade.save(wxRenewaResultRecord);
						// 处理业务
						doBusiness(wxRenewaResultRecord);
						return WXConfigConstants.NOTIFY_STR_SUCCESS;
					}else{//签约或解约失败，修改签约、解约状态
						log.info("wxRenewaResultRecord is null,update status,notifyMap={}",notifyMap);
						wxAutoRenewaApplicationAgreementFacade.updateBychangeTypeAndCode(changeType, contractCode);
					}
				}
			}
		} catch (Exception e) {
			log.error("wx autorenewa parseResult error,xmlStr={}", xmlStr, e);
		}
		return WXConfigConstants.NOTIFY_STR_FAIL;
	}

	/**
	 * 处理签约解约结果
	 *
	 * @param wxRenewaResultRecord
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doBusiness(WxRenewaResultRecord wxRenewaResultRecord) {

		if (wxRenewaResultRecord != null) {

			String changeType = wxRenewaResultRecord.getChangeType();
			if (StringUtils.isNotBlank(changeType)) {

				// 修改协议状态
				Long uid = wxAutoRenewaApplicationAgreementFacade.updateAgreementStatus(wxRenewaResultRecord);
				if (uid != null) {
//					String openid = wxRenewaResultRecord.getOpenid();
					// 签约
					if (WXConfigConstants.CHANGE_TYPE_ADD.equals(changeType)) {
						openRenewa(uid);
						//立即申请扣费
						log.info("发起扣费 uid:{}",uid);
						dedutionInfz.apply(uid);

						// 解约
					} else if (WXConfigConstants.CHANGE_TYPE_DELETE.equals(changeType)) {
						offRenewa(uid);
					}
				}
			}
		}
	}

	private void offRenewa(Long cuId) {
		log.info("解约 cuId:{}",cuId);
		AutoRenewa autoRenewa = getOne(cuId);
		Date now = new Date();
		if (autoRenewa == null) {
			autoRenewa = new AutoRenewa();
			autoRenewa.setCuId(cuId);
			autoRenewa.setCreateDate(now);
		}
		autoRenewa.setUpdateDate(now);
		autoRenewa.setStatus(RenewaStatusEnum.OFF.getStatus());
		Long id = autoRenewa.getId();
		if (id == null){
			autoRenewaService.save(autoRenewa);
		}else {
			autoRenewaService.updateById(autoRenewa);
		}

		//修改会员类型为普通会员
//		vipRecordFacade.updateType(cuId, VipTypeEnum.ORDINARY_VIP.getType());
	}

	private void openRenewa(Long uid) {
		AutoRenewa autoRenewa = getOne(uid);
		Date now = new Date();
		if (autoRenewa == null) {
			autoRenewa = new AutoRenewa();
			autoRenewa.setCuId(uid);
			autoRenewa.setCreateDate(now);
		}
		autoRenewa.setStatus(RenewaStatusEnum.OPEN.getStatus());
		autoRenewa.setUpdateDate(now);
		Long id = autoRenewa.getId();
		if (id == null){
			autoRenewaService.save(autoRenewa);
		}else {
			autoRenewaService.updateById(autoRenewa);
		}
	}



	/**
	 * 解约申请
	 *
	 * @param uid
	 * @return
	 */
	public ResultDto rescission(Long uid) {
		// 检查是否有续约协议
		WxAutoRenewaApplicationAgreement agreement = wxAutoRenewaApplicationAgreementFacade.getRenewaAgreementByUid(uid);
		if (agreement == null) {
			return ResultDto.errorResult("没有自动续费协议");
		}

		Integer status = agreement.getStatus();
		if (status == null || !RenewaAgreementStatusEnum.APPLY_RETURN.getStatus().equals(status)) {
			return ResultDto.errorResult("没有需要关闭的续费协议");
		}

		// 申请解约
		Map<String, String> resutlMap = AntoRenewUtils.applyRescission(agreement.getContractId(),agreement.getContractCode());
		log.info("申请解约 参数：{}",resutlMap);
		return ResultDto.succesResult(resutlMap);
	}

	

	/**
	 * 续费详情
	 *
	 * @param uid
	 * @return
	 */
/*	public ResultDto renewaInfo(Long uid) {

		UVipGoods vipGoods = vipGoodsFacade.getRenewaVip();
		if (vipGoods == null) {
			return ResultDto.errorResult("没有VIP卡信息");
		}
		RenewaVipInfoDto renewaVipInfoDto = new RenewaVipInfoDto();

		// 金额
		Integer price = vipGoods.getPrice();
		if (price != null) {
			double amount = NumUtil.div(price, 100);
			renewaVipInfoDto.setAmount(amount);
		}

		// 扣费时间
		String expireDate = vipRecordFacade.vipExpireDate(uid);
		if (StringUtils.isNotBlank(expireDate)) {
			Date date = DateFormatUtil.parseShort(expireDate);
			expireDate = DateFormatUtil.format(date, DateFormatUtil.FORMAT_SHORT_CN);
			renewaVipInfoDto.setVipExpireDate(expireDate);
		}
		return ResultDto.succesResult(renewaVipInfoDto);
	}
	*/
	/**
	 * 获取委托协议和金额
	 * @param uid
	 * @return
	 */
	/*public ContractIdAndTotalFeeDto getContractIdAndTotalFee(Long uid) {
		//委托协议
		WxAutoRenewaApplicationAgreement agreement = wxAutoRenewaApplicationAgreementFacade.getRenewaAgreementByUid(uid);
		if (agreement == null){
			return null;
		}
		String contractId = agreement.getContractId();

		//金额
		UVipGoods renewaVip = vipGoodsFacade.getRenewaVip();
		if (renewaVip == null){
			return null;
		}

		Integer vipPrice = renewaVip.getPrice();

		if (vipPrice == null || 0 > vipPrice){
			return null;
		}
		ContractIdAndTotalFeeDto dto = new ContractIdAndTotalFeeDto();
		dto.setContractId(contractId);
		dto.setPrice(vipPrice);
		dto.setVipCardId(renewaVip.getId());

		return dto;
	}*/
}
