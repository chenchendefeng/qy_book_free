package com.freebookqy.application.mvp.contranct

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYModel
import com.freebookqy.application.app.base.QYView
import com.freebookqy.application.mvp.classification.adapter.ClassificationContentAdapter
import com.freebookqy.application.mvp.model.entity.Classification
import io.reactivex.Observable

/**
 * Created by leafye on 2019/5/5.
 */
interface ClassificationContract {

    interface View : QYView {
        fun refreshView()

        fun getAdapter(): ClassificationContentAdapter

        fun isRefresh(isRefresh:Boolean)
    }

    interface Model : QYModel {

        fun categoryData(
            pageNo: Int,
            pageSize: Int,
            sexType: String
        ): Observable<BaseEntity<Classification>>
    }

}
