package com.wy.adbook.mvp.presenter

import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.contranct.MainContract
import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/29.
 */
@ActivityScope
class MainPresenter
@Inject
constructor(model: MainContract.Model, view: MainContract.View) :
    QYBasePresenter<MainContract.Model, MainContract.View>(model, view) {




}