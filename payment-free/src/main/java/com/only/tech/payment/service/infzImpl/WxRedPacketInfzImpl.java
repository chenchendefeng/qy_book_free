package com.only.tech.payment.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.only.tech.entity.user.RedpacketCheckResult;
import com.only.tech.entity.user.RedpacketResult;
import com.only.tech.exposeinfz.payment.api.WxRedPacketInfz;
import com.only.tech.payment.service.handler.WxRedPacketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/24
 */
@Component
@Service(interfaceClass = WxRedPacketInfz.class)
public class WxRedPacketInfzImpl implements WxRedPacketInfz {

    @Autowired
    private WxRedPacketHandler wxRedPacketHandler;

    @Override
    public RedpacketResult sendRedPacket(String bindOpenid, String orderNo, Integer rmbAmount) {
        try {
            return wxRedPacketHandler.sendRedPacket(bindOpenid,orderNo,rmbAmount);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public RedpacketCheckResult sendCheck(String orderNo) throws Exception {
        return wxRedPacketHandler.sendCheck(orderNo);
    }
}
