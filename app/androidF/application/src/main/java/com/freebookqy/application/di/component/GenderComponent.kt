package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.GenderModule
import com.freebookqy.application.mvp.gender.GenderSelectActivity
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