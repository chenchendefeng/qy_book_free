package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.contranct.BookcaseContract
import com.freebookqy.application.mvp.main.bookcase.BookcaseModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/4/30.
 */


@Module
class BookcaseModule(private val view: BookcaseContract.View) {

    @ActivityScope
    @Provides
    fun provideAboutView(): BookcaseContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: BookcaseModel): BookcaseContract.Model {
        return model
    }

//    @ActivityScope
//    @Provides
//    internal fun provideWarningDialog() = WarningDialog()

}