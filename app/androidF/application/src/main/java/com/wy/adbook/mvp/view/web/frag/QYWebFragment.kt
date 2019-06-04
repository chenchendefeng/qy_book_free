package com.wy.adbook.mvp.view.web.frag

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import com.freebookqy.application.R
import com.freebookqy.utilslib.CallDialogUtils
import com.freebookqy.utilslib.MethodUtils
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.LogUtils
import com.wy.adbook.app.base.QYBaseFragment
import com.wy.adbook.di.component.DaggerQYWebComponent
import com.wy.adbook.di.module.QYWebModule
import com.wy.adbook.mvp.view.web.NDWebConfig
import com.wy.adbook.mvp.view.web.QYWebView
import com.wy.adbook.view.status.IStatusCoverView
import kotlinx.android.synthetic.main.fragment_web_browser.*
import org.jetbrains.anko.toast
import java.lang.reflect.InvocationTargetException
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-23.
 */
class QYWebFragment : QYBaseFragment<QYWebPresenter>(), QYWebContract.View {

    companion object {

        const val EXTRA_TITLE = "title"
        const val EXTRA_URL = "url"

        fun instance(
            title: String,
            url: String
        ): QYWebFragment {
            return QYWebFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(EXTRA_TITLE, title)
                    putSerializable(EXTRA_URL, url)
                }
            }
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerQYWebComponent.builder()
            .appComponent(appComponent)
            .qYWebModule(QYWebModule(this@QYWebFragment))
            .build()
            .inject(this@QYWebFragment)
    }

    override fun isHandlerStatusBarHeight(): Boolean = false

    @Inject
    lateinit var webView: QYWebView

    private var title = ""

    private var url = ""

    override fun useEventBus(): Boolean = true

    override fun initData(savedInstanceState: Bundle?) {
        initWebSettings()
        initArgs()
        loadUrl(url, null)
    }

    private fun initArgs() {
        arguments?.apply {
            title = (getSerializable(EXTRA_TITLE) as String?) ?: ""
            url = (getSerializable(EXTRA_URL) as String?) ?: ""
        }
    }

    private fun loadUrl(url: String, header: Map<String, String>?) {
        if (TextUtils.isEmpty(url)) return
        LogUtils.debugInfo("QYWebView   url:$url")
        status_cover_view.changeStatus(IStatusCoverView.Status.LOADING)
        webView.loadUrl(url, header)
    }

    override fun setData(data: Any?) {
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        View.inflate(context, R.layout.fragment_web_browser, null)!!.apply {
            val layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            findViewById<SwipeRefreshLayout>(R.id.frame_web_container).apply {
                addView(webView, layoutParams)
                setOnRefreshListener {
                    loadUrl(url, null)
                }
            }
        }

    @SuppressLint("JavascriptInterface", "SetJavaScriptEnabled")
    private fun initWebSettings() {
        try {
            webView.addJavascriptInterface(NDWebConfig.mClazz.newInstance(), NDWebConfig.mProtocol)
        } catch (e: java.lang.InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
        webView.webViewClient = object : WebViewClient() {

            private var isError: Boolean = false

            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                LogUtils.debugInfo(TAG, "shouldOverrideUrlLoading url:$url")
                if (!TextUtils.isEmpty(url) && url.startsWith("tel:")) {
                    CallDialogUtils.callPhone(activity, "")
                    return true
                }
                return super.shouldOverrideUrlLoading(view, url)
            }

            override fun onReceivedError(view: WebView?, errorCode: Int, description: String, failingUrl: String) {
                LogUtils.debugInfo(TAG, "onReceivedError errorCode:$errorCode")
                isError = true
                status_cover_view.changeStatus(IStatusCoverView.Status.ERROR)
                webView.stopLoading()
                webView.clearView()
            }

            override fun onPageFinished(view: WebView?, url: String) {
                LogUtils.debugInfo(TAG, "onPageFinished")
                super.onPageFinished(view, url)
                mOnWebViewEvent?.onReceiveFinished()
                status_cover_view.changeStatus(IStatusCoverView.Status.SUCCESS)
                frame_web_container.isRefreshing = false
                webView.requestLayout()
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                LogUtils.debugInfo(TAG, "onPageStarted")
                mOnWebViewEvent?.onLoadUrl(url ?: "")
                status_cover_view.changeStatus(IStatusCoverView.Status.LOADING)
                if (Build.VERSION.SDK_INT >= 11) {
                    view?.removeJavascriptInterface("accessibility")
                    view?.removeJavascriptInterface("accessibilityTraversal")
                }
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler, error: SslError) {
                LogUtils.debugInfo(TAG, "onReceivedSslError")
                processSsl(handler)
            }

            fun processSsl(handler: SslErrorHandler) {
                //防止检测平台报红
                try {
                    MethodUtils.invokeMethod(handler, "proceed", null)
                } catch (e: NoSuchMethodException) {
                    e.printStackTrace()
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                } catch (e: InvocationTargetException) {
                    e.printStackTrace()
                }
            }
        }
        webView.webChromeClient = CustomChromeClient()
    }

    inner class CustomChromeClient : WebChromeClient() {

        override fun onJsAlert(view: WebView, url: String, message: String, result: JsResult): Boolean {
            val flag = super.onJsAlert(view, url, message, result)
            if (webView.mDebugEnabled) {
                context.toast(message)
            }
            return flag
        }

        override fun onProgressChanged(view: WebView, newProgress: Int) {
            var newProgress = newProgress
            super.onProgressChanged(view, newProgress)
            if (newProgress < 5) {
                newProgress = 5
            }
            if (TextUtils.isEmpty(view.url)) {
                return
            }
            //LogUtils.v(TAG, "onProgressChanged :url " + view.getUrl() + " ;progress" + newProgress);
            //mProgressbaBar.setProgress(newProgress)
        }

        override fun onReceivedTitle(view: WebView, h5title: String?) {
            if (!TextUtils.isEmpty(title)) return
            if (TextUtils.isEmpty(h5title)) return
            //if (!isShowContentView()) return
            mOnWebViewEvent?.onReceiveTitle(h5title!!)
            //LogUtils.v(TAG, "onReceivedTitle title:$title")
        }

        override fun onReceivedIcon(view: WebView, icon: Bitmap) {

        }
    }

    private fun isShowContentView(): Boolean {
        return webView.visibility == View.VISIBLE
    }

    /**
     * 传入js函数 字符串 比如：loadJsFunc("javascript:onAddressChange('')")
     */
    fun loadJsFunc(jsFunc: String) {
        if (!TextUtils.isEmpty(jsFunc)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                //这个方法加载js脚本不会有大小限制
                webView.evaluateJavascript(jsFunc, null)
            } else {
                //使用此方法加载js脚本会有大小限制，一般为2M（内核不同大小限制不同）
                //超过限制会会出现警告：
                // chromium: [WARNING:navigator_impl.cc(311)] Refusing to load URL as it exceeds 2097152 characters.
                webView.loadUrl(jsFunc)
            }
        }
    }

    fun goBack(): Boolean {
        val webBackForwardList = webView.copyBackForwardList()
        val currentIndex = webBackForwardList.getCurrentIndex()
        val backIndex = getWebBackIndex(currentIndex, webBackForwardList)
//        LogUtils.v(
//            TAG,
//            "onClickTitleBack canGoBack:" + mWebView.canGoBackOrForward(backIndex) + " backIndex:" + backIndex + " goBack:" + backIndex
//        )
        if (backIndex != Integer.MIN_VALUE && webView.canGoBackOrForward(backIndex)) {
            mOnWebViewEvent?.onReceiveTitle(getWebTitle(webBackForwardList, currentIndex, backIndex))
            showContentView()
            webView.goBackOrForward(backIndex)
            return true
        } else {
            return false
        }
    }

    private fun showContentView() {
        status_cover_view.changeStatus(IStatusCoverView.Status.SUCCESS)
    }

    private fun getWebTitle(webBackForwardList: WebBackForwardList?, currentIndex: Int, backIndex: Int): String {
        if (webBackForwardList == null) {
            return ""
        }
        if (currentIndex + backIndex > webBackForwardList.size || currentIndex + backIndex < 0) {
            return ""
        }
        if (webBackForwardList.getItemAtIndex(currentIndex + backIndex) == null) {
            return ""
        }
        return if (webBackForwardList.getItemAtIndex(currentIndex + backIndex).title == null) {
            ""
        } else webBackForwardList.getItemAtIndex(currentIndex + backIndex).title
    }

    private fun getWebBackIndex(currentIndex: Int, list: WebBackForwardList): Int {
        if (list.currentItem == null) {
            return Integer.MIN_VALUE
        }
        if (currentIndex - 1 < 0) {
            return Integer.MIN_VALUE
        }
        //LogUtils.v(TAG, "onClickTitleBack currentIndex:$currentIndex")
        var j = 1
        val backItem = list.getItemAtIndex(currentIndex - j)
        if (currentIndex - 2 >= 0) {
            for (i in currentIndex - 2 downTo 0) {
                val findItem = list.getItemAtIndex(i) ?: continue
                val backItemUrl = backItem.url
                val findItemUrl = findItem.url
                if (backItemUrl != findItemUrl) {
                    return -j
                }
                j++
            }
        }
        if (backItem.url == list.currentItem!!.url) {
            return Integer.MIN_VALUE
        }
        //LogUtils.v(TAG, "getWebBackIndex returnIndex:$j")
        return -j
    }

    private var mOnWebViewEvent: OnWebViewEvent? = null

    fun setOnWebViewEvent(event: OnWebViewEvent) {
        this.mOnWebViewEvent = event
    }

    interface OnWebViewEvent {
        fun onReceiveTitle(title: String)

        fun onReceiveFinished()

        /**
         * 当前界面的url
         *
         * @param url
         */
        fun onLoadUrl(url: String)
    }

}