package com.freebookqy.application.mvp.model.event

import com.freebookqy.application.app.base.BaseEvent

/**
 * Created by leafye on 2019-05-13.
 */

class BookEvent(
    key: Int,
    args: Int = 0,
    strArgs: String = "",
    obj: Any? = null
) : BaseEvent(key, args, strArgs, obj) {
    companion object {
        const val PUT_ON_BOOK_SUCCESS = 1
    }

}