package com.freebookqy.application.di.module

import com.freebookqy.application.dialog.WarningDialog
import com.freebookqy.application.mvp.contranct.MainContract
import com.freebookqy.application.mvp.main.MainModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/4/29.
 */

@Module
class MainModule(private val view: MainContract.View) {

    @ActivityScope
    @Provides
    fun provideAboutView(): MainContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: MainModel): MainContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    internal fun provideWarningDialog() = WarningDialog()

}