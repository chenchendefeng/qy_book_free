package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.rx.net
import com.wy.adbook.mvp.contranct.ReadFooterContract
import com.wy.adbook.mvp.model.entity.NetDeleteReadFooter
import com.wy.adbook.mvp.model.entity.NetReadFooterPage
import com.wy.adbook.mvp.model.entity.ReadFooterItem
import com.wy.adbook.mvp.model.entity.ReadFooterPage
import com.wy.adbook.mvp.view.adapter.ReadFooterAdapter
import com.wy.adbook.view.status.IStatusCoverView
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-28.
 */
@ActivityScope
class ReadFooterPresenter
@Inject
constructor(model: ReadFooterContract.Model, view: ReadFooterContract.View) :
    QYBasePresenter<ReadFooterContract.Model, ReadFooterContract.View>(model, view) {

    private var readFooterPage: ReadFooterPage? = null

    @Inject
    lateinit var readFooterItemList: MutableList<ReadFooterItem>

    @Inject
    lateinit var readFooterAdapter: ReadFooterAdapter

    fun fetchData() {
        mRootView.changeCoverStatus(IStatusCoverView.Status.LOADING)
        mRootView.setRefresh(true)
        mModel.getReadFooterPage(QYAccount.uid(), 1, 6)
            .net(mRootView)
            .doFinally {
                mRootView.setRefresh(false)
            }
            .subscribe(object : ErrorHandleSubscriber<NetReadFooterPage>(mErrorHandler) {
                override fun onNext(t: NetReadFooterPage) {
                    if (t.isOk()) {
                        readFooterPage = t.data
                        readFooterAdapter.setNewData(t.data?.readFooterItemList)
                        mRootView.changeCoverStatus(IStatusCoverView.Status.SUCCESS)
                    } else {
                        mRootView.showError(t.msg)
                        mRootView.changeCoverStatus(IStatusCoverView.Status.ERROR)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.changeCoverStatus(IStatusCoverView.Status.ERROR)
                }
            })
    }

    fun loadMore() {
        mModel.getReadFooterPage(QYAccount.uid(), (readFooterPage?.pageNo ?: 1) + 1, 6)
            .net(mRootView)
            .subscribe(object : ErrorHandleSubscriber<NetReadFooterPage>(mErrorHandler) {
                override fun onNext(t: NetReadFooterPage) {
                    if (t.isOk()) {
                        t.data?.let {
                            readFooterPage?.count = it.count
                            readFooterPage?.pageNo = it.pageNo
                            readFooterPage?.pages = it.pages
                        }
                        val itemList = t.data?.readFooterItemList
                        if (itemList == null || itemList.isEmpty()) {
                            readFooterAdapter.loadMoreEnd()
                        } else {
                            readFooterAdapter.addData(itemList)
                            if (t.data?.pageNo ?: 0 >= t.data?.pages ?: 0) {
                                readFooterAdapter.loadMoreEnd()
                            } else {
                                readFooterAdapter.loadMoreComplete()
                            }
                        }
                    } else {
                        readFooterAdapter.loadMoreFail()
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    readFooterAdapter.loadMoreFail()
                }
            })
    }

    fun deleteReadFooter(item: ReadFooterItem) {
        mRootView.showLoading()
        mModel.deleteReadFooter(item.bid)
            .net(mRootView)
            .subscribe(object : ErrorHandleSubscriber<NetDeleteReadFooter>(mErrorHandler) {
                override fun onNext(t: NetDeleteReadFooter) {
                    if (t.isOk()) {
                        mRootView.showSuccess("删除成功")
                        //进行删除
                        deleteData(item)
                    } else {
                        mRootView.showError(t.msg)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.showError(t.message ?: "网络错误")
                }
            })
    }

    private fun deleteData(item: ReadFooterItem) {
        val indexOf = readFooterAdapter.data.indexOf(item)
        readFooterAdapter.remove(indexOf)
    }


}