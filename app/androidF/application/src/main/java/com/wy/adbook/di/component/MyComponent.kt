package com.wy.adbook.di.component

import com.wy.adbook.di.module.MyModule
import com.wy.adbook.mvp.view.fragment.MyFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import dagger.Component

/**
 * Created by leafye on 2019/4/30.
 */

@FragmentScope
@Component(modules = [MyModule::class], dependencies = [AppComponent::class])
interface MyComponent {
    fun inject(fragment: MyFragment)
}