package com.wy.adbook.di.component

import com.wy.adbook.di.module.SignCalenderModule
import com.wy.adbook.mvp.view.activity.SignCalenderActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019-05-08.
 */
@ActivityScope
@Component(modules = [SignCalenderModule::class], dependencies = [AppComponent::class])
interface SignCalenderComponent {
    fun inject(inject: SignCalenderActivity)
}