package com.wy.adbook.di.module

import android.support.v7.widget.LinearLayoutManager
import com.jess.arms.di.scope.FragmentScope
import com.wy.adbook.mvp.contranct.MyContract
import com.wy.adbook.mvp.model.MyModel
import com.wy.adbook.mvp.view.adapter.MyAdapter
import com.wy.adbook.mvp.view.adapter.MyItem
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/4/29.
 */
@Module
class MyModule(private val view: MyContract.View) {
    @FragmentScope
    @Provides
    fun provideAboutView(): MyContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideAboutModel(model: MyModel): MyContract.Model {
        return model
    }

    @FragmentScope
    @Provides
    fun lm() = LinearLayoutManager(view.getContext())

    @FragmentScope
    @Provides
    fun myItemList() = mutableListOf<MyItem>()

    @FragmentScope
    @Provides
    fun myAdapter(list: MutableList<MyItem>) = MyAdapter(list)

}
