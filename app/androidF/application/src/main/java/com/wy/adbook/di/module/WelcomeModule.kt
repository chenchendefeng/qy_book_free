package com.wy.adbook.di.module

import com.wy.adbook.dialog.WarningDialog
import com.wy.adbook.mvp.model.WelcomeModel
import com.wy.adbook.mvp.contranct.IWelcomeContract
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
