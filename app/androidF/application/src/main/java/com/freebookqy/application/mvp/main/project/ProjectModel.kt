package com.freebookqy.application.mvp.main.project

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.mvp.contranct.ProjectContract
import com.freebookqy.application.mvp.model.api.service.QYService
import com.freebookqy.application.mvp.model.entity.SubjectType
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/29.
 */

@ActivityScope
class ProjectModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    ProjectContract.Model {

    override fun fetchSubject(subject:String): Observable<BaseEntity<MutableList<SubjectType>>> {
        //获取本地存储的男女类型
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .listBySubjectType(subject,"boy")
    }

}