package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.BookcaseModule
import com.freebookqy.application.mvp.main.bookcase.BookcaseFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/4/30.
 */
@ActivityScope
@Component(modules = [BookcaseModule::class], dependencies = [AppComponent::class])
interface BookcaseComponent {
    fun inject(fragment: BookcaseFragment)
}