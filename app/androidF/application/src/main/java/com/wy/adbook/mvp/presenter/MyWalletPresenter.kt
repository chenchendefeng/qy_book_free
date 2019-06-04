package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.rx.ServerRetException
import com.wy.adbook.app.rx.net
import com.wy.adbook.mvp.contranct.MyWalletContract
import com.wy.adbook.mvp.model.entity.accout.Balance
import com.wy.adbook.mvp.model.entity.accout.FlowPage
import com.wy.adbook.mvp.model.entity.accout.NetFlowPage
import com.wy.adbook.mvp.view.adapter.WalletItemAdapter
import com.wy.adbook.view.status.IStatusCoverView
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/6.
 */
@ActivityScope
class MyWalletPresenter
@Inject
constructor(model: MyWalletContract.Model, view: MyWalletContract.View) :
    QYBasePresenter<MyWalletContract.Model, MyWalletContract.View>(model, view) {

    var balance: Balance? = null

    var rmbFlowPage: FlowPage? = null

    var goldFlowPage: FlowPage? = null
    /**
     * 获取用户现金情况
     */
    fun fetchData() {
        mRootView.changeStatusCoverView(IStatusCoverView.Status.LOADING)
        mModel.balance(QYAccount.uid())
            .net(mRootView)
            .doOnNext {
                balance = it.data
            }
            .concatMap {
                mModel.accountFLowPage(QYAccount.uid(), "rmb", 1, 10)
            }
            .net(mRootView)
            .doOnNext {
                if (it.isOk()) {
                    rmbFlowPage = it.data
                } else {
                    throw ServerRetException(it.msg)
                }
            }
            .concatMap {
                mModel.accountFLowPage(QYAccount.uid(), "gold", 1, 10)
            }
            .net(mRootView)
            .subscribe(object : ErrorHandleSubscriber<NetFlowPage>(mErrorHandler) {
                override fun onNext(t: NetFlowPage) {
                    if (t.isOk()) {
                        mRootView.changeStatusCoverView(IStatusCoverView.Status.SUCCESS)
                        goldFlowPage = t.data
                        mRootView.refreshView()
                    } else {
                        mRootView.changeStatusCoverView(IStatusCoverView.Status.ERROR)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.changeStatusCoverView(IStatusCoverView.Status.ERROR)
                }
            })
    }

    fun loadMoreRmb(adapter: WalletItemAdapter) {
        loadMore("rmb", rmbFlowPage?.pageNo ?: 0 + 1, adapter)
    }

    fun loadMoreGold(adapter: WalletItemAdapter) {
        loadMore("gold", goldFlowPage?.pageNo ?: 0 + 1, adapter)
    }

    private fun loadMore(currency: String, pageNo: Int, adapter: WalletItemAdapter) {
        mModel
            .accountFLowPage(
                QYAccount.uid(),
                currency,
                pageNo,
                10
            )
            .net(mRootView)
            .subscribe(object : ErrorHandleSubscriber<NetFlowPage>(mErrorHandler) {
                override fun onNext(t: NetFlowPage) {
                    if (t.isOk()) {
                        if (currency == "rmb") {
                            rmbFlowPage?.let {
                                it.count = t.data?.count ?: 0
                                it.pageNo = t.data?.pageNo ?: 0
                                it.pages = t.data?.pages ?: 0
                            }
                        } else if (currency == "gold") {
                            goldFlowPage?.let {
                                it.count = t.data?.count ?: 0
                                it.pageNo = t.data?.pageNo ?: 0
                                it.pages = t.data?.pages ?: 0
                            }
                        }
                        if (pageNo == 1) {
                            adapter.setNewData(null)
                        }
                        t.data?.data?.let {
                            adapter.addData(it)
                        }
                        if (t.data?.pageNo ?: 0 >= t.data?.pages ?: 0) {
                            adapter.loadMoreEnd()
                        } else {
                            adapter.loadMoreComplete()
                        }
                    } else {
                        adapter.loadMoreFail()
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    adapter.loadMoreFail()
                }
            })
    }


}