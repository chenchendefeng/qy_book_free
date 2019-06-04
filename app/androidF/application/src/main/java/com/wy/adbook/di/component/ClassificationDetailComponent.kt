package com.wy.adbook.di.component

import com.wy.adbook.di.module.ClassificationDetailModule
import com.wy.adbook.mvp.view.activity.ClassificationDetailActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/5/5.
 */
@ActivityScope
@Component(modules = [ClassificationDetailModule::class], dependencies = [AppComponent::class])
interface ClassificationDetailComponent {
    fun inject(inject: ClassificationDetailActivity)
}