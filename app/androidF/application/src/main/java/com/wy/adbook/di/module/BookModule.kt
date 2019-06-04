package com.wy.adbook.di.module

import com.wy.adbook.mvp.model.BookModel
import com.wy.adbook.mvp.contranct.BookContract
import com.jess.arms.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/5/5.
 */
@Module
class BookModule(private val view: BookContract.View) {
    @FragmentScope
    @Provides
    fun provideAboutView(): BookContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideAboutModel(model: BookModel): BookContract.Model {
        return model
    }


}