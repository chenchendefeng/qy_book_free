package com.wy.adbook.mvp.presenter

import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.contranct.RemoveAdSuccessContract
import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-27.
 */
@ActivityScope
class RemoveAdSuccessPresenter
@Inject
constructor(model: RemoveAdSuccessContract.Model, view: RemoveAdSuccessContract.View) :
    QYBasePresenter<RemoveAdSuccessContract.Model, RemoveAdSuccessContract.View>(model, view) {



}