package com.freebookqy.application.mvp.book.detail

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.mvp.contranct.BookDetailContract
import com.freebookqy.application.mvp.model.api.service.QYService
import com.freebookqy.application.mvp.model.entity.Chapter
import com.freebookqy.application.mvp.model.entity.TogetherRead
import com.freebookqy.application.mvp.model.entity.book.Book
import com.freebookqy.application.mvp.model.entity.book.PutOn
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/7.
 */
@ActivityScope
class BookDetailModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    BookDetailContract.Model {
    override fun getChapterList(bid: Int): Observable<BaseEntity<MutableList<Chapter>>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).listChapter(bid)
    }

    override fun putOn(uid: Int, bid: Int): Observable<BaseEntity<PutOn>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).putOn(uid, bid)
    }

    override fun bookDetail(bid: Int): Observable<BaseEntity<Book>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).bookDetail(bid)
    }

    override fun pageListTogetherRead(
        pageNo: Int,
        pageSize: Int,
        category: String
    ): Observable<BaseEntity<TogetherRead>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .pageListTogetherRead(pageNo, pageSize, category)
    }


}