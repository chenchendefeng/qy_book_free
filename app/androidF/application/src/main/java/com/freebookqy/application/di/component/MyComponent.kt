package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.MyModule
import com.freebookqy.application.mvp.main.my.MyFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/4/30.
 */

@ActivityScope
@Component(modules = [MyModule::class], dependencies = [AppComponent::class])
interface MyComponent {
    fun inject(fragment: MyFragment)
}