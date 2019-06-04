package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.SearchModule
import com.freebookqy.application.mvp.main.search.SearchActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/5/3.
 */
@ActivityScope
@Component(modules = [SearchModule::class], dependencies = [AppComponent::class])
interface SearchComponent {
    fun inject(inject:SearchActivity)
}