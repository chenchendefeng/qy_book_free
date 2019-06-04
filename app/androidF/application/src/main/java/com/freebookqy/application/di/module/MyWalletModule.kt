package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.contranct.MyWalletContract
import com.freebookqy.application.mvp.main.my.wallet.MyWalletModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/5/6.
 */
@Module
class MyWalletModule(private val view: MyWalletContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): MyWalletContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: MyWalletModel): MyWalletContract.Model {
        return model
    }


}