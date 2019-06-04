package com.wy.adbook.di.module

import com.wy.adbook.mvp.contranct.BookcaseContract
import com.wy.adbook.mvp.model.BookcaseModel
import com.jess.arms.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/4/30.
 */


@Module
class BookcaseModule(private val view: BookcaseContract.View) {

    @FragmentScope
    @Provides
    fun provideAboutView(): BookcaseContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideAboutModel(model: BookcaseModel): BookcaseContract.Model {
        return model
    }

//    @ActivityScope
//    @Provides
//    internal fun provideWarningDialog() = WarningDialog()

}