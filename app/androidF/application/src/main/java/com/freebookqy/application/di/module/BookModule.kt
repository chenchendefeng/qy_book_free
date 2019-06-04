package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.classification.detail.book.BookModel
import com.freebookqy.application.mvp.contranct.BookContract
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/5/5.
 */
@Module
class BookModule(private val view: BookContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): BookContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: BookModel): BookContract.Model {
        return model
    }


}