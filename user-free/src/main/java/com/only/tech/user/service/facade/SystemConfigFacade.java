package com.only.tech.user.service.facade;

import com.only.tech.constant.Constants;
import com.only.tech.entity.user.SystemConfig;
import com.only.tech.user.service.biz.SystemConfigService;
import ooh.chaos.util.NumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/30
 */
@Service
public class SystemConfigFacade {

    @Autowired
    private SystemConfigService systemConfigService;


    /**
     * 金豆转换成功人民币
     *  单位 分
     * @param num
     * @return
     */
    public Double goldToRmbCents(Long num){
        if (num.equals(0)){
            return 0D;
        }
        SystemConfig config = systemConfigService.getBype(Constants.EXCHANGE_RATIO);
        if (config == null){
            return null;
        }
        Integer rmb = config.getNumber1();//单位分
        Integer gold = config.getNumber2();
        double ratio = NumUtil.div(gold,rmb);
        if (ratio <= 0){
            return null;
        }

        Double amount = NumUtil.div(num,ratio);
        return amount;
    }


    /**
     * 金豆转换成功人民币
     *  单位 元
     * @param num
     * @return
     */
    public Double goldToRmbYuan(Long num){
        Double rmbCents = goldToRmbCents(num);
        if (rmbCents == null){
            return null;
        }
        Double amount = NumUtil.div(rmbCents,100);
        return amount;
    }



}
