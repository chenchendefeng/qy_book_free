package com.wy.adbook.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.di.module.MyFriendModule
import com.wy.adbook.mvp.view.activity.MyFriendActivity
import dagger.Component

/**
 * Created by leafye on 2019-05-29.
 */
@ActivityScope
@Component(modules = [MyFriendModule::class], dependencies = [AppComponent::class])
interface MyFriendComponent {
    fun inject(inject: MyFriendActivity)
}