package com.wy.adbook.mvp.view.web.frag

import com.wy.adbook.app.base.QYBasePresenter
import com.jess.arms.di.scope.FragmentScope
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-23.
 */
@FragmentScope
class QYWebPresenter
@Inject
constructor(model: QYWebContract.Model, view: QYWebContract.View) :
    QYBasePresenter<QYWebContract.Model, QYWebContract.View>(model, view) {



}