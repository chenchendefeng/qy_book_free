package com.wy.adbook.mvp.model

import com.wy.adbook.mvp.contranct.BookContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetPageListByBookClass
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/5.
 */
@FragmentScope
class BookModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    BookContract.Model {
    override fun pageListByBookClass(
        pageNo: Int,
        pageSize: Int,
        finishFlag: Int,
        className: String
    ): Observable<NetPageListByBookClass> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .pageListByBookClass(pageNo, pageSize, finishFlag, className)
    }


}