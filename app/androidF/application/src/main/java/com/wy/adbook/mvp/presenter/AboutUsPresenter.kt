package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.contranct.AboutUsContract
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-29.
 */
@ActivityScope
class AboutUsPresenter
@Inject
constructor(model: AboutUsContract.Model, view: AboutUsContract.View) :
    QYBasePresenter<AboutUsContract.Model, AboutUsContract.View>(model, view) {



}