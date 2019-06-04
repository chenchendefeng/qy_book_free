package com.only.tech.user.common.utils;

import com.only.tech.user.common.enums.MessageSourceType;

public class EnumUtils {
    public static String getNameByKey(Object key, Class<? extends IEnum> clazz) {
        IEnum[] enums = clazz.getEnumConstants();
        for(IEnum e : enums) {
            if(e.getKey().equals(key)) {
                return e.getName().toString();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String desc = EnumUtils.getNameByKey(1, MessageSourceType.class);
        System.out.println(desc);
    }
}
