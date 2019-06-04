package com.wy.adbook.di.module

import com.wy.adbook.dialog.WarningDialog
import com.wy.adbook.mvp.contranct.MainContract
import com.wy.adbook.mvp.model.MainModel
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