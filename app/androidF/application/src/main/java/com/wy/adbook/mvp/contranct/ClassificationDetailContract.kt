package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.BaseEntity
import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.book.Book
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