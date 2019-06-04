package com.wy.adbook.mvp.model

import com.wy.adbook.mvp.contranct.RemoveAdSuccessContract
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-27.
 */
@ActivityScope
class RemoveAdSuccessModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    RemoveAdSuccessContract.Model {



}