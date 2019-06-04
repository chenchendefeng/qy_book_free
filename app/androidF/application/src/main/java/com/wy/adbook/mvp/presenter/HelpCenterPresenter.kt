package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.contranct.HelpCenterContract
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-29.
 */
@ActivityScope
class HelpCenterPresenter
@Inject
constructor(model: HelpCenterContract.Model, view: HelpCenterContract.View) :
    QYBasePresenter<HelpCenterContract.Model, HelpCenterContract.View>(model, view) {



}