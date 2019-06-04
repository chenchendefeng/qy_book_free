package com.freebookqy.application.mvp.model

import com.freebookqy.application.welcome.IWelcomeContract
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/29.
 */
@ActivityScope
class WelcomeModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    IWelcomeContract.Model {

    //Gson


}