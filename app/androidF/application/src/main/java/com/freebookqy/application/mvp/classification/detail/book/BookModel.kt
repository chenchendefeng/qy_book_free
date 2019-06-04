package com.freebookqy.application.mvp.classification.detail.book

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.mvp.contranct.BookContract
import com.freebookqy.application.mvp.model.api.service.QYService
import com.freebookqy.application.mvp.model.entity.PageListByBookClass
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/5.
 */
@ActivityScope
class BookModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    BookContract.Model {
    override fun pageListByBookClass(
        pageNo: Int,
        pageSize: Int,
        finishFlag: Int,
        className: String
    ): Observable<BaseEntity<PageListByBookClass>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .pageListByBookClass(pageNo, pageSize, finishFlag, className)
    }


}