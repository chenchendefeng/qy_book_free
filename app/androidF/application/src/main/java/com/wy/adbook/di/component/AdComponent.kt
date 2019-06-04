package com.wy.adbook.di.component

import com.wy.adbook.di.module.AdModule
import com.wy.adbook.mvp.view.activity.AdActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019-05-16.
 */
@ActivityScope
@Component(modules = [AdModule::class], dependencies = [AppComponent::class])
interface AdComponent {
    fun inject(inject: AdActivity)
}