package com.wy.adbook.di.module

import com.wy.adbook.mvp.view.web.act.WebContract
import com.wy.adbook.mvp.view.web.act.WebModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-23.
 */
@Module
class WebModule(private val view: WebContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): WebContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: WebModel): WebContract.Model {
        return model
    }

}