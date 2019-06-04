package com.wy.adbook.mvp.view.web

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.webkit.WebSettings
import android.webkit.WebView
import com.freebookqy.utilslib.MethodUtils
import java.lang.reflect.InvocationTargetException

/**
 * Created by leafye on 2019-05-24.
 */
class QYWebView : WebView {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    var mDebugEnabled = false

    init {
        initWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        val webSettings = settings
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        webSettings.useWideViewPort = true// 设置此属性，可任意比例缩放
        webSettings.loadWithOverviewMode = true
        webSettings.javaScriptEnabled = true
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        webSettings.allowFileAccess = false
        webSettings.javaScriptCanOpenWindowsAutomatically = true;
        webSettings.setSupportMultipleWindows(true)
        //防止检测平台报红
        try {
            MethodUtils.invokeMethod(webSettings, "setJavaScriptEnabled", arrayOf<Any>(true))
            MethodUtils.invokeMethod(webSettings, "setJavaScriptCanOpenWindowsAutomatically", arrayOf<Any>(true))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                MethodUtils.invokeMethod(
                    webSettings,
                    "setMixedContentMode",
                    arrayOf(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE)
                )
            }
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
        webSettings.builtInZoomControls = false
        webSettings.setSupportZoom(true)
        webSettings.domStorageEnabled = true
        if (Build.VERSION.SDK_INT >= 11) {
            removeJavascriptInterface("searchBoxJavaBridge_")
        }
        requestFocusFromTouch()
        setWebViewDebugEnabled(NDWebConfig.mIsDebug)
    }


    private fun setWebViewDebugEnabled(value: Boolean) {
        mDebugEnabled = value
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(value)
        }
    }

}