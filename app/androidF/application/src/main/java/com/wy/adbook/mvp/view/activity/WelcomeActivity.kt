package com.wy.adbook.mvp.view.activity

import android.os.Bundle
import android.view.View
import com.freebookqy.application.R
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.app.manager.ADManager
import com.wy.adbook.di.component.DaggerWelcomeComponent
import com.wy.adbook.di.module.WelcomeModule
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.contranct.IWelcomeContract
import com.wy.adbook.mvp.presenter.WelcomePresenter
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.LogUtils
import com.qq.e.ads.splash.SplashADListener
import com.qq.e.comm.util.AdError
import kotlinx.android.synthetic.main.activity_welcome.*

/**
 * Created by leafye on 2019/4/29.
 */

class WelcomeActivity : QYBaseActivity<WelcomePresenter>(),
    IWelcomeContract.View {


    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerWelcomeComponent.builder()
            .appComponent(appComponent)
            .welcomeModule(WelcomeModule(this))
            .build()
            .inject(this)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        setSwipeBackEnable(false)
        return R.layout.activity_welcome
    }

    override fun initData(savedInstanceState: Bundle?) {
        initListener()
        mPresenter?.fetchData()
        mPresenter?.handlePermission()
    }

    private fun initListener() {
        skip_tv.onClick {
            LogUtils.warnInfo("welcome:点击跳过按钮")
            mPresenter?.checkAccoutStatusAndEnterMain()
        }
    }

    override fun showAd() {
        ADManager.displaySplashAD(
            this,
            ad_container,
            skip_tv,
            ADManager.POSID_START,
            object : SplashADListener {
                override fun onADExposure() {
                    LogUtils.warnInfo("welcome:onADExposure")
                }

                override fun onADDismissed() {
                    LogUtils.warnInfo("welcome:onADDismissed")
                    mPresenter?.checkAccoutStatusAndEnterMain()
                }

                override fun onADPresent() {
                    LogUtils.warnInfo("welcome:开屏广告准备完成")
                    ad_container.visibility = View.VISIBLE
                    welcome_iv.visibility = View.GONE
                    skip_tv.visibility = View.VISIBLE
                    mPresenter?.startCountDown(WelcomePresenter.DELAY_AD_TIME, true)
                }

                override fun onNoAD(p0: AdError?) {
                    LogUtils.warnInfo("welcome:没有获取到开屏广告")
                    ad_container.visibility = View.INVISIBLE
                    //进入主页
                    mPresenter?.startCountDown(WelcomePresenter.DELAY_NO_AD_TIME, false)
                }

                override fun onADClicked() {
                    LogUtils.warnInfo("welcome:开屏广告被点击")
                    mPresenter?.checkAccoutStatusAndEnterMain()
                }

                override fun onADTick(p0: Long) {
                    LogUtils.warnInfo("welcome:开屏广告onADTick:$p0")
                }
            },
            0
        )
    }

    override fun showSkipCount(currentCount: Long) {
//        skip_tv.visibility = View.VISIBLE
//        skip_tv.text = "跳过 $currentCount"
    }

    override fun showImg(fileUrl: String) {

    }

    override fun showGif(fileUrl: String) {

    }

    override fun showVideo(fileUrl: String) {

    }


}