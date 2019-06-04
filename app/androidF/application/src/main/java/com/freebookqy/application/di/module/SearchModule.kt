package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.contranct.SearchContract
import com.freebookqy.application.mvp.main.search.SearchModel
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