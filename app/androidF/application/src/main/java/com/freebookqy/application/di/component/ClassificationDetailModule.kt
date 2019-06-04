package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.ClassificationDetailModule
import com.freebookqy.application.mvp.classification.detail.ClassificationDetailActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/5/5.
 */
@ActivityScope
@Component(modules = [ClassificationDetailModule::class], dependencies = [AppComponent::class])
interface ClassificationDetailComponent {
    fun inject(inject:ClassificationDetailActivity)
}