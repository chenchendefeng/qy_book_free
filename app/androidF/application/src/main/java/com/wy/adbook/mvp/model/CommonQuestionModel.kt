package com.wy.adbook.mvp.model

import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.wy.adbook.mvp.contranct.CommonQuestionContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetFaqList
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-28.
 */
@FragmentScope
class CommonQuestionModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    CommonQuestionContract.Model {
    override fun faqList(channle: String, page: Int, pageSize: Int): Observable<NetFaqList> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java).faqList(channle, page, pageSize)
    }


}