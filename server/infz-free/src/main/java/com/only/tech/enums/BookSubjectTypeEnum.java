package com.only.tech.enums;

import com.only.tech.constant.BookSubjectTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 书籍专题分类
 * @author shutong
 * @since 2019/4/28
 */
@Getter
@AllArgsConstructor
public enum BookSubjectTypeEnum {

    BOY(BookSubjectTypeConstants.BOY,"男生"),
    GIRL(BookSubjectTypeConstants.GIRL,"女生"),
    RECOMMEND(BookSubjectTypeConstants.RECOMMEND,"推荐");

    private String status;
    private String name;
}
