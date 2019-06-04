package com.freebookqy.application.app.base

import android.content.Context
import com.jess.arms.mvp.IView

/**
 * Created by leafye on 2019/4/29.
 */
interface QYView : IView {

    fun getContext(): Context

    fun finish()

    fun showLoading(str: String)

    fun showError(str: String)

    fun showSuccess(success:String)

    override fun showMessage(msg: String)

    /**
     * 显示加载
     */
    override fun showLoading()

    /**
     * 隐藏加载
     */
    override fun hideLoading()
}