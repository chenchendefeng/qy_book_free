package com.wy.adbook.view.status

import android.content.Context
import android.support.annotation.LayoutRes
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.freebookqy.application.R
import com.jess.arms.utils.LogUtils
import com.wy.adbook.ext.onClick

/**
 * Created by leafye on 2019-05-22.
 */
class StatusCoverView : FrameLayout, IStatusCoverView {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        var loadingId = 0
        var errorId: Int = DEF_ERROR
        attrs?.let {
            val attributes = context.obtainStyledAttributes(attrs, R.styleable.StatusCoverView)
            loadingId = attributes.getResourceId(R.styleable.StatusCoverView_loadingView, 0)
            errorId = attributes.getResourceId(R.styleable.StatusCoverView_errorView, DEF_ERROR)
            attributes.recycle()
        }
        initErrorView(errorId)
        initLoadingView(loadingId)
        changeToLoading()
    }

    companion object {

        private const val DEF_ERROR = R.layout.layout_net_error
        //private const val DEF_LOADING = R.layout.layout_loading
    }

    private var errorView: View? = null
    private var loadingView: View? = null
    private var listener: IStatusCoverView.StatusChangeListener? = null
    private var reTryL: IStatusCoverView.ReTryClickListener? = null

    private var coverStatus: IStatusCoverView.Status = IStatusCoverView.Status.LOADING

    private fun initLoadingView(loadingId: Int) {
        val loadingViewByFun = getInitLoadingView()
        if (loadingViewByFun == null) {
            val loadingViewId = getLoadingVIewId()
            if (loadingViewId != 0) {
                loadingView = View.inflate(context, loadingViewId, null)
            } else if (loadingId != 0) {
                loadingView = View.inflate(context, loadingId, null)
            }
        } else {
            loadingView = loadingViewByFun
        }
        loadingView?.let {
            val layoutParams =
                FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
            addView(it, layoutParams)
        }
    }

    private fun initErrorView(errorId: Int) {
        val errorViewByFun = getInitErrorView()
        if (errorViewByFun == null) {
            val errorViewId = getErrorViewId()
            if (errorViewId != 0) {
                errorView = View.inflate(context, errorViewId, null)
            } else if (errorId != 0) {
                errorView = View.inflate(context, errorId, null)
            }
        } else {
            errorView = errorViewByFun
        }
        errorView?.let {
            it.findViewById<TextView>(R.id.reload_btn)?.onClick {
                if (reTryL == null) {
                    LogUtils.debugInfo("请先设置 retry L")
                } else {
                    showLoading()
                    reTryL?.reTry()
                }
            }
            val layoutParams =
                FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
            addView(it, layoutParams)
        }
    }

    override fun changeStatus(status: IStatusCoverView.Status) {
        if (coverStatus == IStatusCoverView.Status.SUCCESS) return
        when (status) {
            IStatusCoverView.Status.ERROR -> showError()
            IStatusCoverView.Status.LOADING -> showLoading()
            IStatusCoverView.Status.SUCCESS -> showSuccess()
        }
    }

    override fun showError() {
        if (coverStatus == IStatusCoverView.Status.ERROR) return
        coverStatus = IStatusCoverView.Status.ERROR
        this.visibility = View.VISIBLE
        errorView?.visibility = View.VISIBLE
        loadingView?.visibility = View.GONE
        listener?.error()
    }

    override fun showLoading() {
        if (coverStatus == IStatusCoverView.Status.LOADING) return
        changeToLoading()
    }

    private fun changeToLoading() {
        coverStatus = IStatusCoverView.Status.LOADING
        this.visibility = View.VISIBLE
        errorView?.visibility = View.GONE
        loadingView?.visibility = View.VISIBLE
        listener?.error()
        listener?.loading()
    }

    override fun showSuccess() {
        if (coverStatus == IStatusCoverView.Status.SUCCESS) return
        coverStatus = IStatusCoverView.Status.SUCCESS
        this.visibility = View.GONE
        errorView?.visibility = View.GONE
        loadingView?.visibility = View.GONE
        listener?.success()
    }

    fun setStatusChangeListener(l: IStatusCoverView.StatusChangeListener) {
        this.listener = l
    }

    fun setReTryClickListener(l: IStatusCoverView.ReTryClickListener) {
        this.reTryL = l
    }

    fun getInitErrorView(): View? = null

    fun getInitLoadingView(): View? = null

    fun getRealErrorView(): View? = errorView

    fun getRealLoadingView(): View? = loadingView

    @LayoutRes
    fun getErrorViewId(): Int = 0

    @LayoutRes
    fun getLoadingVIewId(): Int = 0


}