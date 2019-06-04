package com.only.tech.activity.common.enums;

import com.only.tech.activity.common.constants.ConstantsActivity;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/9
 */
@Getter
@AllArgsConstructor
public enum  AttendanceTypeEnum {

    FIRST_SIGN(ConstantsActivity.FIRST_SIGN,"首签", ConstantsActivity.FIRST_SIGN_CODE),
    DAILY_SIGN(ConstantsActivity.DAILY_SIGN,"签到",ConstantsActivity.DAILY_SIGN_CODE),
    COMPENSATE_SIGN(ConstantsActivity.COMPENSATE_SIGN,"补签",ConstantsActivity.COMPENSATE_SIGN_CODE),
            ;

    private String type;
    private String name;
    private Integer code;

}
