package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.freebookqy.application.R
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.di.component.DaggerBasicInfoComponent
import com.wy.adbook.di.module.BasicInfoModule
import com.wy.adbook.dialog.EditTextDialog
import com.wy.adbook.mvp.contranct.BasicInfoContract
import com.wy.adbook.mvp.model.view.BasicInfo
import com.wy.adbook.mvp.presenter.BasicInfoPresenter
import com.wy.adbook.mvp.view.adapter.BasicInfoAdapter
import kotlinx.android.synthetic.main.activity_basic_info.*
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-30.
 */
class BasicInfoActivity : QYBaseActivity<BasicInfoPresenter>(), BasicInfoContract.View {


    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, BasicInfoActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerBasicInfoComponent.builder()
            .appComponent(appComponent)
            .basicInfoModule(BasicInfoModule((this@BasicInfoActivity)))
            .build()
            .inject(this@BasicInfoActivity)
    }

    override fun getToolbar(): View? = title_bar_view

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_basic_info

    @Inject
    lateinit var basicInfoAdapter: BasicInfoAdapter

    @Inject
    lateinit var llm: LinearLayoutManager

    override fun initData(savedInstanceState: Bundle?) {
        if (basic_info_rv.layoutManager == null) {
            basic_info_rv.layoutManager = llm
            basic_info_rv.adapter = basicInfoAdapter.apply {
                setOnItemClickListener { adapter, view, position ->
                    val item = adapter.data[position] as BasicInfo
                    mPresenter?.handleBasicInfo(item)
                }
            }
        }
    }

    override fun showChangeNickNameDialog() {
        EditTextDialog(this@BasicInfoActivity).apply {
            setData("修改昵称", QYAccount.getUserInfo().nickName)
            setEditTextDialogClickListener(object : EditTextDialog.EditTextDialogClickListener {
                override fun cancel(d: EditTextDialog) {

                }

                override fun confirm(d: EditTextDialog, inputContent: String) {
                    mPresenter?.toChangeNickname(inputContent)
                }
            })
        }.show()
    }
}