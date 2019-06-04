package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.freebookqy.application.R
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.di.component.DaggerGenderComponent
import com.wy.adbook.di.module.GenderModule
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.contranct.GenderContract
import com.wy.adbook.mvp.presenter.GenderPresenter
import com.jaeger.library.StatusBarUtil
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.activity_gender_select.*

/**
 * Created by leafye on 2019/4/29.
 */
class GenderSelectActivity :
    QYBaseActivity<GenderPresenter>(),
    GenderContract.View {


    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, GenderSelectActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerGenderComponent.builder()
            .appComponent(appComponent)
            .genderModule(GenderModule(this@GenderSelectActivity))
            .build()
            .inject(this@GenderSelectActivity)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        setSwipeBackEnable(false)
        return R.layout.activity_gender_select
    }

    override fun initData(savedInstanceState: Bundle?) {
        StatusBarUtil.setLightMode(this@GenderSelectActivity)
        initListener()
    }

    private fun initListener() {
        startReadTv.onClick { mPresenter?.selectGender() }
        genderSelectRG.setOnCheckedChangeListener { _, _ ->
            startReadTv.visibility = View.VISIBLE
        }
        skip_btn.onClick { mPresenter?.skip() }
    }

    override fun getGender(): Int {
        return when {
            manRb.isChecked -> Constant.Gender.MALE
            womanRb.isChecked -> Constant.Gender.FEMALE
            else -> Constant.Gender.NO_GENDER
        }
    }
}