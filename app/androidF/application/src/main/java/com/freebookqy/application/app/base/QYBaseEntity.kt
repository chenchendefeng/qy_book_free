package com.freebookqy.application.app.base

import com.google.gson.annotations.SerializedName

/**
 * Created by leafye on 2019-05-13.
 */
open class QYBaseEntity<T>(

    @SerializedName("result")
    var result: String,
    @SerializedName("msg")
    var msg: String,
    @SerializedName("data")
    var data: T?,
    @SerializedName("otherData")
    var otherData: Any?
)