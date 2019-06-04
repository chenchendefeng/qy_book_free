package com.wy.adbook.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.di.module.BasicInfoModule
import com.wy.adbook.mvp.view.activity.BasicInfoActivity
import dagger.Component

/**
 * Created by leafye on 2019-05-30.
 */
@ActivityScope
@Component(modules = [BasicInfoModule::class], dependencies = [AppComponent::class])
interface BasicInfoComponent {
    fun inject(inject: BasicInfoActivity)
}