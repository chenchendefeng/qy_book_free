package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.style.ClickableSpan
import android.view.View
import com.freebookqy.application.R
import com.freebookqy.utilslib.SpanUtils
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.di.component.DaggerAboutUsComponent
import com.wy.adbook.di.module.AboutUsModule
import com.wy.adbook.mvp.contranct.AboutUsContract
import com.wy.adbook.mvp.presenter.AboutUsPresenter
import com.wy.adbook.mvp.view.web.act.WebActivity
import kotlinx.android.synthetic.main.activity_about_us.*

/**
 * Created by leafye on 2019-05-29.
 */
class AboutUsActivity : QYBaseActivity<AboutUsPresenter>(), AboutUsContract.View {

    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, AboutUsActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerAboutUsComponent.builder()
            .appComponent(appComponent)
            .aboutUsModule(AboutUsModule((this@AboutUsActivity)))
            .build()
            .inject(this@AboutUsActivity)
    }

    override fun getToolbar(): View? = title_bar_view

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_about_us

    override fun initData(savedInstanceState: Bundle?) {
        val create = SpanUtils()
            .append("软件服务协议及隐私政策")
            .setClickSpan(object : ClickableSpan() {
                override fun onClick(widget: View) {
                    WebActivity.startActivity(this@AboutUsActivity, "", "软件服务协议及隐私政策")
                }
            }).create()
        server_protocol_tv.text = create
    }
}