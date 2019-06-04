package com.freebookqy.application.app.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.View
import android.view.ViewGroup
import com.freebookqy.application.app.QYApplication
import com.freebookqy.utilslib.StatusBarUtils
import com.jess.arms.base.BaseFragment
import com.jess.arms.mvp.IPresenter

/**
 * Created by leafye on 2019/4/29.
 */
abstract class QYBaseFragment<P : IPresenter> : BaseFragment<P>() {

    private var mAct: FragmentActivity? = null

    /**
     * 此fragment是否需要友盟页面路径统计
     */
    protected val umengPageReport = true

    private var isFirst: Boolean = true



    override fun getContext(): Context {
        val context = super.getContext()
        if (context != null)
            return context
        return if (getFragmentActivity() != null) getFragmentActivity()!! else QYApplication.cxt()
    }

    protected fun getFragmentActivity(): FragmentActivity? {
        if (mAct == null) {
            mAct = activity
        }
        return mAct!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mAct = activity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isHandlerStatusBarHeight() && view is ViewGroup) {
            val statusBarHeight = StatusBarUtils.getStatusBarOffsetPx(context)
            view.setPadding(view.paddingLeft, statusBarHeight, view.paddingRight, view.paddingBottom)
        }
    }

    override fun onPause() {
        super.onPause()
        onVisibilityChange(false)
    }

    override fun onResume() {
        super.onResume()
        if (userVisibleHint) {
            onVisibilityChange(true)
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        getUserVisibleHint()
        if (isResumed) {
            onVisibilityChange(isVisibleToUser)
        }
    }

    /**
     * fragment显示发生变化（切换/跳转/返回）时的回调
     * @param visible 对用户可见或不可见
     */
    private fun onVisibilityChange(visible: Boolean) {
        if (umengPageReport) {
            if (visible) {
                if (isFirst) {
                    startInitView()
                    loadData()
                    isFirst = false
                } else {
                    onFragmentResume()
                }
            } else {
                onFragmentPause()
            }
        }
    }

    protected open fun startInitView() {

    }

    protected open fun loadData() {

    }

    protected open fun onFragmentResume() {

    }

    protected open fun onFragmentPause() {

    }




    open fun isHandlerStatusBarHeight(): Boolean {
        return true
    }

    fun finish() {
        getFragmentActivity()?.finish()
    }

    /**
     * 显示加载
     */
    fun showLoading() {
        getFragmentActivity()?.apply {
            if (this is QYBaseActivity<*>) {
                this.showLoading()
            }
        }
    }

    fun showLoading(str: String) {
        getFragmentActivity()?.apply {
            if (this is QYBaseActivity<*>) {
                this.showLoading(str)
            }
        }
    }

    /**
     * 隐藏加载
     */
    fun hideLoading() {
        getFragmentActivity()?.apply {
            if (this is QYBaseActivity<*>) {
                this.hideLoading()
            }
        }
    }

    fun showError(str:String){
        getFragmentActivity()?.apply {
            if (this is QYBaseActivity<*>) {
                this.showError(str)
            }
        }
    }

    fun showMessage(message: String) {
        getFragmentActivity()?.apply {
            if (this is QYBaseActivity<*>) {
                this.showMessage(message)
            }
        }
    }

    fun showSuccess(success:String){
        getFragmentActivity()?.apply {
            if (this is QYBaseActivity<*>) {
                this.showSuccess(success)
            }
        }
    }

}