package com.freebookqy.application.di.module

import com.freebookqy.application.mvp.contranct.MyContract
import com.freebookqy.application.mvp.main.my.MyModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/4/29.
 */
@Module
class MyModule(private val view: MyContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): MyContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: MyModel): MyContract.Model {
        return model
    }


}
