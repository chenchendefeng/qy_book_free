package com.wy.adbook.view.status

/**
 * Created by leafye on 2019-05-23.
 */
interface IStatusCoverView {

    enum class Status {

        ERROR, LOADING, SUCCESS

    }

    interface StatusChangeListener {
        fun error()

        fun loading()

        fun success()
    }

    interface ReTryClickListener {
        fun reTry()
    }

    fun showError()

    fun showLoading()

    fun showSuccess()

    fun changeStatus(status: IStatusCoverView.Status)

}