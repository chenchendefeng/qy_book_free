package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.freebookqy.application.R
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.di.component.DaggerRemoveAdSuccessComponent
import com.wy.adbook.di.module.RemoveAdSuccessModule
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.contranct.RemoveAdSuccessContract
import com.wy.adbook.mvp.presenter.RemoveAdSuccessPresenter
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.activity_remove_ad_success.*

/**
 * Created by leafye on 2019-05-27.
 */
class RemoveAdSuccessActivity : QYBaseActivity<RemoveAdSuccessPresenter>(), RemoveAdSuccessContract.View {

    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, RemoveAdSuccessActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerRemoveAdSuccessComponent.builder()
            .appComponent(appComponent)
            .removeAdSuccessModule(RemoveAdSuccessModule((this@RemoveAdSuccessActivity)))
            .build()
            .inject(this@RemoveAdSuccessActivity)
    }

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_remove_ad_success

    override fun initData(savedInstanceState: Bundle?) {
        remove_ad_complete_tv.onClick { finish() }
    }
}