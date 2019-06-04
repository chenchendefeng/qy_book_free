package com.freebookqy.application.mvp.gender

import com.freebookqy.application.app.QYAccount
import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.mvp.contranct.GenderContract
import com.freebookqy.application.mvp.main.MainActivity
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