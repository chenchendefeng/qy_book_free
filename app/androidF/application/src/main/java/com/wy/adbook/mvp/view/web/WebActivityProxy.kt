package com.wy.adbook.mvp.view.web

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.jess.arms.utils.LogUtils
import com.wy.adbook.app.manager.ADManager
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.mvp.view.web.act.WebActivity
import com.wy.adbook.mvp.view.web.bean.WebViewMessageEvent
import com.wy.adbook.mvp.view.web.callback.QYJavaCallJs
import com.wy.adbook.mvp.view.web.callback.QYJsCallJava
import org.simple.eventbus.EventBus
import org.simple.eventbus.Subscriber
import org.simple.eventbus.ThreadMode

/**
 * Created by leafye on 2019-05-23.
 */
class WebActivityProxy(
    private val mWebActivity: WebActivity
) {
    init {
        EventBus.getDefault().register(this)
    }

    fun release() {
        EventBus.getDefault().unregister(this)
    }

    @Subscriber(mode = ThreadMode.MAIN)
    fun WebViewResponseEvent(response: WebViewMessageEvent.WebViewResponseEvent) {
        LogUtils.debugInfo("WebViewResponseEvent:$response")
        mWebActivity.webFragment.loadJsFunc(response.value)
    }

    @Subscriber(mode = ThreadMode.MAIN)
    fun jsCallJavaEvent(event: WebViewMessageEvent.JSCallJavaEvent) {
        when (event.value) {
            QYJsCallJava.VIEW_VIDEO -> {
                ADManager.watchingVideo(mWebActivity, object : ADManager.QYRewardVideoAdListener {
                    override fun onVideoAdClose() {
                        QYJavaCallJs.viewVideo()
                    }

                    override fun onVideoComplete() {

                    }
                })
            }
        }
    }

    /**
     * 这里加载js代码到h5中 主要用于初始化h5中的方法
     */
    fun loadJsToH5() {
        QYJavaCallJs.getUserInfo(QYAccount.getUserInfo())
        QYJavaCallJs.viewVideo()
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode != Activity.RESULT_OK) {
            return
        }
    }

    fun onSaveInstanceState(outState: Bundle) {

    }
}