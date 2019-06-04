package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.BookDetailModule
import com.freebookqy.application.mvp.book.detail.BookDetailActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/5/7.
 */
@ActivityScope
@Component(modules = [BookDetailModule::class], dependencies = [AppComponent::class])
interface BookDetailComponent {
    fun inject(inject: BookDetailActivity)
}