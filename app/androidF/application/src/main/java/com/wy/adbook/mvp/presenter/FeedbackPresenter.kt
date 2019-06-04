package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.FragmentScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.contranct.FeedbackContract
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-29.
 */
@FragmentScope
class FeedbackPresenter
@Inject
constructor(model: FeedbackContract.Model, view: FeedbackContract.View) :
    QYBasePresenter<FeedbackContract.Model, FeedbackContract.View>(model, view) {



}