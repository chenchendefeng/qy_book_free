package com.only.tech.exposeinfz.payment.api;

import com.only.tech.entity.user.RedpacketCheckResult;
import com.only.tech.entity.user.RedpacketResult;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/24
 */
public interface WxRedPacketInfz {
    RedpacketResult sendRedPacket(String bindOpenid, String orderNo, Integer rmbAmount);

    RedpacketCheckResult sendCheck(String orderNo) throws Exception;
}
