package com.wy.adbook.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.di.module.ReadFooterModule
import com.wy.adbook.mvp.view.activity.ReadFooterActivity
import dagger.Component

/**
 * Created by leafye on 2019-05-28.
 */
@ActivityScope
@Component(modules = [ReadFooterModule::class], dependencies = [AppComponent::class])
interface ReadFooterComponent {
    fun inject(inject: ReadFooterActivity)
}