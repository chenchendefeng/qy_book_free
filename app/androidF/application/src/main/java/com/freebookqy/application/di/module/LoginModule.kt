package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.account.Login.LoginModel
import com.freebookqy.application.mvp.contranct.LoginContract
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-08.
 */
@Module
class LoginModule(private val view: LoginContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): LoginContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: LoginModel): LoginContract.Model {
        return model
    }


}