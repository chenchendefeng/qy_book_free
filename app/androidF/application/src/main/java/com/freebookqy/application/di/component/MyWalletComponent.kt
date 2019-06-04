package com.freebookqy.application.di.component

import com.freebookqy.application.di.module.MyWalletModule
import com.freebookqy.application.mvp.main.my.wallet.MyWalletActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import dagger.Component

/**
 * Created by leafye on 2019/5/6.
 */
@ActivityScope
@Component(modules = [MyWalletModule::class], dependencies = [AppComponent::class])
interface MyWalletComponent {
    fun inject(inject:MyWalletActivity)
}