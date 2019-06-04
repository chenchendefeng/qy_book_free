package com.wy.adbook.mvp.model

import com.wy.adbook.mvp.contranct.AdContract
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-16.
 */
@ActivityScope
class AdModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    AdContract.Model {


}