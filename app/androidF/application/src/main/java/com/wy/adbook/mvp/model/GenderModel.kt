package com.wy.adbook.mvp.model

import com.wy.adbook.app.base.BaseEntity
import com.wy.adbook.mvp.contranct.GenderContract
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.SetGender
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/29.
 */
@ActivityScope
class GenderModel
@Inject constructor(rm: IRepositoryManager)
    :BaseModel(rm), GenderContract.Model{

    override fun setGender(gender: Int): Observable<BaseEntity<SetGender>> {
        return mRepositoryManager.obtainRetrofitService(QYService::class.java)
            .setGender()
    }
}