package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.NetBookcase
import com.wy.adbook.mvp.model.entity.book.NetNewBookNumPerWeek
import com.wy.adbook.mvp.model.entity.book.NetRemove
import com.wy.adbook.mvp.view.adapter.BookcaseAdapter
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
        ): Observable<NetBookcase>

        fun newBookNumPerWeek(): Observable<NetNewBookNumPerWeek>

        fun removeBook(
            uid: Int,
            bid: Int
        ): Observable<NetRemove>
    }

}