package com.wy.adbook.di.module

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.mvp.contranct.AboutUsContract
import com.wy.adbook.mvp.model.AboutUsModel
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-29.
 */
@Module
class AboutUsModule(private val view: AboutUsContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): AboutUsContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: AboutUsModel): AboutUsContract.Model {
        return model
    }


}