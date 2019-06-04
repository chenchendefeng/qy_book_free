package com.only.tech.user.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/17
 */
@AllArgsConstructor
@Getter
public enum WXBindStatusEnum {

    UNBIND(0,"未绑定"),
    BIND(1,"已绑定");

    private Integer status;
    private String des;
}
