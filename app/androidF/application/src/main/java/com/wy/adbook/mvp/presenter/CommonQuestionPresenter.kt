package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.FragmentScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.rx.net
import com.wy.adbook.app.utils.ChannelUtils
import com.wy.adbook.mvp.contranct.CommonQuestionContract
import com.wy.adbook.mvp.model.entity.FaqItem
import com.wy.adbook.mvp.model.entity.FaqList
import com.wy.adbook.mvp.model.entity.NetFaqList
import com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter
import com.wy.adbook.view.status.IStatusCoverView
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-28.
 */
@FragmentScope
class CommonQuestionPresenter
@Inject
constructor(model: CommonQuestionContract.Model, view: CommonQuestionContract.View) :
    QYBasePresenter<CommonQuestionContract.Model, CommonQuestionContract.View>(model, view) {

    @Inject
    lateinit var commonQuestionAdapter: CommonQuestionAdapter
    @Inject
    lateinit var faqList: MutableList<FaqItem>

    var faqPage: FaqList? = null

    fun loadMore() {
        mModel.faqList(ChannelUtils.getChannel(), (faqPage?.pageNo ?: 1) + 1, 10)
            .net(mRootView)
            .subscribe(object : ErrorHandleSubscriber<NetFaqList>(mErrorHandler) {
                override fun onNext(t: NetFaqList) {
                    if (t.isOk()) {
                        faqPage = t.data
                        t.data?.faqItemList?.let {
                            commonQuestionAdapter.addData(it)
                        }
                        if (t.data?.pageNo ?: 0 >= t.data?.pages ?: 0) {
                            commonQuestionAdapter.loadMoreEnd()
                        } else {
                            commonQuestionAdapter.loadMoreComplete()
                        }
                    } else {
                        mRootView.getContext().toast(t.msg)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    commonQuestionAdapter.loadMoreFail()
                }

            })
    }

    fun fetchData() {
        mRootView.changeStatus(IStatusCoverView.Status.LOADING)
        mRootView.setRefresh(true)
        mModel.faqList(ChannelUtils.getChannel(), 1, 10)
            .net(mRootView)
            .doFinally {
                mRootView.setRefresh(false)
            }
            .subscribe(object : ErrorHandleSubscriber<NetFaqList>(mErrorHandler) {
                override fun onNext(t: NetFaqList) {
                    if (t.isOk()) {
                        faqPage = t.data
                        faqList.clear()
                        t.data?.faqItemList?.let {
                            faqList.addAll(it)
                        }
                        commonQuestionAdapter.setNewData(faqList)
                        mRootView.changeStatus(IStatusCoverView.Status.SUCCESS)
                    } else {
                        mRootView.changeStatus(IStatusCoverView.Status.ERROR)
                        mRootView.hideLoading()
                        mRootView.getContext().toast(t.msg)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.setRefresh(false)
                    mRootView.changeStatus(IStatusCoverView.Status.ERROR)
                }

            })
    }


}