package com.freebookqy.application.mvp.contranct

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYModel
import com.freebookqy.application.app.base.QYView
import com.freebookqy.application.mvp.model.entity.Chapter
import com.freebookqy.application.mvp.model.entity.book.Book
import com.freebookqy.application.view.page.PageLoader
import io.reactivex.Observable

/**
 * Created by leafye on 2019/5/7.
 */
interface ReadContract {

    interface View : QYView {

        fun refreshChapter()

        fun finishChapters()

        fun initReadView()

        fun getReadPageLoader(): PageLoader?
    }

    interface Model : QYModel {

        fun listChapter(bid: Int): Observable<BaseEntity<MutableList<Chapter>>>

        fun bookDetail(bid: Int): Observable<BaseEntity<Book>>

        fun chapterContent(bid: Int, cid: Int): Observable<BaseEntity<Chapter>>

    }

}