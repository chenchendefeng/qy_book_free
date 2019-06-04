package com.freebookqy.application.mvp.contranct

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYModel
import com.freebookqy.application.app.base.QYView
import com.freebookqy.application.mvp.main.search.adapter.SearchAdapter
import com.freebookqy.application.mvp.model.entity.GuessYouLike
import com.freebookqy.application.mvp.model.entity.SearchResult
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
        fun guessYouLike(pageNo: Int, pageSize: Int): Observable<BaseEntity<GuessYouLike>>

        fun search(key: String, pageNo: Int, pageSize: Int): Observable<BaseEntity<SearchResult>>
    }

}