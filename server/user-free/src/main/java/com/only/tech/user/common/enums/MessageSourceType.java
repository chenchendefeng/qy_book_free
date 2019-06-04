package com.only.tech.user.common.enums;

import com.only.tech.user.common.utils.IEnum;

public enum MessageSourceType implements IEnum {
    SYSTEM(1, "阅读小助手"),
    USER(2, "用户消息"),
    ;

    MessageSourceType(Integer key, String name) {
        this.key = key;
        this.name = name;
    }

    private Integer key;

    private String name;

    public Integer getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}
