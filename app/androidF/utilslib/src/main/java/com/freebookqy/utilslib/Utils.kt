package com.freebookqy.utilslib

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * Created by leafye on 2019/5/6.
 */
@SuppressLint("StaticFieldLeak")
object Utils {

    private var context: Application? = null

    val app: Context by lazy {
        context!!
    }

    fun initUtils(context: Application) {
        this.context = context
    }

}