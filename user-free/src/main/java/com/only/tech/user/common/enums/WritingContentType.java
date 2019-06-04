package com.only.tech.user.common.enums;

import com.only.tech.user.common.utils.IEnum;

public enum WritingContentType implements IEnum {
    INVITE_MESSAGE(0, "短信邀请"),
    INVITE_OTHER(1, "其他邀请"),
    ;

    WritingContentType(Integer key, String name) {
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
