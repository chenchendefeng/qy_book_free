package com.only.tech.user.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/17
 */
@AllArgsConstructor
@Getter
public enum RenewaStatusEnum {

    OFF(0,"未续费"),
    OPEN(1,"已续费");

    private Integer status;
    private String des;
}
