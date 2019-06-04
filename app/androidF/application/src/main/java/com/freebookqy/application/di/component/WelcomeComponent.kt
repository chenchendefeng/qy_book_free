package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.WelcomeModule
import com.freebookqy.application.mvp.welcome.WelcomeActivity
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