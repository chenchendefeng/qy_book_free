package com.wy.adbook.di.module

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.mvp.contranct.HelpCenterContract
import com.wy.adbook.mvp.model.HelpCenterModel
import com.wy.adbook.mvp.view.fragment.CommonQuestionFragment
import com.wy.adbook.mvp.view.fragment.FeedbackFragment
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-29.
 */
@Module
class HelpCenterModule(private val view: HelpCenterContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): HelpCenterContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: HelpCenterModel): HelpCenterContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    fun provideIndicatorList() = mutableListOf<String>().apply {
        add("常见问题")
        add("问题反馈")
    }

    @ActivityScope
    @Provides
    fun commonQuestionFragment() = CommonQuestionFragment.newInstance()

    @ActivityScope
    @Provides
    fun feedbackFragment() = FeedbackFragment.newInstance()


}