package com.wy.adbook.mvp.presenter

import android.os.Bundle
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.utils.RxLifecycleUtils
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.manager.SchemeManager
import com.wy.adbook.mvp.contranct.ProjectContract
import com.wy.adbook.mvp.model.api.cache.ApiCacheSubscriber
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.BannerItem
import com.wy.adbook.mvp.model.entity.NetBanner
import com.wy.adbook.mvp.model.entity.NetSubjectType
import com.wy.adbook.mvp.model.entity.SubjectType
import com.wy.adbook.mvp.view.adapter.ProjectAdapter
import com.wy.adbook.mvp.view.adapter.ProjectItem
import com.wy.adbook.mvp.view.fragment.ProjectFragment
import com.wy.adbook.view.status.IStatusCoverView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */
@FragmentScope
class ProjectPresenter
@Inject
constructor(model: ProjectContract.Model, view: ProjectContract.View) :
    QYBasePresenter<ProjectContract.Model, ProjectContract.View>(model, view) {

    private var subjectTypeStr: String = ""

    private var subjectTypeList: MutableList<SubjectType>? = null
    @Inject
    lateinit var bannerList: MutableList<BannerItem>
    @Inject
    lateinit var projectAdapter: ProjectAdapter
    @Inject
    lateinit var mProjectList: MutableList<ProjectItem>

    fun getTestData(): MutableList<ProjectItem> {
        return mutableListOf<ProjectItem>().apply {
            subjectTypeList?.forEachIndexed { index, subjectType ->
                val projectItem = ProjectItem()
                projectItem.any = subjectType
                subjectType.subjectType = subjectTypeStr
                if (SubjectType.SUBJECT_TYPE_RECOMMEND == subjectTypeStr) {
                    if (index == subjectTypeList!!.size - 1) {
                        projectItem.projectItemType = ProjectItem.TYPE_N
                    } else {
                        projectItem.projectItemType = ProjectItem.TYPE_1_3
                    }
                } else if (SubjectType.SUBJECT_TYPE_BOY == subjectTypeStr) {
                    when (index) {
                        subjectTypeList!!.size - 1 -> projectItem.projectItemType = ProjectItem.TYPE_N
                        0 -> projectItem.projectItemType = ProjectItem.TYPE_1_2_GRID
                        else -> projectItem.projectItemType = ProjectItem.TYPE_1_3
                    }
                } else if (SubjectType.SUBJECT_TYPE_GIRL == subjectTypeStr) {
                    when (index) {
                        subjectTypeList!!.size - 1 -> projectItem.projectItemType = ProjectItem.TYPE_N
                        0 -> projectItem.projectItemType = ProjectItem.TYPE_1_4_LIST
                        else -> projectItem.projectItemType = ProjectItem.TYPE_1_3
                    }
                }
                add(projectItem)
            }
        }
    }

    fun initData(bundle: Bundle?) {
        bundle?.let {
            subjectTypeStr = it.getString(ProjectFragment.ARGUMENT_SUBJECT_TYPE) ?: ""
        }
    }

    fun fetchData() {
        fetchBanner()
    }

    private fun fetchBanner() {
        mModel.bannerList(subjectTypeStr)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                mRootView.refreshStatus(true)
            }
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .doFinally {
                mRootView.refreshBanner()
                fetchSubject(true)
            }
            .subscribe(object : ApiCacheSubscriber<NetBanner>(
                mErrorHandler,
                QYService.API_BANNER_LIST + "_" + subjectTypeStr,
                NetBanner::class.java
            ) {
                override fun onCache(t: NetBanner?) {
                    t?.data?.let {
                        replaceBannerList(it)
                    }
                }

                override fun onSuccess(t: NetBanner) {
                    t.data?.let {
                        replaceBannerList(it)
                    }
                }
            })
    }

    private fun replaceBannerList(it: MutableList<BannerItem>) {
        bannerList.clear()
        bannerList.addAll(it)
    }

    private fun fetchSubject(isRefresh: Boolean) {
        mModel.fetchSubject(subjectTypeStr)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                if (isRefresh) {
                    mRootView.refreshStatus(true)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .doFinally {
                mRootView?.refreshStatus(false)
            }
            .subscribe(
                object : ApiCacheSubscriber<NetSubjectType>(
                    mErrorHandler,
                    QYService.BOOK_SUBJECT_LIST_BY_SUBJECT_TYPE + "_" + subjectTypeStr,
                    NetSubjectType::class.java,
                    isRefresh
                ) {
                    override fun onCache(t: NetSubjectType?) {
                        t?.let {
                            subjectTypeList = t.data
                            refreshDataAndView(isRefresh)
                        }
                    }

                    override fun onSuccess(t: NetSubjectType) {
                        if (t.isOk()) {
                            subjectTypeList = t.data
                            refreshDataAndView(isRefresh)
                        } else {
                            mRootView.showError(t.msg)
                        }
                    }

                    override fun onError(e: Throwable) {
                        super.onError(e)
                        if (subjectTypeList == null || subjectTypeList?.isEmpty() == true) {
                            mRootView.changeStatusCoverView(IStatusCoverView.Status.ERROR)
                        } else {
                            refreshDataAndView(isRefresh)
                        }
                    }
                })
    }

    private fun refreshDataAndView(isRefresh: Boolean) {
        mRootView.changeStatusCoverView(IStatusCoverView.Status.SUCCESS)
        if (isRefresh) {
            mProjectList.clear()
            mProjectList.addAll(getTestData())
            projectAdapter.notifyDataSetChanged()
        } else {

        }
    }

    fun handlerBannerItem(url: String) {
        SchemeManager.parseScheme(mRootView, url, mModel.getRM(), mErrorHandler)
    }
}