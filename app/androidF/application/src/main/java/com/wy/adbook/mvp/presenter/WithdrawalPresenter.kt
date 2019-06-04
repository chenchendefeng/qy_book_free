package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.contranct.WithdrawalContract
import com.wy.adbook.mvp.model.entity.WithdrawalItem
import com.wy.adbook.mvp.view.activity.WithdrawalRecordActivity
import com.wy.adbook.mvp.view.adapter.WithdrawablAdapter
import com.wy.adbook.view.status.IStatusCoverView
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by leafye on 2019-05-26.
 */
@ActivityScope
class WithdrawalPresenter
@Inject
constructor(model: WithdrawalContract.Model, view: WithdrawalContract.View) :
    QYBasePresenter<WithdrawalContract.Model, WithdrawalContract.View>(model, view) {

    @Inject
    @field:Named("adapter1")
    lateinit var goldAdapter: WithdrawablAdapter
    @Inject
    @field:Named("adapter2")
    lateinit var cashAdapter: WithdrawablAdapter

    @Inject
    @field:Named("list1")
    lateinit var goldList: MutableList<WithdrawalItem>
    @Inject
    @field:Named("list2")
    lateinit var cashList: MutableList<WithdrawalItem>


    fun fetchData() {
        //获取提现数据
        mRootView.refreshView()
        mRootView.changeStatus(IStatusCoverView.Status.SUCCESS)
    }

    fun startWithdrawal(withdrawalItem: WithdrawalItem) {

    }

    fun enterGoldDetail() {

    }

    fun enterWithdrawalDetail() {
        WithdrawalRecordActivity.startActivity(mRootView.getContext())
    }

    fun toInviteFriends() {

    }

    fun enterCashDetail() {

    }


}