package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.NetPageListByBookClass
import com.wy.adbook.mvp.view.adapter.ClassificationDetailBookAdapter
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
        ): Observable<NetPageListByBookClass>

    }

}