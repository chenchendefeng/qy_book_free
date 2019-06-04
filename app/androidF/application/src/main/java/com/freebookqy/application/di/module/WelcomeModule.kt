package com.freebookqy.application.di.module

import com.freebookqy.application.dialog.WarningDialog
import com.freebookqy.application.mvp.welcome.WelcomeModel
import com.freebookqy.application.mvp.contranct.IWelcomeContract
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/4/29.
 */
@Module
class WelcomeModule(private val view: IWelcomeContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): IWelcomeContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: WelcomeModel): IWelcomeContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    internal fun provideWarningDialog() = WarningDialog()
}
