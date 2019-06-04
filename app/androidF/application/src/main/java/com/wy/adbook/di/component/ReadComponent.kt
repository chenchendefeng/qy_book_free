package com.wy.adbook.di.component

import com.wy.adbook.di.module.ReadModule
import com.wy.adbook.mvp.view.activity.ReadActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/5/7.
 */
@ActivityScope
@Component(modules = [ReadModule::class], dependencies = [AppComponent::class])
interface ReadComponent {
    fun inject(inject: ReadActivity)
}