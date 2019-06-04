package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.utils.RxLifecycleUtils
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.app.utils.ChannelUtils
import com.wy.adbook.mvp.contranct.ClassificationContract
import com.wy.adbook.mvp.model.api.cache.ApiCacheSubscriber
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.*
import com.wy.adbook.mvp.view.activity.ClassificationDetailActivity
import com.wy.adbook.mvp.view.adapter.ClassificationAdapter
import com.wy.adbook.mvp.view.adapter.ClassificationContentAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/5.
 */
@ActivityScope
class ClassificationPresenter
@Inject
constructor(model: ClassificationContract.Model, view: ClassificationContract.View) :
    QYBasePresenter<ClassificationContract.Model, ClassificationContract.View>(model, view) {

    companion object {
        private const val BANNER_ARGS = "category"
    }

    @Inject
    lateinit var bannerList: MutableList<BannerItem>
    @Inject
    lateinit var classificationAdapter: ClassificationAdapter
    @Inject
    lateinit var classificationContentAdapter: ClassificationContentAdapter
    @Inject
    lateinit var classificationList: MutableList<Classification>

    /**
     * @link {QYService.BOY}
     * @link {QYService.BOY}
     */
    @QYService.NetGenderParam
    var currentRequestType: String = QYService.NetGenderParam.BOY

    private var pageSize = 10

    fun fetchData() {
        fetchBanner()
    }

    private fun fetchBanner() {
        mModel.fetchBanner(Constant.DEF_SOURCE, BANNER_ARGS, ChannelUtils.getChannel())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                mRootView.isRefresh(true)
            }
            .doFinally {
                fetchDataByType(true)
            }
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ApiCacheSubscriber<NetBanner>(
                mErrorHandler,
                QYService.API_BANNER_LIST + "_" + BANNER_ARGS,
                NetBanner::class.java,
                true
            ) {
                override fun onCache(t: NetBanner?) {
                    t?.data?.let {
                        bannerList.clear()
                        bannerList.addAll(it)
                    }
                }

                override fun onSuccess(t: NetBanner) {
                    if (t.isOk()) {
                        t.data?.let {
                            bannerList.clear()
                            bannerList.addAll(it)
                        }
                    } else {

                    }
                }
            })
    }

    fun loadMore() {
        fetchDataByType(false)
    }

    private fun fetchDataByType(isRefresh: Boolean) {
        val type: String
        val pageNo: Int
        val currentClassification: Classification
        if (currentRequestType == QYService.NetGenderParam.BOY) {
            type = QYService.NetGenderParam.BOY
            currentClassification = classificationList[0]
            pageNo = if (isRefresh) 1 else currentClassification.pageNo + 1
        } else {
            type = QYService.NetGenderParam.GIRL
            currentClassification = classificationList[1]
            pageNo = if (isRefresh) 1 else currentClassification.pageNo + 1
        }
        mModel.categoryData(pageNo, pageSize, type)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                mRootView.isRefresh(isRefresh)
            }
            .doFinally {
                mRootView?.isRefresh(false)
            }
            .subscribe(object : ApiCacheSubscriber<NetClassification>(
                mErrorHandler,
                QYService.BOOK_CATEGORY_PAGE_LIST_BY_SEX_TYPE,
                NetClassification::class.java,
                isRefresh
            ) {
                override fun onCache(t: NetClassification?) {
                    if (isRefresh) {
                        if (isRefresh) {
                            currentClassification.itemList?.clear()
                        }
                        t?.data?.itemList?.let { netClassificationItemList ->
                            currentClassification.itemList?.addAll(netClassificationItemList)
                        }
                    }
                }

                override fun onSuccess(t: NetClassification) {
                    if (t.isOk()) {
                        if (currentClassification.itemList?.isNotEmpty() != true) {
                            t.data?.itemList?.let {
                                currentClassification.itemList = it
                            }
                        } else {
                            if (isRefresh) {
                                currentClassification.itemList?.clear()
                            }
                            t.data?.itemList?.let { netClassificationItemList ->
                                currentClassification.itemList?.addAll(netClassificationItemList)
                            }
                        }
                        mRootView.refreshView()
                        if (!isRefresh) {
                            if (t.data?.pageNo ?: 0 >= t.data?.pages ?: 0) {
                                classificationContentAdapter.loadMoreEnd(true)
                            } else {
                                classificationContentAdapter.loadMoreComplete()
                            }
                        }
                    } else {
                        mRootView.showError(t.msg)
                        if (!isRefresh)
                            classificationContentAdapter.loadMoreFail()
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    if (!isRefresh)
                        classificationContentAdapter.loadMoreFail()
                }
            })
    }


    fun getSelectClassificationItem(): MutableList<ClassificationItem>? {
        return classificationList.find { it.isSelected }?.itemList
    }

    fun classificationClick(classification: Classification) {
        classificationList.forEach { it.isSelected = false }
        classification.isSelected = true
        currentRequestType = if (classificationList[0].isSelected) {
            QYService.NetGenderParam.BOY
        } else {
            QYService.NetGenderParam.GIRL
        }
        if (classification.itemList?.isNotEmpty() != true) {
            fetchData()
        }
        mRootView.refreshView()
    }

    fun classificationContentClick(classificationItem: ClassificationItem) {
        //进入分类详情界面
        ClassificationDetailActivity.startActivity(mRootView.getContext(), classificationItem)
    }


}