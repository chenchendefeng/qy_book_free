package com.only.tech.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 币种枚举
 * @author ZHI ZUN BAO
 * @since 2019/5/5
 */
@Getter
@AllArgsConstructor
public enum CurrencyTypeEnum {

    RMB("rmb","人民币"),
    GOLD("gold","金豆");

    private String type;
    private String name;
}
