package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.NetGuessYouLike
import com.wy.adbook.mvp.model.entity.NetSearchResult
import com.wy.adbook.mvp.view.adapter.SearchAdapter
import io.reactivex.Observable

/**
 * Created by leafye on 2019/5/3.
 */
interface SearchContract {

    interface View : QYView {

        fun refreshView()

        fun loadStatus(loadMoreStatus: Int)

        fun searchAdapter(): SearchAdapter

    }

    interface Model : QYModel {
        fun guessYouLike(pageNo: Int, pageSize: Int): Observable<NetGuessYouLike>

        fun search(key: String, pageNo: Int, pageSize: Int): Observable<NetSearchResult>
    }

}