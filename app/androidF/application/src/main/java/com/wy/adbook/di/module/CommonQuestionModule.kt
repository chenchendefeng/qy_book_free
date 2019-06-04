package com.wy.adbook.di.module

import android.support.v7.widget.LinearLayoutManager
import com.jess.arms.di.scope.FragmentScope
import com.wy.adbook.mvp.contranct.CommonQuestionContract
import com.wy.adbook.mvp.model.CommonQuestionModel
import com.wy.adbook.mvp.model.entity.FaqItem
import com.wy.adbook.mvp.view.adapter.CommonQuestionAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-28.
 */
@Module
class CommonQuestionModule(private val view: CommonQuestionContract.View) {
    @FragmentScope
    @Provides
    fun provideAboutView(): CommonQuestionContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideAboutModel(model: CommonQuestionModel): CommonQuestionContract.Model {
        return model
    }

    @FragmentScope
    @Provides
    fun provideCommonQuestionAdapter(list: MutableList<FaqItem>): CommonQuestionAdapter = CommonQuestionAdapter(list)


    @FragmentScope
    @Provides
    fun provideFaqList() = mutableListOf<FaqItem>()

    @FragmentScope
    @Provides
    fun linearLayout() = LinearLayoutManager(view.getContext())

}