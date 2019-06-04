package com.wy.adbook.mvp.model.event

import com.wy.adbook.app.base.BaseEvent

/**
 * Created by leafye on 2019-05-24.
 */
class SignEvent(
    key: Int,
    args: Int = 0,
    strArgs: String = "",
    obj: Any? = null
) :
    BaseEvent(key, args, strArgs, obj) {

    companion object {

        const val EVENT_SIGN_SUCCESS = 0
    }
}