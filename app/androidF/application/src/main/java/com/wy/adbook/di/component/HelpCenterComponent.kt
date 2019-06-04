package com.wy.adbook.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.di.module.HelpCenterModule
import com.wy.adbook.mvp.view.activity.HelpCenterActivity
import dagger.Component

/**
 * Created by leafye on 2019-05-29.
 */
@ActivityScope
@Component(modules = [HelpCenterModule::class], dependencies = [AppComponent::class])
interface HelpCenterComponent {
    fun inject(inject: HelpCenterActivity)
}