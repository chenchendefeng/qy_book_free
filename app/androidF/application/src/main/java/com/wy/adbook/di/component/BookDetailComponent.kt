package com.wy.adbook.di.component

import com.wy.adbook.di.module.BookDetailModule
import com.wy.adbook.mvp.view.activity.BookDetailActivity
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