package com.wy.adbook.di.module

import com.jess.arms.di.scope.FragmentScope
import com.wy.adbook.mvp.contranct.FeedbackContract
import com.wy.adbook.mvp.model.FeedbackModel
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-29.
 */
@Module
class FeedbackModule(private val view: FeedbackContract.View) {
    @FragmentScope
    @Provides
    fun provideAboutView(): FeedbackContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideAboutModel(model: FeedbackModel): FeedbackContract.Model {
        return model
    }


}