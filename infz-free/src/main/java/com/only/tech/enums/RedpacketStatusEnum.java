package com.only.tech.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/31
 */
@Getter
@AllArgsConstructor
public enum  RedpacketStatusEnum {

    SENDING("SENDING","发放中"),
    SENT("SENT","已发放待领取"),
    FAILED("FAILED","发放失败"),
    RECEIVED("RECEIVED","已领取"),
    RFUND_ING("RFUND_ING","退款中"),
    REFUND("REFUND","已退款"),
    ;

    private String status;
    private String des;
}
