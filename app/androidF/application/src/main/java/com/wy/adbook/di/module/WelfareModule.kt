package com.wy.adbook.di.module

import com.wy.adbook.mvp.contranct.WelfareContract
import com.wy.adbook.mvp.model.WelfareModel
import com.jess.arms.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019/4/30.
 */


@Module
class WelfareModule(private val view: WelfareContract.View) {

    @FragmentScope
    @Provides
    fun provideAboutView(): WelfareContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideAboutModel(model: WelfareModel): WelfareContract.Model {
        return model
    }

//    @ActivityScope
//    @Provides
//    internal fun provideWarningDialog() = WarningDialog()

}