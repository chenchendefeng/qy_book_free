package com.wy.adbook.di.module

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.mvp.contranct.SettingContract
import com.wy.adbook.mvp.model.SettingModel
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-29.
 */
@Module
class SettingModule(private val view: SettingContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): SettingContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: SettingModel): SettingContract.Model {
        return model
    }


}