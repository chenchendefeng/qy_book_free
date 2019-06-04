package com.freebookqy.application.view.readview

import android.view.ViewParent

/**
 * Created by leafye on 2019-05-13.
 */
interface IPageView {
    fun setPageMode(pageMode: Int)
    fun setBgColor(color: Int)

    fun drawCurPage()

    fun refreshPage()

    fun drawNextPage()

    fun invalidate()

    fun canReadable(enable: Boolean)

    fun getParent(): ViewParent?
}