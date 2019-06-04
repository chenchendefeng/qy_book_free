package com.freebookqy.application.mvp.main.bookcase

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.mvp.contranct.BookcaseContract
import com.freebookqy.application.mvp.model.api.service.QYService
import com.freebookqy.application.mvp.model.entity.Bookcase
import com.freebookqy.application.mvp.model.entity.book.Remove
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */

@ActivityScope
class BookcaseModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    BookcaseContract.Model {

    override fun newBookNumPerWeek(): Observable<BaseEntity<Int>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).newBookNumPerWeek()
    }

    override fun removeBook(uid: Int, bid: Int): Observable<BaseEntity<Remove>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).remove(uid, bid)
    }

    override fun fetchBookcase(
        pageNo: Int,
        pageSize: Int,
        uid: Int
    ): Observable<BaseEntity<Bookcase>> {
        return mRepositoryManager
            .obtainRetrofitService(QYService::class.java)
            .pageList(pageNo = pageNo, pageSize = pageSize, uid = uid)
    }


}