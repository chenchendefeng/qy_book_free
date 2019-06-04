package com.wy.adbook.mvp.model

import com.wy.adbook.mvp.contranct.BookcaseContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetBookcase
import com.wy.adbook.mvp.model.entity.book.NetNewBookNumPerWeek
import com.wy.adbook.mvp.model.entity.book.NetRemove
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */

@FragmentScope
class BookcaseModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    BookcaseContract.Model {

    override fun newBookNumPerWeek(): Observable<NetNewBookNumPerWeek> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).newBookNumPerWeek()
    }

    override fun removeBook(uid: Int, bid: Int): Observable<NetRemove> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).remove(uid, bid)
    }

    override fun fetchBookcase(
        pageNo: Int,
        pageSize: Int,
        uid: Int
    ): Observable<NetBookcase> {
        return mRepositoryManager
            .obtainRetrofitService(QYService::class.java)
            .pageList(pageNo = pageNo, pageSize = pageSize, uid = uid)
    }


}