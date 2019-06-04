package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.contranct.BookCityContract
import com.freebookqy.application.mvp.main.bookcity.BookCityModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/4/30.
 */


@Module
class BookCityModule(private val view: BookCityContract.View) {

    @ActivityScope
    @Provides
    fun provideAboutView(): BookCityContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: BookCityModel): BookCityContract.Model {
        return model
    }

//    @ActivityScope
//    @Provides
//    internal fun provideWarningDialog() = WarningDialog()

}