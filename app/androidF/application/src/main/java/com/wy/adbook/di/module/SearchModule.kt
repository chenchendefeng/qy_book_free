package com.wy.adbook.di.module

import com.wy.adbook.mvp.contranct.SearchContract
import com.wy.adbook.mvp.model.SearchModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/5/3.
 */
@Module
class SearchModule(private val view: SearchContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): SearchContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: SearchModel): SearchContract.Model {
        return model
    }


}