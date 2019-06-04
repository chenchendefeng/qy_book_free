package com.only.tech.enums;

import com.only.tech.constant.ClientTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 客户端类型
 * @author ZHI ZUN BAO
 * @since 2019/4/29
 */
@Getter
@AllArgsConstructor
public enum ClientTypeEnum {

    ANDROID(ClientTypeConstants.ANDROID,"安卓"),
    IOS(ClientTypeConstants.IOS,"IOS"),
    H5(ClientTypeConstants.H5,"H5"),
    PC(ClientTypeConstants.PC,"PC"),
    ;

    private String type;

    private String name;
}
