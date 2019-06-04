package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.freebookqy.application.R
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.di.component.DaggerWithdrawalRecordComponent
import com.wy.adbook.di.module.WithdrawalRecordModule
import com.wy.adbook.mvp.contranct.WithdrawalRecordContract
import com.wy.adbook.mvp.presenter.WithdrawalRecordPresenter
import com.wy.adbook.mvp.view.adapter.WithdrawalRecordAdapter
import com.wy.adbook.view.status.IStatusCoverView
import kotlinx.android.synthetic.main.activity_withdrawal_record.*
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-26.
 */
class WithdrawalRecordActivity
    : QYBaseActivity<WithdrawalRecordPresenter>(), WithdrawalRecordContract.View {

    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, WithdrawalRecordActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerWithdrawalRecordComponent.builder()
            .appComponent(appComponent)
            .withdrawalRecordModule(WithdrawalRecordModule((this@WithdrawalRecordActivity)))
            .build()
            .inject(this@WithdrawalRecordActivity)
    }

    override fun getToolbar(): View? = title_bar_view

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_withdrawal_record

    @Inject
    lateinit var withdrawalRecordAdapter: WithdrawalRecordAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun initData(savedInstanceState: Bundle?) {
        initRv()
        initListener()
        mPresenter?.fetchData()
    }

    private fun initRv() {
        if (withdrawal_record_rv.layoutManager == null) {
            withdrawal_record_rv.layoutManager = linearLayoutManager
            withdrawal_record_rv.adapter = withdrawalRecordAdapter.apply {
                setOnLoadMoreListener({
                    mPresenter?.loadMore()
                }, withdrawal_record_rv)
                setEmptyView(R.layout.empty_withdrawal)
            }
        }
    }

    private fun initListener() {
        refresh_layout.setOnRefreshListener { mPresenter?.fetchData() }
        status_cover_view.setReTryClickListener(object : IStatusCoverView.ReTryClickListener {
            override fun reTry() {
                mPresenter?.fetchData()
            }
        })
        title_bar_view.setOnLeftButtonClickListener { finish() }
    }

    override fun changeStatus(status: IStatusCoverView.Status) {
        status_cover_view.changeStatus(status)
    }


}