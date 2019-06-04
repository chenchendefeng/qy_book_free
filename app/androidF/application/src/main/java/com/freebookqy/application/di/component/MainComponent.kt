package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.MainModule
import com.freebookqy.application.mvp.main.MainActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/4/29.
 */

@ActivityScope
@Component(modules = [MainModule::class], dependencies = [AppComponent::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}