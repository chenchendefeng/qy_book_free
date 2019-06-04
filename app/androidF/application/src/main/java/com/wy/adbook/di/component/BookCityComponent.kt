package com.wy.adbook.di.component

import com.wy.adbook.di.module.BookCityModule
import com.wy.adbook.mvp.view.fragment.BookCityFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import dagger.Component

/**
 * Created by leafye on 2019/4/30.
 */
@FragmentScope
@Component(modules = [BookCityModule::class], dependencies = [AppComponent::class])
interface BookCityComponent {
    fun inject(fragment: BookCityFragment)
}