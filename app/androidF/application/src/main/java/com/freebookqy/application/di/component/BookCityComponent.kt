package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.BookCityModule
import com.freebookqy.application.mvp.main.bookcity.BookCityFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/4/30.
 */
@ActivityScope
@Component(modules = [BookCityModule::class], dependencies = [AppComponent::class])
interface BookCityComponent {
    fun inject(fragment: BookCityFragment)
}