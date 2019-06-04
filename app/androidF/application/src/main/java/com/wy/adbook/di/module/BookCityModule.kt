package com.wy.adbook.di.module

import com.wy.adbook.mvp.contranct.BookCityContract
import com.wy.adbook.mvp.model.BookCityModel
import com.jess.arms.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/4/30.
 */


@Module
class BookCityModule(private val view: BookCityContract.View) {

    @FragmentScope
    @Provides
    fun provideAboutView(): BookCityContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideAboutModel(model: BookCityModel): BookCityContract.Model {
        return model
    }

//    @ActivityScope
//    @Provides
//    internal fun provideWarningDialog() = WarningDialog()

}