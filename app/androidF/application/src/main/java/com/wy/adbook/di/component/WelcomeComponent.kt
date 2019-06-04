package com.wy.adbook.di.component

import com.wy.adbook.di.module.WelcomeModule
import com.wy.adbook.mvp.view.activity.WelcomeActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/4/29.
 */
@ActivityScope
@Component(modules = [WelcomeModule::class], dependencies = [AppComponent::class])
interface WelcomeComponent {
    fun inject(activity: WelcomeActivity)
}