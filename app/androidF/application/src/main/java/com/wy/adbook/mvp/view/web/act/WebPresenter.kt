package com.wy.adbook.mvp.view.web.act

import com.wy.adbook.app.base.QYBasePresenter
import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-23.
 */
@ActivityScope
class WebPresenter
@Inject
constructor(model: WebContract.Model, view: WebContract.View) :
    QYBasePresenter<WebContract.Model, WebContract.View>(model, view) {



}