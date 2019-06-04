package com.only.tech.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/14
 */
@Getter
@AllArgsConstructor
public enum InvitationTaskEnum {

    NOT_START(0,"未达成"),
    FINISH_ONE(1,"达成1"),
    FINISH_TWO(2,"未达成2"),
    FINISH_THREE(3,"未达成3");

    private Integer code;
    private String name;

}
