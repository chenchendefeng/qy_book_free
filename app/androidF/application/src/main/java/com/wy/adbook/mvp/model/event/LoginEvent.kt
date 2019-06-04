package com.wy.adbook.mvp.model.event

import com.wy.adbook.app.base.BaseEvent

/**
 * Created by leafye on 2019-05-13.
 */
class LoginEvent(key: Int, args: Int = 0, strArgs: String = "", obj: Any? = null) :
    BaseEvent(key, args, strArgs, obj) {

    companion object {
        /**
         * 登录成功
         */
        const val EVENT_LOGIN_SUCCESS = 1
        /**
         * 退出登录成功
         */
        const val EVENT_LOGOUT_SUCCESS = 2
    }

}