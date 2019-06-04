package com.only.tech.user.service.facade;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.entity.user.WxAutoRenewaApplicationAgreement;
import com.only.tech.entity.user.WxRenewaResultRecord;
import com.only.tech.user.common.constant.WXConfigConstants;
import com.only.tech.user.common.enums.RenewaAgreementStatusEnum;
import com.only.tech.user.common.enums.RenewaStatusEnum;
import com.only.tech.user.service.biz.WxAutoRenewaApplicationAgreementService;
import com.only.tech.user.service.handler.AutoRenwaHandle;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/16
 */
@Slf4j
@Service
public class WxAutoRenewaApplicationAgreementFacade {

    @Autowired
    private WxAutoRenewaApplicationAgreementService wxAutoRenewaApplicationAgreementService;

    @Autowired
    private AutoRenwaHandle autoRenwaHandle;


    /**
     * 未请求的协议
     * @param cuId
     * @return
     */
    public WxAutoRenewaApplicationAgreement getUnApplyAgreementByCuid(Long cuId) {
        Wrapper qw = new QueryWrapper<WxAutoRenewaApplicationAgreement>().eq("cuId",cuId).eq("status", RenewaAgreementStatusEnum.UN_APPLY.getStatus());
        return wxAutoRenewaApplicationAgreementService.getOne(qw);
    }


    public boolean save(WxAutoRenewaApplicationAgreement agreement) {
        return wxAutoRenewaApplicationAgreementService.save(agreement);
    }


    /**
     * 根据微信返回结果处理协议
     * @param wxRenewaResultRecord
     * @return uid
     */
    public Long updateAgreementStatus(WxRenewaResultRecord wxRenewaResultRecord) {
        if (wxRenewaResultRecord == null){
            return null;
        }

        String changeType = wxRenewaResultRecord.getChangeType();
        if (StringUtils.isNotBlank(changeType)){
            String contractCode = wxRenewaResultRecord.getContractCode();
            WxAutoRenewaApplicationAgreement agreement = getByContractCode(contractCode);
            if (agreement == null){
                return null;
            }
            if (WXConfigConstants.CHANGE_TYPE_ADD.equals(changeType)){
                //签约
                agreement.setContractId(wxRenewaResultRecord.getContractId());
                agreement.setStatus(RenewaAgreementStatusEnum.APPLY_RETURN.getStatus());
                agreement.setRenewaStatus(RenewaStatusEnum.OPEN.getStatus());

            }else if (WXConfigConstants.CHANGE_TYPE_DELETE.equals(changeType)){
                //解约
                agreement.setStatus(RenewaAgreementStatusEnum.RESCIND_RETURN.getStatus());
                agreement.setRenewaStatus(RenewaStatusEnum.OFF.getStatus());
            }
            agreement.setUpdateDate(new Date());
            boolean update = wxAutoRenewaApplicationAgreementService.updateById(agreement);
            if (update){
                return agreement.getCuId();
            }
        }

        return null;
    }

    public WxAutoRenewaApplicationAgreement getByContractCode(String contractCode) {
        Wrapper qw = new QueryWrapper<WxAutoRenewaApplicationAgreement>().eq("contractCode",contractCode);
        return wxAutoRenewaApplicationAgreementService.getOne(qw);
    }

    public WxAutoRenewaApplicationAgreement getRenewaAgreementByUid(Long cuId) {
        Wrapper qw = new QueryWrapper<WxAutoRenewaApplicationAgreement>().eq("cuId",cuId).eq("renewaStatus", RenewaStatusEnum.OPEN.getStatus());
        return wxAutoRenewaApplicationAgreementService.getOne(qw);
    }

    public WxAutoRenewaApplicationAgreement getByUidAndContractCode(Long cuId, String contractCode) {
        Wrapper qw = new QueryWrapper<WxAutoRenewaApplicationAgreement>().eq("cuId",cuId).eq("contractCode",contractCode);
        return wxAutoRenewaApplicationAgreementService.getOne(qw);
    }

    public boolean haveApplyAgreement(Long cuId) {
        Wrapper qw = new QueryWrapper<WxAutoRenewaApplicationAgreement>().eq("cuId",cuId).eq("status", RenewaAgreementStatusEnum.APPLY.getStatus());
        WxAutoRenewaApplicationAgreement agreement = wxAutoRenewaApplicationAgreementService.getOne(qw);
        return agreement != null;
    }
    
	public void updateBychangeTypeAndCode(String changeType,String contractCode){
        if (StringUtils.isBlank(contractCode)){
            return;
        }
		Wrapper<WxAutoRenewaApplicationAgreement> qw = new QueryWrapper<WxAutoRenewaApplicationAgreement>().eq("contractCode",contractCode);
		WxAutoRenewaApplicationAgreement agreement = wxAutoRenewaApplicationAgreementService.getOne(qw);
		if(agreement!=null){
			if(WXConfigConstants.CHANGE_TYPE_ADD.equals(changeType)){
				agreement.setStatus(RenewaAgreementStatusEnum.APPLY_RETURN.getStatus());
			}else{
				agreement.setStatus(RenewaAgreementStatusEnum.RESCIND_RETURN.getStatus());
			}
		    wxAutoRenewaApplicationAgreementService.updateById(agreement);
		}
	}


    /**
     * 处理未完成的协议
     * @param cuId
     * @return
     */
    public List<Map<String,String>> doUnfinishedAgreement(Long cuId) {
        Wrapper qw = new QueryWrapper<WxAutoRenewaApplicationAgreement>().eq("cuId",cuId).eq("status", RenewaAgreementStatusEnum.APPLY.getStatus());
        List<WxAutoRenewaApplicationAgreement> agreementList = wxAutoRenewaApplicationAgreementService.list(qw);
        if (agreementList != null){
            List<Map<String,String>> mapList = new ArrayList<>();
            try {
                for (WxAutoRenewaApplicationAgreement agreement: agreementList) {
                    String contractCode = agreement.getContractCode();
                    String resultXml = autoRenwaHandle.queryContractResult(contractCode);
                    Map<String,String> map = new HashMap<>();
                    map.put("contractCode",contractCode);
                    map.put("resultXml",resultXml);
                    mapList.add(map);
                }
                return mapList;
            } catch (Exception e) {
                log.error("处理未完成的订单 错误：{}",e);
            }
        }
        return null;
    }
}
