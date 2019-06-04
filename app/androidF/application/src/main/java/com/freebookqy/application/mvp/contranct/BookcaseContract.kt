package com.freebookqy.application.mvp.contranct

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYModel
import com.freebookqy.application.app.base.QYView
import com.freebookqy.application.mvp.main.bookcase.adapter.BookcaseAdapter
import com.freebookqy.application.mvp.model.entity.Bookcase
import com.freebookqy.application.mvp.model.entity.book.Remove
import io.reactivex.Observable

/**
 * Created by leafye on 2019/4/30.
 */
interface BookcaseContract {

    interface View : QYView {
        fun refreshVIew()

        fun refreshStatus(isRefresh: Boolean)

        fun loadMoreStatus(status: Int)

        fun getAdapter(): BookcaseAdapter
    }

    interface Model : QYModel {

        fun fetchBookcase(
            pageNo: Int,
            pageSize: Int,
            uid: Int
        ): Observable<BaseEntity<Bookcase>>

        fun newBookNumPerWeek(): Observable<BaseEntity<Int>>

        fun removeBook(
            uid: Int,
            bid: Int
        ): Observable<BaseEntity<Remove>>
    }

}