package com.freebookqy.application.mvp.main.project

import android.os.Bundle
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.mvp.contranct.ProjectContract
import com.freebookqy.application.mvp.main.adapter.ProjectItem
import com.freebookqy.application.mvp.model.entity.SubjectType
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.utils.RxLifecycleUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */
@ActivityScope
class ProjectPresenter
@Inject
constructor(model: ProjectContract.Model, view: ProjectContract.View) :
    QYBasePresenter<ProjectContract.Model, ProjectContract.View>(model, view) {

    private var subjectTypeStr: String = ""

    private var subjectTypeList: MutableList<SubjectType>? = null

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
                        0 -> projectItem.projectItemType = ProjectItem.TYPE_1_4_GRID
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

    fun fetchData(isRefresh: Boolean) {
        fetchSubject(subjectTypeStr, isRefresh)
    }

    private fun fetchSubject(subject: String, isRefresh: Boolean) {
        mModel.fetchSubject(subject)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                if (isRefresh) {
                    mRootView.refreshStatus(true)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .doFinally {
                mRootView.refreshStatus(false)
            }
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<MutableList<SubjectType>>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<MutableList<SubjectType>>) {
                    if (t.result == BaseEntity.RESULT_OK) {
                        subjectTypeList = t.data
                    } else {

                    }
                    mRootView.refreshView()
                }
            })
    }


}