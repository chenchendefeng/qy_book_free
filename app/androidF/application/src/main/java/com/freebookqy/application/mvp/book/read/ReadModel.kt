package com.freebookqy.application.mvp.book.read

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.mvp.contranct.ReadContract
import com.freebookqy.application.mvp.model.api.service.QYService
import com.freebookqy.application.mvp.model.entity.Chapter
import com.freebookqy.application.mvp.model.entity.book.Book
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/7.
 */
@ActivityScope
class ReadModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    ReadContract.Model {
    override fun chapterContent(bid: Int, cid: Int): Observable<BaseEntity<Chapter>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .chapterContent(bid,cid)
    }

    override fun bookDetail(bid: Int): Observable<BaseEntity<Book>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).bookDetail(bid)
    }

    override fun listChapter(bid: Int): Observable<BaseEntity<MutableList<Chapter>>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).listChapter(bid)
    }


}