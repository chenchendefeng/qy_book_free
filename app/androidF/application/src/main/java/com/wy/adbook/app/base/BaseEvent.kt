package com.wy.adbook.app.base

/**
 * Created by leafye on 2019-05-13.
 */
open class BaseEvent(
    val key: Int,
    val args: Int = -1,
    val strArgs: String = "",
    var obj: Any? = null
)