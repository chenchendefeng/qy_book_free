package com.only.tech.user.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/8
 */
@Getter
@AllArgsConstructor
public enum MobCheckStatusEnum {

    STATUS_200(200,"验证成功"),
    STATUS_405(405,"请求参数中的appkey为空"),
    STATUS_406(406,"非法的appkey"),
    STATUS_408(408,"提交的验证码格式错误"),
    STATUS_456(456,"国家代码或者手机号码为空"),
    STATUS_457(457,"国家代码不存在或手机号码格式错误"),
    STATUS_458(458,"appKey或手机号码在黑名单中"),
    STATUS_466(466,"验证码为空"),
    STATUS_467(467,"5分钟内此应用下此手机号验证超过3次，对应的验证码失效"),
    STATUS_468(468,"验证码错误"),
    STATUS_469(469,"没有开启发送WebApi的开关"),
    STATUS_471(471,"请求ip和绑定ip不符");

    private Integer status;
    private String msg;

}
