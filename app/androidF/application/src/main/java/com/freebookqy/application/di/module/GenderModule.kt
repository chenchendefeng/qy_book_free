package com.freebookqy.application.di.module

import com.freebookqy.application.dialog.WarningDialog
import com.freebookqy.application.mvp.contranct.GenderContract
import com.freebookqy.application.mvp.gender.GenderModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/4/29.
 */
@Module
class GenderModule(private val view: GenderContract.View) {

    @ActivityScope
    @Provides
    fun provideAboutView(): GenderContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: GenderModel): GenderContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    internal fun provideWarningDialog() = WarningDialog()

}