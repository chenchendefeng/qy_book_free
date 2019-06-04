package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.FragmentScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.contranct.WalletItemContract
import com.wy.adbook.mvp.model.entity.accout.FlowPage
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-28.
 */
@FragmentScope
class WalletItemPresenter
@Inject
constructor(model: WalletItemContract.Model, view: WalletItemContract.View) :
    QYBasePresenter<WalletItemContract.Model, WalletItemContract.View>(model, view) {

    var flowPage: FlowPage? = null

//    fun fetchData(){
//        mModel.accountFLowPage(QYAccount.uid(), "gold", 1, 10)
//            .net(mRootView)
//            .subscribe(object : ErrorHandleSubscriber<NetFlowPage>(mErrorHandler) {
//                override fun onNext(t: NetFlowPage) {
//                    if (BaseEntity.RESULT_OK == t.result) {
//                        flowPage = t.data
//                        flowPage?.data?.let {
//                            mRootView.getCurrentAdapter().setNewData(it)
//                        }
//                    }
//                }
//
//                override fun onError(t: Throwable) {
//                    super.onError(t)
//                }
//            })
//    }

}