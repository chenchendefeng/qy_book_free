package com.wy.adbook.di.component

import com.wy.adbook.di.module.ProjectModule
import com.wy.adbook.mvp.view.fragment.ProjectFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import dagger.Component

/**
 * Created by leafye on 2019/5/1.
 */
@FragmentScope
@Component(modules = [ProjectModule::class], dependencies = [AppComponent::class])
interface ProjectComponent {
    fun inject(inject: ProjectFragment)
}