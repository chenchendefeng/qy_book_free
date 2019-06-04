package com.wy.adbook.mvp.contranct

import android.widget.TextView
import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.*
import com.wy.adbook.mvp.model.entity.book.NetBook
import com.wy.adbook.mvp.model.entity.book.NetPutOn
import com.wy.adbook.view.page.PageLoader
import io.reactivex.Observable

/**
 * Created by leafye on 2019/5/7.
 */
interface ReadContract {

    interface View : QYView {

        fun refreshChapter()

        fun finishChapters()

        fun errorChapters()

        fun getReadPageLoader(): PageLoader?

        fun refreshProgressBar(progress: Float)

        fun getGoldTipTv(): TextView
    }

    interface Model : QYModel {

        fun listChapter(bid: Int): Observable<NetChapterList>

        fun bookDetail(bid: Int): Observable<NetBook>

        fun chapterContent(bid: Int, cid: Int): Observable<NetChapter>

        fun addToBookcase(uid: Int, bid: Int): Observable<NetPutOn>

        fun updateBookProgress(uid: Int, bid: Int, cid: Int, readCount: Int): Observable<NetBookProgress>

        fun get30sWelfareRead(uid: Int): Observable<NetGet30sWelfareRead>

        fun recordBook(uid: Int, bid: Int): Observable<NetReadFooterRecord>
    }

}