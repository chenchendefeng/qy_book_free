package com.wy.adbook.di.module

import android.support.v7.widget.LinearLayoutManager
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.mvp.contranct.ReadFooterContract
import com.wy.adbook.mvp.model.ReadFooterModel
import com.wy.adbook.mvp.model.entity.ReadFooterItem
import com.wy.adbook.mvp.view.adapter.ReadFooterAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-28.
 */
@Module
class ReadFooterModule(private val view: ReadFooterContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): ReadFooterContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: ReadFooterModel): ReadFooterContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    fun provideLinearLayout() = LinearLayoutManager(view.getContext())

    @ActivityScope
    @Provides
    fun provideReadFooterAdapter(list: MutableList<ReadFooterItem>) = ReadFooterAdapter(list)

    @ActivityScope
    @Provides
    fun provideReadFooterItemList() = mutableListOf<ReadFooterItem>()


}