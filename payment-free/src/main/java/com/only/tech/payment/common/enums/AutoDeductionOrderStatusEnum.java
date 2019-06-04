package com.only.tech.payment.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/20
 */
@Getter
@AllArgsConstructor
public enum AutoDeductionOrderStatusEnum {

    UN_APPLY_WX(0,"请求微信"),
    APPLY_WX_SUCCESS(1,"请求微信成功,等待扣款"),
    APPLY_WX_FAIL(2,"请求微信失败"),
    DEDUCTION_SUCCESS(3,"扣款成功"),
    DEDUCTION_FAIL(4,"扣款失败")
    ;

    private Integer status;
    private String des;
}
