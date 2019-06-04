package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.BookModule
import com.freebookqy.application.mvp.classification.detail.book.BookFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/5/5.
 */
@ActivityScope
@Component(modules = [BookModule::class], dependencies = [AppComponent::class])
interface BookComponent {
    fun inject(inject:BookFragment)
}