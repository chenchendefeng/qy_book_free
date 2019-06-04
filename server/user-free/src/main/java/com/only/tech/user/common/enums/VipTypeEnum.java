package com.only.tech.user.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/24
 */
@Getter
@AllArgsConstructor
public enum VipTypeEnum {

    ORDINARY_VIP(1,"普通VIP"),
    MONTHLY_VIP(2,"包月VIP"),
    VISITOR(3,"包月VIP");

    private Integer type;
    private String des;
}
