package com.freebookqy.application.mvp.contranct

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYModel
import com.freebookqy.application.app.base.QYView
import com.freebookqy.application.mvp.model.entity.book.Book
import io.reactivex.Observable

/**
 * Created by leafye on 2019/5/5.
 */
interface ClassificationDetailContract {

    interface View : QYView{
        fun refreshView()
    }

    interface Model : QYModel {
        fun categoryBookList(): Observable<BaseEntity<MutableList<Book>>>
    }

}