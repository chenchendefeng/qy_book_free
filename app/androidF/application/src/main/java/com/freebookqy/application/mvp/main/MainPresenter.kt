package com.freebookqy.application.mvp.main

import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.mvp.contranct.MainContract
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