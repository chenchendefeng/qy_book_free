package com.freebookqy.application.mvp.main.search

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.mvp.contranct.SearchContract
import com.freebookqy.application.mvp.model.api.service.QYService
import com.freebookqy.application.mvp.model.entity.GuessYouLike
import com.freebookqy.application.mvp.model.entity.SearchResult
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/3.
 */
@ActivityScope
class SearchModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    SearchContract.Model {
    override fun search(key: String, pageNo: Int, pageSize: Int): Observable<BaseEntity<SearchResult>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).search(key, pageNo, pageSize)
    }

    override fun guessYouLike(pageNo: Int, pageSize: Int): Observable<BaseEntity<GuessYouLike>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .pageListGuessYouLike(pageNo, pageSize)
    }


}