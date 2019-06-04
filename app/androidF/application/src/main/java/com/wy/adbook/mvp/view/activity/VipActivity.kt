package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.freebookqy.application.R
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.di.component.DaggerVipComponent
import com.wy.adbook.di.module.VipModule
import com.wy.adbook.ext.loadImageCircle
import com.wy.adbook.mvp.contranct.VipContract
import com.wy.adbook.mvp.presenter.VipPresenter
import kotlinx.android.synthetic.main.activity_vip.*

/**
 * Created by leafye on 2019-05-28.
 */
class VipActivity : QYBaseActivity<VipPresenter>(), VipContract.View {

    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, VipActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerVipComponent.builder()
            .appComponent(appComponent)
            .vipModule(VipModule((this@VipActivity)))
            .build()
            .inject(this@VipActivity)
    }

    override fun getToolbar(): View? = title_bar_view

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_vip

    override fun initData(savedInstanceState: Bundle?) {
        initHeader()
    }

    private fun initHeader() {
        user_name_tv.text = QYAccount.getUserInfo().nickName
        val vip = QYAccount.isVip()
        vip_bg.isSelected = vip
        vip_iv.isSelected = vip
        if (vip) {
            vip_status_tv.text = "已开通，${QYAccount.getUserInfo().vipEndDate}到期"
        } else {
            vip_status_tv.text = "未开通免广告会员"
        }
        val gender = QYAccount.getGender()
        val iconGender = if (gender == Constant.Gender.MALE) {
            R.mipmap.gender_select_man_no_selected
        } else {
            R.mipmap.gender_select_woman_no_selected
        }
        user_header_iv.loadImageCircle(QYAccount.getUserInfo().avatar, iconGender)
    }
}