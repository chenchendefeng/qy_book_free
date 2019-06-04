package com.freebookqy.application.mvp.model.event

import com.freebookqy.application.app.base.BaseEvent

/**
 * Created by leafye on 2019-05-13.
 */
class LoginEvent(key: Int, args: Int = 0, strArgs: String = "", obj: Any? = null) :
    BaseEvent(key, args, strArgs, obj) {

    companion object {
        const val EVENT_LOGIN_SUCCESS = 1
    }

}