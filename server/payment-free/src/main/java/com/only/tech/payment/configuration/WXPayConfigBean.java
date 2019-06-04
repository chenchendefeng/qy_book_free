package com.only.tech.payment.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class WXPayConfigBean {


    /**
     * 服务域名
     */
    @Value("${wxpay.domain-url}")
    private String domainUrl;

    /**
     * 回调地址
     */
    @Value("${wxpay.notify-url}")
    private String notifyUrl;

    /**
     * 订单失效时间
     */
    @Value("${wxpay.expire-minute}")
    private int expireMinute;
    /**
     * 是否沙箱测试
     */
    @Value("${wxpay.sandbox}")
    private boolean sandbox;
}
