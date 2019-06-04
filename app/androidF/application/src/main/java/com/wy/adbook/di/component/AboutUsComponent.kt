package com.wy.adbook.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.di.module.AboutUsModule
import com.wy.adbook.mvp.view.activity.AboutUsActivity
import dagger.Component

/**
 * Created by leafye on 2019-05-29.
 */
@ActivityScope
@Component(modules = [AboutUsModule::class], dependencies = [AppComponent::class])
interface AboutUsComponent {
    fun inject(inject: AboutUsActivity)
}