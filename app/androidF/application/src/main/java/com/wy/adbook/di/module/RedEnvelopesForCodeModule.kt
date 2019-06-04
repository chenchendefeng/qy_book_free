package com.wy.adbook.di.module

import com.wy.adbook.mvp.contranct.RedEnvelopesForCodeContract
import com.wy.adbook.mvp.model.RedEnvelopesForCodeModel
import com.jess.arms.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-27.
 */
@Module
class RedEnvelopesForCodeModule(private val view: RedEnvelopesForCodeContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): RedEnvelopesForCodeContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: RedEnvelopesForCodeModel): RedEnvelopesForCodeContract.Model {
        return model
    }


}