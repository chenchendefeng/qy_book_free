package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.freebookqy.application.R
import com.freebookqy.utilslib.ResUtils
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.di.component.DaggerRedEnvelopesForCodeComponent
import com.wy.adbook.di.module.RedEnvelopesForCodeModule
import com.wy.adbook.dialog.prompt.QYCommonPromptDialog
import com.wy.adbook.dialog.prompt.RedRevelopesDialog
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.contranct.RedEnvelopesForCodeContract
import com.wy.adbook.mvp.presenter.RedEnvelopesForCodePresenter
import kotlinx.android.synthetic.main.activity_red_envelopes_for_code.*

/**
 * Created by leafye on 2019-05-27.
 */
class RedEnvelopesForCodeActivity
    : QYBaseActivity<RedEnvelopesForCodePresenter>(),
    RedEnvelopesForCodeContract.View {

    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, RedEnvelopesForCodeActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerRedEnvelopesForCodeComponent.builder()
            .appComponent(appComponent)
            .redEnvelopesForCodeModule(RedEnvelopesForCodeModule((this@RedEnvelopesForCodeActivity)))
            .build()
            .inject(this@RedEnvelopesForCodeActivity)
    }

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_red_envelopes_for_code

    override fun getToolbar(): View? = title_bar_view

    override fun initData(savedInstanceState: Bundle?) {
        initListener()
    }

    private fun initListener() {
        submit_btn.onClick { showRedRevelopesDialog() }
    }

    /**
     * 设置界面为已提交
     */
    override fun setSubmited() {
        submit_btn.isEnabled = false
        submit_btn.text = ResUtils.getString(R.string.has_been_submitted)
    }

    override fun waitSubmit() {
        submit_btn.isEnabled = true
        submit_btn.text = ResUtils.getString(R.string.submit_text)
    }

    override fun showRedRevelopesDialog() {
        val redRevelopesDialog = RedRevelopesDialog(this@RedEnvelopesForCodeActivity)
        QYCommonPromptDialog(this@RedEnvelopesForCodeActivity)
            .apply dialog@{
                setView(redRevelopesDialog.apply {
                    setRedRevelopesListener(object : RedRevelopesDialog.RedRevelopesListener {
                        override fun ok() {
                            this@dialog.dismiss()
                        }
                    })
                })
                redRevelopesDialog.startAnim()
            }.show()
    }

}