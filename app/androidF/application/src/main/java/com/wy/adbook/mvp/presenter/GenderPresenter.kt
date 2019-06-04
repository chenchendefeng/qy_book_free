package com.wy.adbook.mvp.presenter

import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.contranct.GenderContract
import com.wy.adbook.mvp.view.activity.MainActivity
import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/29.
 */
@ActivityScope
class GenderPresenter
@Inject
constructor(model: GenderContract.Model, view: GenderContract.View) :
    QYBasePresenter<GenderContract.Model, GenderContract.View>(model, view) {

    //选择男女 并提交给后台
    fun selectGender() {
        QYAccount.setGender(mRootView.getGender())
        MainActivity.startActivity(mRootView.getContext())
        mRootView.finish()
    }

    fun skip() {
        MainActivity.startActivity(mRootView.getContext())
        mRootView.finish()
    }


}