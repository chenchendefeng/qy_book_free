package com.wy.adbook.mvp.model

import com.wy.adbook.mvp.contranct.BookDetailContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetChapterList
import com.wy.adbook.mvp.model.entity.NetTogetherRead
import com.wy.adbook.mvp.model.entity.book.NetBook
import com.wy.adbook.mvp.model.entity.book.NetPutOn
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

    override fun getRm(): IRepositoryManager {
        return mRepositoryManager
    }

    override fun getChapterList(bid: Int): Observable<NetChapterList> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).listChapter(bid)
    }

    override fun putOn(uid: Int, bid: Int): Observable<NetPutOn> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).putOn(uid, bid)
    }

    override fun bookDetail(bid: Int): Observable<NetBook> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).bookDetail(bid)
    }

    override fun pageListTogetherRead(
        pageNo: Int,
        pageSize: Int,
        category: String
    ): Observable<NetTogetherRead> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .pageListTogetherRead(pageNo, pageSize, category)
    }
}