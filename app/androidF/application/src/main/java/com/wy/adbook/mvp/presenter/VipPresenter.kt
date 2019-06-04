package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.contranct.VipContract
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-28.
 */
@ActivityScope
class VipPresenter
@Inject
constructor(model: VipContract.Model, view: VipContract.View) :
    QYBasePresenter<VipContract.Model, VipContract.View>(model, view) {



}