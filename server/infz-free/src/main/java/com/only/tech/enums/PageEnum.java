package com.only.tech.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/29
 */
@Getter
@AllArgsConstructor
public enum PageEnum {

    BOOK_SHELF_PAGE("bookShelf","书架"),
    BOOK_STORE_PAGE("bookStore","书库"),
    CHOICE_PAGE("choice","精选"),
    READER_GUIDING_PAGE("readerGuiding","导读"),
    PERSONAL_CENTER_PAGE("personalCenter","个人中心"),
    ;

    private String page;

    private String name;
}
