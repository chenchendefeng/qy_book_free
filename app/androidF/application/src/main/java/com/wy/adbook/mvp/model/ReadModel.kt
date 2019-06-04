package com.wy.adbook.mvp.model

import com.wy.adbook.mvp.contranct.ReadContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.book.NetBook
import com.wy.adbook.mvp.model.entity.book.NetPutOn
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.wy.adbook.mvp.model.entity.*
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
    override fun recordBook(uid: Int, bid: Int): Observable<NetReadFooterRecord> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).readFooterRecord(uid, bid)
    }

    override fun get30sWelfareRead(uid: Int): Observable<NetGet30sWelfareRead> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .get30sWelfareRead(uid)
    }

    override fun updateBookProgress(uid: Int, bid: Int, cid: Int, readCount: Int): Observable<NetBookProgress> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .updateBookProgress(uid, bid, cid, readCount)
    }

    override fun addToBookcase(uid: Int, bid: Int): Observable<NetPutOn> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .putOn(uid, bid)
    }

    override fun chapterContent(bid: Int, cid: Int): Observable<NetChapter> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .chapterContent(bid, cid)
    }

    override fun bookDetail(bid: Int): Observable<NetBook> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).bookDetail(bid)
    }

    override fun listChapter(bid: Int): Observable<NetChapterList> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).listChapter(bid)
    }


}