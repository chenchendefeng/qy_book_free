package com.only.tech.user.common.constant;

/**
 * 微信配置常量
 * @author ZHI ZUN BAO
 * @since 2019/1/16
 */
public interface WXConfigConstants {


    /**
     * 自动续费解约URL
     */
    String RESCISSION_URL = "https://api.mch.weixin.qq.com/papay/deletecontract";

    /**
     * 签约/解约  回调路径
     */
//    String RENEWA_NOTIFY_URL = "http://www.qybook.net/user/auto-renewa/notify/applyRenewa";
    String RENEWA_NOTIFY_URL = "/auto-renewa/notify/applyRenewa";

    /**
     * 签约/解约 回调路径  ANDROID
     */
    String RENEWA_NOTIFY_URL_ANDROID = "http%3A%2F%2Fwww.qybook.net%2Fuser%2Fauto-renewa%2Fnotify%2FapplyRenewa";

    /**
     * 签约/解约 回调路径  IOS
     */
    String RENEWA_NOTIFY_URL_IOS = "http%253A%252F%252Fwww.qybook.net%252Fuser%252Fauto-renewa%252Fnotify%252FapplyRenewa";

    /**
     * 版本号
     */
    String VERSION = "1.0";

    /**
     * 续费签约 -- 非必填
     * 3表示返回app, 不填则不返回 注：签约参数appid必须为发起签约的app所有，且在微信开放平台注册过。
     */
    Integer RETURN_APP = 3;

    /**
     * api key
     */
    String API_KEY = "mukitechmukitechmukitechmukitech";

    /**
     * 返回成功
     */
    String NOTIFY_STR_SUCCESS = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";

    /**
     * 返回失败
     */
    String NOTIFY_STR_FAIL = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";

    /**
     * 成功
     */
    String SUCCESS = "SUCCESS";
    /**
     * 失败
     */
    String FAIL = "FAIL";

    /**
     * --签约
     */
    String CHANGE_TYPE_ADD = "ADD";
    /**
     * --解约
     */
    String CHANGE_TYPE_DELETE = "DELETE";

    /**
     * 用户申请解约
     */
    String RESCISSION_REMARK = "用户申请解约";
}
