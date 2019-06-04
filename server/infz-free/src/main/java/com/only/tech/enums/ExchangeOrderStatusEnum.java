package com.only.tech.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/23
 */
@Getter
@AllArgsConstructor
public enum ExchangeOrderStatusEnum {

    AUDITING(0,"审核中"),
    AUDIT_SUCCESS(1,"审核成功"),
    AUDIT_FAIL(2,"审核失败"),
    WX_PROCESSING(3,"正在发送"),
    SEND_REDPACKET_SUCCESS(4,"红包发送成功"),
    SEND_REDPACKET_FAIL(5,"红包发送失败"),
    ;

    private Integer status;
    private String name;
}
