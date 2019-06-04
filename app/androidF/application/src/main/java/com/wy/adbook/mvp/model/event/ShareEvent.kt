package com.wy.adbook.mvp.model.event

import com.wy.adbook.app.base.BaseEvent

/**
 * Created by leafye on 2019-05-27.
 */
class ShareEvent : BaseEvent {
    constructor(key: Int, args: Int = 0, strArgs: String = "", obj: Any? = null) : super(key, args, strArgs, obj)

    companion object {
        const val EVENT_SHARE_SUCCESS = 100
    }

}