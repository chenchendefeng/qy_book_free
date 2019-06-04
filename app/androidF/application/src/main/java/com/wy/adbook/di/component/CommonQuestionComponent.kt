package com.wy.adbook.di.component

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import com.wy.adbook.di.module.CommonQuestionModule
import com.wy.adbook.mvp.view.fragment.CommonQuestionFragment
import dagger.Component

/**
 * Created by leafye on 2019-05-28.
 */
@FragmentScope
@Component(modules = [CommonQuestionModule::class], dependencies = [AppComponent::class])
interface CommonQuestionComponent {
    fun inject(inject:CommonQuestionFragment)
}