package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.book.detail.BookDetailModel
import com.freebookqy.application.mvp.contranct.BookDetailContract
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/5/7.
 */
@Module
class BookDetailModule(private val view: BookDetailContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): BookDetailContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: BookDetailModel): BookDetailContract.Model {
        return model
    }


}