package com.only.tech.user.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/16
 */
@AllArgsConstructor
@Getter
public enum RenewaAgreementStatusEnum {

    UN_APPLY(0,"签约未请求"),
    APPLY(1,"签约已请求"),
    APPLY_RETURN(2,"签约已返回"),
    RESCIND(3,"解约已请求"),
    RESCIND_RETURN(4,"解约已返回"),
    ;

    private Integer status;
    private String des;

}
