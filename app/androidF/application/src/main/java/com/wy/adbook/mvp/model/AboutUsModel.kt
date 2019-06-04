package com.wy.adbook.mvp.model

import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.wy.adbook.mvp.contranct.AboutUsContract
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-29.
 */
@ActivityScope
class AboutUsModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    AboutUsContract.Model {



}