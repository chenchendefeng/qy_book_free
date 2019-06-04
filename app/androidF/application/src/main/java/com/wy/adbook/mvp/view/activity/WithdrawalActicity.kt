package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.freebookqy.application.R
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.di.component.DaggerWithdrawalComponent
import com.wy.adbook.di.module.WithdrawalModule
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.contranct.WithdrawalContract
import com.wy.adbook.mvp.model.entity.WithdrawalItem
import com.wy.adbook.mvp.presenter.WithdrawalPresenter
import com.wy.adbook.mvp.view.adapter.WithdrawablAdapter
import com.wy.adbook.view.status.IStatusCoverView
import kotlinx.android.synthetic.main.activity_withdrawal.*
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by leafye on 2019-05-26.
 */
class WithdrawalActivity
    : QYBaseActivity<WithdrawalPresenter>(), WithdrawalContract.View {
    companion object {

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, WithdrawalActivity::class.java))
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerWithdrawalComponent.builder()
            .appComponent(appComponent)
            .withdrawalModule(WithdrawalModule((this@WithdrawalActivity)))
            .build()
            .inject(this@WithdrawalActivity)
    }

    override fun getToolbar(): View? = title_bar_view

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_withdrawal

    @Inject
    @field:Named("adapter1")
    lateinit var goldAdapter: WithdrawablAdapter

    @Inject
    @field:Named("adapter2")
    lateinit var cashAdapter: WithdrawablAdapter

    @Inject
    @field:Named("glm1")
    lateinit var glm1: FullyGridLayoutManager
    @Inject
    @field:Named("glm2")
    lateinit var glm2: FullyGridLayoutManager

    override fun initData(savedInstanceState: Bundle?) {
        initRv()
        initListener()
        mPresenter?.fetchData()
    }

    private fun initRv() {
        if (my_gold_bean_rv.layoutManager == null) {
            my_gold_bean_rv.layoutManager = glm1
            my_gold_bean_rv.adapter = goldAdapter.apply {
                setOnItemClickListener { adapter, view, position ->
                    val withdrawalItem = adapter.data[position] as WithdrawalItem
                    mPresenter?.startWithdrawal(withdrawalItem)
                }
            }
        }
        if (my_cash_rv.layoutManager == null) {
            my_cash_rv.layoutManager = glm2
            my_cash_rv.adapter = cashAdapter.apply {
                setOnItemClickListener { adapter, view, position ->
                    val withdrawalItem = adapter.data[position] as WithdrawalItem
                    mPresenter?.startWithdrawal(withdrawalItem)
                }
            }
        }
    }

    private fun initListener() {
        title_bar_view.setOnLeftButtonClickListener { finish() }
        my_gold_bean_container.onClick {
            //进入金豆详情
            mPresenter?.enterGoldDetail()
        }
        my_cash_container.onClick {
            //进入现金详情
            mPresenter?.enterCashDetail()
        }
        to_make_money_tv.onClick {
            //去赚钱
            mPresenter?.toInviteFriends()
        }
        withdrawal_btn.onClick {
            //进入提现兑换详情
            mPresenter?.enterWithdrawalDetail()
        }
    }

    override fun refreshView() {
        my_gold_bean_count_tv.text = ResUtils.getString(R.string.my_fortunella_venosa, 0)
        estimated_tv.text = "约${0}元"
        my_cash_tv.text = ResUtils.getString(R.string.my_cash_n, 0)
        invite_friend_tv.text = ResUtils.getString(R.string.invite_good_ulead_earn_n_dollars_in_cash, 0)
    }

    override fun changeStatus(status: IStatusCoverView.Status) {
        status_cover_view.changeStatus(status)
    }


}