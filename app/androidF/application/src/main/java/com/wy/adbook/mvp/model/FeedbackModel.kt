package com.wy.adbook.mvp.model

import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.wy.adbook.mvp.contranct.FeedbackContract
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-29.
 */
@FragmentScope
class FeedbackModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    FeedbackContract.Model {



}