package com.only.tech.admin.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/2/1
 */
@Getter
@AllArgsConstructor
public enum CustomerManageTypeEnum {

    UPDATE_BOOK_MONEY(1,"用户充值"),
    MSG_PUSH(2,"推送消息"),
    CUSTOMER_MANAGE(3,"用户管理"),
    BOOK_MANAGE(4,"书籍管理"),
    ;
    private Integer type;
    private String des;
}
