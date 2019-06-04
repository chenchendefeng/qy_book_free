package com.wy.adbook.mvp.model.event

import com.wy.adbook.app.base.BaseEvent

/**
 * Created by leafye on 2019-05-23.
 */
class MainEvent(
    key: Int,
    args: Int = 0,
    strArgs: String = "",
    obj: Any? = null
) :
    BaseEvent(key, args, strArgs, obj) {

    companion object {
        const val EVENT_ENTER_BOOK_CITY = 1
        const val EVENT_ENTER_BOOKCASE = 2
        const val EVENT_ENTER_WELFARE = 3
    }
}