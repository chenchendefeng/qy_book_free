package com.only.tech.payment.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/20
 */
@Getter
@AllArgsConstructor
public enum WXTradeStateEnum {

    SUCCESS("SUCCESS","支付成功"),

    REFUND("REFUND","转入退款"),

    NOTPAY("NOTPAY","未支付"),

    CLOSED("CLOSED","已关闭"),

    ACCEPT("ACCEPT","已接收，等待扣款"),

    PAY_FAIL("PAY_FAIL","支付失败");

    private String state;
    private String des;
}
