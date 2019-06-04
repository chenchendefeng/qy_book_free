package com.wy.adbook.di.component

import com.wy.adbook.di.module.BookcaseModule
import com.wy.adbook.mvp.view.fragment.BookcaseFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import dagger.Component

/**
 * Created by leafye on 2019/4/30.
 */
@FragmentScope
@Component(modules = [BookcaseModule::class], dependencies = [AppComponent::class])
interface BookcaseComponent {
    fun inject(fragment: BookcaseFragment)
}