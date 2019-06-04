package com.wy.adbook.di.module

import com.wy.adbook.mvp.model.AdModel
import com.wy.adbook.mvp.contranct.AdContract
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-16.
 */
@Module
class AdModule(private val view: AdContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): AdContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: AdModel): AdContract.Model {
        return model
    }


}