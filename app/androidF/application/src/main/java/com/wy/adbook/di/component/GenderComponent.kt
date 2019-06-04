package com.wy.adbook.di.component

import com.wy.adbook.di.module.GenderModule
import com.wy.adbook.mvp.view.activity.GenderSelectActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/4/29.
 */
@ActivityScope
@Component(modules = [GenderModule::class], dependencies = [AppComponent::class])
interface GenderComponent {
    fun inject(activity: GenderSelectActivity)
}