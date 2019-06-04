package com.wy.adbook.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.di.module.VipModule
import com.wy.adbook.mvp.view.activity.VipActivity
import dagger.Component

/**
 * Created by leafye on 2019-05-28.
 */
@ActivityScope
@Component(modules = [VipModule::class], dependencies = [AppComponent::class])
interface VipComponent {
    fun inject(inject: VipActivity)
}