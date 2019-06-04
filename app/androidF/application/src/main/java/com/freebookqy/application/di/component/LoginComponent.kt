package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.LoginModule
import com.freebookqy.application.mvp.account.Login.LoginActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019-05-08.
 */
@ActivityScope
@Component(modules = [LoginModule::class], dependencies = [AppComponent::class])
interface LoginComponent {
    fun inject(inject: LoginActivity)
}