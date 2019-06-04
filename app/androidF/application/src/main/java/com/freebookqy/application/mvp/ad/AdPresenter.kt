package com.freebookqy.application.mvp.ad

import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.mvp.contranct.AdContract
import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-16.
 */
@ActivityScope
class AdPresenter
@Inject
constructor(model: AdContract.Model, view: AdContract.View) :
    QYBasePresenter<AdContract.Model, AdContract.View>(model, view) {



}