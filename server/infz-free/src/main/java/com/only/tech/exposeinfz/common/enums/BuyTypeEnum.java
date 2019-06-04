package com.only.tech.exposeinfz.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 购买类型
 * @author ZHI ZUN BAO
 * @since 2018/10/27
 */
@AllArgsConstructor
@Getter
public enum BuyTypeEnum {

    BOOK(1,"整书"),
    CHAPTER_PACK(2,"章节包"),
    CHAPTER(3,"章节");

    private int code;

    private String desc;
}
