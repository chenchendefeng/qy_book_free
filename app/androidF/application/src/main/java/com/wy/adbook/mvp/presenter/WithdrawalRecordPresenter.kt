package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.contranct.WithdrawalRecordContract
import com.wy.adbook.mvp.model.entity.WithdrawalRecordItem
import com.wy.adbook.mvp.view.adapter.WithdrawalRecordAdapter
import com.wy.adbook.view.status.IStatusCoverView
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-26.
 */
@ActivityScope
class WithdrawalRecordPresenter
@Inject
constructor(model: WithdrawalRecordContract.Model, view: WithdrawalRecordContract.View) :
    QYBasePresenter<WithdrawalRecordContract.Model, WithdrawalRecordContract.View>(model, view) {

    @Inject
    lateinit var withdrawalRecordAdapter: WithdrawalRecordAdapter
    @Inject
    lateinit var recordItemList: MutableList<WithdrawalRecordItem>

    fun fetchData() {
        mRootView.changeStatus(IStatusCoverView.Status.SUCCESS)
    }

    fun loadMore() {

    }


}