package com.only.tech.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/26
 */
@Getter
@AllArgsConstructor
public enum  RedPackErrCodeEnum {

    NO_AUTH("NO_AUTH","微信账户异常"),
    SENDNUM_LIMIT("SENDNUM_LIMIT","领取红包个数超过限制"),
    ILLEGAL_APPID("ILLEGAL_APPID","公众号的appid错误"),
    MONEY_LIMIT("ILLEGAL_APPID","发送红包金额超出限制"),
    SEND_FAILED("SEND_FAILED","红包已经发放失败"),
    FATAL_ERROR("FATAL_ERROR","openid和原始单参数不一致"),
    CA_ERROR("CA_ERROR","商户API证书校验出错"),
    SIGN_ERROR("SIGN_ERROR","签名错误"),
    SYSTEMERROR("SYSTEMERROR","请求已受理，请稍后使用原单号查询发放结果"),
    XML_ERROR("XML_ERROR","xml参数格式错误"),
    FREQ_LIMIT("FREQ_LIMIT","超过频率限制,请稍后再试"),
    API_METHOD_CLOSED("API_METHOD_CLOSED","商户API发放方式处于关闭状态"),
    NOTENOUGH("NOTENOUGH","账户余额不足"),
    OPENID_ERROR("OPENID_ERROR","openid和appid不匹配"),
    MSGAPPID_ERROR("MSGAPPID_ERROR","触达消息给用户appid有误"),
    PROCESSING("PROCESSING","红包正在发放中"),
    PARAM_ERROR("PARAM_ERROR","参数错误"),
    ;

    private String code;
    private String msg;
}
