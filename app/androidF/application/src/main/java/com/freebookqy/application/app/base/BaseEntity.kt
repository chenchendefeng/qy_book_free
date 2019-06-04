package com.freebookqy.application.app.base

import com.google.gson.Gson
import java.io.Serializable
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by leafye on 2019/4/29.
 */
open class BaseEntity<T>(
    result: String,
    msg: String = "",
    data: T? = null,
    otherData: Any? = null
) : QYBaseEntity<T>(
    result,
    msg,
    data,
    otherData
), Serializable {
    companion object {

        const val RESULT_OK = "success"

    }

    val type: Type
        get() {
            val type = javaClass.genericSuperclass as ParameterizedType
            val actualTypeArguments = type.actualTypeArguments
            return actualTypeArguments[0]
        }

    fun parseJson(): T {
        return if (type is Collection<*>)
            Gson().fromJson<T>("[]", type)
        else
            Gson().fromJson<T>("{}", type)
    }

}