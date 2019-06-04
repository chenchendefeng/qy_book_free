package com.wy.adbook.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.di.module.SettingModule
import com.wy.adbook.mvp.view.activity.SettingActivity
import dagger.Component

/**
 * Created by leafye on 2019-05-29.
 */
@ActivityScope
@Component(modules = [SettingModule::class], dependencies = [AppComponent::class])
interface SettingComponent {
    fun inject(inject: SettingActivity)
}