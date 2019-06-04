package com.freebookqy.application.mvp.main.my.wallet

import com.freebookqy.application.mvp.contranct.MyWalletContract
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/6.
 */
@ActivityScope
class MyWalletModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    MyWalletContract.Model {



}