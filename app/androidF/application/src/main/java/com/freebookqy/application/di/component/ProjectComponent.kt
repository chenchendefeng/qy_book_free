package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.ProjectModule
import com.freebookqy.application.mvp.main.project.ProjectFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/5/1.
 */
@ActivityScope
@Component(modules = [ProjectModule::class], dependencies = [AppComponent::class])
interface ProjectComponent {
    fun inject(inject: ProjectFragment)
}