package com.freebookqy.application.mvp.contranct

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYModel
import com.freebookqy.application.app.base.QYView
import com.freebookqy.application.mvp.classification.adapter.ClassificationDetailBookAdapter
import com.freebookqy.application.mvp.model.entity.PageListByBookClass
import io.reactivex.Observable

/**
 * Created by leafye on 2019/5/5.
 */
interface BookContract {

    interface View : QYView {
        fun refreshView()

        fun getAdapter(): ClassificationDetailBookAdapter
        fun startRefreshLayout(isRefresh: Boolean)
    }

    interface Model : QYModel {

        fun pageListByBookClass(
            pageNo: Int,
            pageSize: Int,
            finishFlag: Int,
            className: String
        ): Observable<BaseEntity<PageListByBookClass>>

    }

}