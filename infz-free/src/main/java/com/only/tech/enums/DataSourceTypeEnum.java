package com.only.tech.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 书籍数据源类型
 * @author ZHI ZUN BAO
 * @since 2019/4/28
 */
@Getter
@AllArgsConstructor
public enum DataSourceTypeEnum {

    TWO_CLOO("twoCloo","二层楼"),
    TADU("tadu","塔读");

    /**
     * 类型
     */
    private String type;

    /**
     * 名称
     */
    private String name;


}
