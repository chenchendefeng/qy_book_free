package com.wy.adbook.mvp.view.web.act

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.View
import com.freebookqy.application.R
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.LogUtils
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.di.component.DaggerWebComponent
import com.wy.adbook.di.module.WebModule
import com.wy.adbook.mvp.view.web.WebActivityProxy
import com.wy.adbook.mvp.view.web.bean.WebViewMessageEvent
import com.wy.adbook.mvp.view.web.frag.QYWebFragment
import kotlinx.android.synthetic.main.activity_web_fragment_container.*
import org.simple.eventbus.EventBus

/**
 * Created by leafye on 2019-05-23.
 */
open class WebActivity : QYBaseActivity<WebPresenter>(),
    WebContract.View {

    companion object {

        private val TAG = WebActivity::class.java.simpleName

        @JvmStatic
        fun startActivity(context: Context, url: String, title: String) {
            context.startActivity(Intent(context, WebActivity::class.java).apply {
                putExtra(QYWebFragment.EXTRA_TITLE, title)
                putExtra(QYWebFragment.EXTRA_URL, url)
            })
        }

        /**
         * 传入js函数 字符串 比如：loadJsFunc("javascript:onAddressChange('')")
         */
        @JvmStatic
        fun loadJsFunc(jsFunc: String) {
            LogUtils.debugInfo(TAG, "java call js: $jsFunc")
            val response = WebViewMessageEvent.WebViewResponseEvent()
            response.value = jsFunc
            EventBus.getDefault().post(response)
        }
    }

    override fun getToolbar(): View? = title_bar_view

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerWebComponent.builder()
            .appComponent(appComponent)
            .webModule(WebModule((this@WebActivity)))
            .build()
            .inject(this@WebActivity)
    }

    protected var mHandler = Handler()
    private var mHintCount = 0

    lateinit var webFragment: QYWebFragment
    private var mAppJSCall = false

    private var isLoadFinish: Boolean = false

    private var mWebActivityProxy: WebActivityProxy? = null

    val INTENT_JSCALL = "jscall"

    var title = ""
    var url = ""

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_web_fragment_container

    override fun initData(savedInstanceState: Bundle?) {
        intent?.apply {
            getSerializableExtra(QYWebFragment.EXTRA_TITLE)?.let { if (!TextUtils.isEmpty(it as String)) title = it }
            getSerializableExtra(QYWebFragment.EXTRA_URL)?.let { if (!TextUtils.isEmpty(it as String)) url = it }
        }
        mWebActivityProxy = WebActivityProxy(this)
        webFragment = QYWebFragment.instance(title, url).apply {
            setOnWebViewEvent(onWebViewEvent)
        }
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_web_container, webFragment)
            .commit()
        initTitle()
    }

    private fun initTitle() {
        title_bar_view.apply {
            setOnLeftButtonClickListener { back() }
            setTitleText(title)
        }
    }

    private var onWebViewEvent: QYWebFragment.OnWebViewEvent =
        object : QYWebFragment.OnWebViewEvent {

            override fun onReceiveTitle(title: String) {
                title_bar_view.setTitleText(title)
            }

            override fun onReceiveFinished() {
                isLoadFinish = true
                mWebActivityProxy?.loadJsToH5()
            }

            override fun onLoadUrl(url: String) {
                isLoadFinish = false
            }
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        mWebActivityProxy?.onActivityResult(requestCode, resultCode, data)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mWebActivityProxy?.onSaveInstanceState(outState)
    }

    protected fun back() {
        if (!webFragment.goBack()) {
            finish()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mWebActivityProxy?.release()
    }
}