package com.freebookqy.application.mvp.classification

import com.freebookqy.application.R
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.mvp.classification.detail.ClassificationDetailActivity
import com.freebookqy.application.mvp.contranct.ClassificationContract
import com.freebookqy.application.mvp.model.api.service.QYService
import com.freebookqy.application.mvp.model.entity.Classification
import com.freebookqy.application.mvp.model.entity.ClassificationItem
import com.freebookqy.utilslib.ResUtils
import com.jess.arms.di.scope.ActivityScope
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/5.
 */
@ActivityScope
class ClassificationPresenter
@Inject
constructor(model: ClassificationContract.Model, view: ClassificationContract.View) :
    QYBasePresenter<ClassificationContract.Model, ClassificationContract.View>(model, view) {

    val classificationList: MutableList<Classification> by lazy {
        mutableListOf<Classification>().apply {
            add(Classification(ResUtils.getString(R.string.man)))
            add(Classification(ResUtils.getString(R.string.woman)))
            get(0).isSelected = true
        }
    }
    /**
     * @link {QYService.BOY}
     * @link {QYService.BOY}
     */
    @QYService.NetGenderParam
    var currentRequestType: String = QYService.NetGenderParam.BOY

    private var pageSize = 10

    fun fetchData() {
        fetchDataByType(true)
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
                mRootView.isRefresh(false)
            }
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<Classification>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<Classification>) {
                    if (t.result == BaseEntity.RESULT_OK) {
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
                                mRootView.getAdapter().loadMoreEnd(true)
                            } else {
                                mRootView.getAdapter().loadMoreComplete()
                            }
                        }
                    } else {
                        mRootView.showError(t.msg)
                        if (!isRefresh)
                            mRootView.getAdapter().loadMoreFail()
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    if (!isRefresh)
                        mRootView.getAdapter().loadMoreFail()
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