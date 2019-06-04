package com.only.tech.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/28
 */
@Getter
@AllArgsConstructor
public enum ContentImportStatusEnum {

    UNIMPORT(0,"未导入"),
    IMPORTED(1,"已导入");

    private Integer status;

    private String name;
}
