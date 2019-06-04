package com.wy.adbook.di.component

import com.wy.adbook.di.module.ClassificationModule
import com.wy.adbook.mvp.view.activity.ClassificationActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/5/5.
 */
@ActivityScope
@Component(modules = [ClassificationModule::class], dependencies = [AppComponent::class])
interface ClassificationComponent {
    fun inject(inject: ClassificationActivity)
}