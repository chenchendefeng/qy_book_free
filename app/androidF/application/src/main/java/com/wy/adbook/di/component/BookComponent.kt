package com.wy.adbook.di.component

import com.wy.adbook.di.module.BookModule
import com.wy.adbook.mvp.view.fragment.BookFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import dagger.Component

/**
 * Created by leafye on 2019/5/5.
 */
@FragmentScope
@Component(modules = [BookModule::class], dependencies = [AppComponent::class])
interface BookComponent {
    fun inject(inject: BookFragment)
}