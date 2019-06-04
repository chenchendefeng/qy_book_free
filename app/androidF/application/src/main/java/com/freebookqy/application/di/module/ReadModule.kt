package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.book.read.ReadModel
import com.freebookqy.application.mvp.contranct.ReadContract
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