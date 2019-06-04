package com.wy.adbook.app.base

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019/4/29.
 */
open class BaseEntity<T> : Serializable {

    @SerializedName("result")
    var result: String = ""
    @SerializedName("msg")
    var msg: String = ""
    @SerializedName("data")
    var data: T? = null
    @SerializedName("otherData")
    var otherData: Any? = null

    fun isOk() = RESULT_OK == this.result

    companion object {

        const val RESULT_OK = "success"

    }

}