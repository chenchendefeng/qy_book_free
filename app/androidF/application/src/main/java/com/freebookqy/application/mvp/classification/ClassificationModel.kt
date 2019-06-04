package com.freebookqy.application.mvp.classification

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.mvp.contranct.ClassificationContract
import com.freebookqy.application.mvp.model.api.service.QYService
import com.freebookqy.application.mvp.model.entity.Classification
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/5.
 */
@ActivityScope
class ClassificationModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    ClassificationContract.Model {
    override fun categoryData(
        pageNo: Int,
        pageSize: Int,
        sexType: String
    ): Observable<BaseEntity<Classification>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .pageListBySexType(pageNo, pageSize, sexType)
    }


}