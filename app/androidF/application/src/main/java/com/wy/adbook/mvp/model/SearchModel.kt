package com.wy.adbook.mvp.model

import com.wy.adbook.mvp.contranct.SearchContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetGuessYouLike
import com.wy.adbook.mvp.model.entity.NetSearchResult
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
    override fun search(key: String, pageNo: Int, pageSize: Int): Observable<NetSearchResult> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).search(key, pageNo, pageSize)
    }

    override fun guessYouLike(pageNo: Int, pageSize: Int): Observable<NetGuessYouLike> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .pageListGuessYouLike(pageNo, pageSize)
    }


}