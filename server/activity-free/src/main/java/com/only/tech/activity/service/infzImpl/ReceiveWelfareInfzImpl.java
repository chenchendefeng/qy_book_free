package com.only.tech.activity.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.activity.service.biz.ReceiveWelfareService;
import com.only.tech.entity.activity.ReceiveWelfare;
import com.only.tech.exposeinfz.activity.api.ReceiveWelfareInfz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/6/3
 */
@Component
@Service(interfaceClass = ReceiveWelfareInfz.class)
public class ReceiveWelfareInfzImpl implements ReceiveWelfareInfz {


    @Autowired
    private ReceiveWelfareService receiveWelfareService;

    @Override
    public boolean receive(ReceiveWelfare receiveWelfare) {
        if (receiveWelfare == null){
            return false;
        }
        String welfareType = receiveWelfare.getWelfareType();
        List<ReceiveWelfare> list = receiveWelfareService.getByCuidAndWefareTypeAndDate(receiveWelfare.getCuId(), welfareType, null);
        if (!list.isEmpty()) {
            return false;
        }

        return receiveWelfareService.save(receiveWelfare);
    }
}
