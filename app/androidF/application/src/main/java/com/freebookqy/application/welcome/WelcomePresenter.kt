package com.freebookqy.application.welcome

import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/29.
 */
@ActivityScope
class WelcomePresenter
@Inject
constructor(
    model: IWelcomeContract.Model,
    rootView: IWelcomeContract.View
) : BasePresenter<IWelcomeContract.Model, IWelcomeContract.View>(model, rootView) {

}