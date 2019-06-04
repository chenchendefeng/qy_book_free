package com.wy.adbook.di.module

import android.support.v7.widget.LinearLayoutManager
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.mvp.contranct.MyFriendContract
import com.wy.adbook.mvp.model.MyFriendModel
import com.wy.adbook.mvp.model.entity.FriendItem
import com.wy.adbook.mvp.view.adapter.MyFriendAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-29.
 */
@Module
class MyFriendModule(private val view: MyFriendContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): MyFriendContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: MyFriendModel): MyFriendContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    fun linearLayoutManager() = LinearLayoutManager(view.getContext())

    @ActivityScope
    @Provides
    fun friendList() = mutableListOf<FriendItem>()

    @ActivityScope
    @Provides
    fun provideMyFriendAdapter(list: MutableList<FriendItem>) = MyFriendAdapter(list)


}