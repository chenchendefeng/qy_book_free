package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.contranct.FaceToFaceContract
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-29.
 */
@ActivityScope
class FaceToFacePresenter
@Inject
constructor(model: FaceToFaceContract.Model, view: FaceToFaceContract.View) :
    QYBasePresenter<FaceToFaceContract.Model, FaceToFaceContract.View>(model, view) {



}