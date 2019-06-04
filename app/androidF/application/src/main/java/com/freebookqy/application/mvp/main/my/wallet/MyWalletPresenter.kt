package com.freebookqy.application.mvp.main.my.wallet

import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.mvp.contranct.MyWalletContract
import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/6.
 */
@ActivityScope
class MyWalletPresenter
@Inject
constructor(model: MyWalletContract.Model, view: MyWalletContract.View) :
    QYBasePresenter<MyWalletContract.Model, MyWalletContract.View>(model, view) {
    /**
     * 获取用户现金情况
     */
    fun fetchData() {

    }


}