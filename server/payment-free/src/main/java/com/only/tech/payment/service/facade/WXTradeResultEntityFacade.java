package com.only.tech.payment.service.facade;

import com.only.tech.entity.payment.WXTradeResultEntity;
import com.only.tech.payment.service.biz.WXTradeResultService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Map;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/20
 */
@Slf4j
@Service
public class WXTradeResultEntityFacade {

    @Autowired
    private WXTradeResultService wxTradeResultService;

    public WXTradeResultEntity saveRecord(Map<String, String> map) {
        String outTradeNo = map.get("out_trade_no");
        WXTradeResultEntity resultEntity = null;
        Date now = new Date();
        if (StringUtils.isNotBlank(outTradeNo)){
            resultEntity = wxTradeResultService.findByOutTradeNo(outTradeNo);
        }
        if (resultEntity == null){
            resultEntity = new WXTradeResultEntity();
            resultEntity.setCreateDate(now);
        }
        resultEntity.setUpdateDate(now);
        resultEntity.setReturnCode(map.get("return_code"));
        resultEntity.setReturnMsg(map.get("return_msg"));
        resultEntity.setAppid(map.get("appid"));
        resultEntity.setMchId(map.get("mch_id"));
        resultEntity.setResultCode(map.get("result_code"));
        resultEntity.setErrCode(map.get("err_code"));
        resultEntity.setErrCodeDes(map.get("err_code_des"));
        resultEntity.setOpenid(map.get("openid"));
        resultEntity.setTradeState(map.get("trade_state"));
        resultEntity.setBankType(map.get("bank_type"));
        String cashFee = map.get("cash_fee");
        if (StringUtils.isNotBlank(cashFee)){
            resultEntity.setTotalFee(Integer.valueOf(cashFee));
        }
        resultEntity.setTransactionId(map.get("transaction_id"));
        resultEntity.setOutTradeNo(map.get("out_trade_no"));
        resultEntity.setAttach(map.get("attach"));
        resultEntity.setTimeEnd(map.get("time_end"));
        resultEntity.setTradeStateDesc(map.get("trade_state_desc"));
        resultEntity.setContractId(map.get("contract_id"));
        String resultType = map.get("result_type");
        if (StringUtils.isNotBlank(resultType)){
            resultEntity.setResultType(Integer.parseInt(resultType));
        }

        wxTradeResultService.saveOrUpdate(resultEntity);

        return resultEntity;
    }

    public WXTradeResultEntity getByOrderNo(String orderNo) {
       return wxTradeResultService.findByOutTradeNo(orderNo);
    }
}
