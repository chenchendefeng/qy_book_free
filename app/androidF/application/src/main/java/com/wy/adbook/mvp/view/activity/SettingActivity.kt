package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.freebookqy.application.R
import com.freebookqy.viewlib.dialog.CommonDialog
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.di.component.DaggerSettingComponent
import com.wy.adbook.di.module.SettingModule
import com.wy.adbook.ext.inflate
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.contranct.SettingContract
import com.wy.adbook.mvp.presenter.SettingPresenter
import kotlinx.android.synthetic.main.activity_setting.*
import org.jetbrains.anko.find

/**
 * Created by leafye on 2019-05-29.
 */
class SettingActivity : QYBaseActivity<SettingPresenter>(), SettingContract.View {


    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, SettingActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerSettingComponent.builder()
            .appComponent(appComponent)
            .settingModule(SettingModule((this@SettingActivity)))
            .build()
            .inject(this@SettingActivity)
    }

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_setting

    override fun getToolbar(): View? = title_bar_view

    override fun initData(savedInstanceState: Bundle?) {
        initListener()
        refreshView()
    }

    override fun refreshView() {
        if (QYAccount.isLogin()) {
            logout_btn.visibility = View.VISIBLE
        } else {
            logout_btn.visibility = View.GONE
        }
        cache_content.text = mPresenter?.getCacheSize()
    }

    private fun initListener() {
        cache_item_container.onClick { showConfirmClearCacheDialog() }
        comment_on_our_container.onClick { }
        about_us_container.onClick { AboutUsActivity.startActivity(this@SettingActivity) }
        logout_btn.onClick { showLogoutDialog() }
    }

    private fun showLogoutDialog() {
        val dialogView = inflate(R.layout.common_dialog_layout).apply {
            find<TextView>(R.id.title).text = "确认退出账号？？"
        }
        CommonDialog.Builder()
            .contentView(dialogView)
            .setOnClick(R.id.dialog_exit, R.id.dialog_continue)
            .onClick { dialog, view ->
                when (view.id) {
                    R.id.dialog_continue -> mPresenter?.logout()
                }
                dialog.dismiss()
            }
            .build(this@SettingActivity)
            .show()
    }

    private fun showConfirmClearCacheDialog() {
        val dialogView = inflate(R.layout.common_dialog_layout).apply {
            find<TextView>(R.id.title).text = "清除缓存？"
        }
        CommonDialog.Builder()
            .contentView(dialogView)
            .setOnClick(R.id.dialog_exit, R.id.dialog_continue)
            .onClick { dialog, view ->
                when (view.id) {
                    R.id.dialog_continue -> mPresenter?.clearCache()
                }
                dialog.dismiss()
            }
            .build(this@SettingActivity)
            .show()
    }
}