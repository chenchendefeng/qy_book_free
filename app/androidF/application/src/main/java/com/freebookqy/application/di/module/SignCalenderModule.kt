package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.contranct.SignCalenderContract
import com.freebookqy.application.mvp.main.my.sign.SignCalenderModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-08.
 */
@Module
class SignCalenderModule(private val view: SignCalenderContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): SignCalenderContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: SignCalenderModel): SignCalenderContract.Model {
        return model
    }


}