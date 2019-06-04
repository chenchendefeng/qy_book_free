package com.only.tech.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 书籍上架状态
 * @author ZHI ZUN BAO
 * @since 2019/4/28
 */
@Getter
@AllArgsConstructor
public enum BookShelfStatusEnum {

    UN_SHELF(0,"下架"),
    ON_SHELF(1,"上架");


    private Integer status;

    private String name;
}
