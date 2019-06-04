package com.wy.adbook.di.module

import com.wy.adbook.mvp.model.ReadModel
import com.wy.adbook.mvp.contranct.ReadContract
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/5/7.
 */
@Module
class ReadModule(private val view: ReadContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): ReadContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: ReadModel): ReadContract.Model {
        return model
    }


}