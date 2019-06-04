package com.freebookqy.application.mvp.main.my.sign

import com.freebookqy.application.mvp.contranct.SignCalenderContract
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-08.
 */
@ActivityScope
class SignCalenderModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    SignCalenderContract.Model {



}