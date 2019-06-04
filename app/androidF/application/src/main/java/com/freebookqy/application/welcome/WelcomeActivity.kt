package com.freebookqy.application.welcome

import android.os.Bundle
import com.freebookqy.application.R
import com.freebookqy.application.di.component.DaggerWelcomeComponent
import com.freebookqy.application.di.module.WelcomeModule
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent

/**
 * Created by leafye on 2019/4/29.
 */

class WelcomeActivity : BaseActivity<WelcomePresenter>(),
    IWelcomeContract.View {
    override fun showMessage(message: String) {

    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerWelcomeComponent.builder()
            .appComponent(appComponent)
            .welcomeModule(WelcomeModule(this))
            .build()
            .inject(this)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_welcome
    }

    override fun initData(savedInstanceState: Bundle?) {

    }
}