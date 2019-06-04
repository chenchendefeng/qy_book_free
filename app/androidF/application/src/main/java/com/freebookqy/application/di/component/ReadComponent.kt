package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.ReadModule
import com.freebookqy.application.mvp.book.read.ReadActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/5/7.
 */
@ActivityScope
@Component(modules = [ReadModule::class], dependencies = [AppComponent::class])
interface ReadComponent {
    fun inject(inject: ReadActivity)
}