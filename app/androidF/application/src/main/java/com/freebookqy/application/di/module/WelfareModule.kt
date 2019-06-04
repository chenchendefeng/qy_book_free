package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.contranct.WelfareContract
import com.freebookqy.application.mvp.main.welfare.WelfareModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/4/30.
 */


@Module
class WelfareModule(private val view: WelfareContract.View) {

    @ActivityScope
    @Provides
    fun provideAboutView(): WelfareContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: WelfareModel): WelfareContract.Model {
        return model
    }

//    @ActivityScope
//    @Provides
//    internal fun provideWarningDialog() = WarningDialog()

}