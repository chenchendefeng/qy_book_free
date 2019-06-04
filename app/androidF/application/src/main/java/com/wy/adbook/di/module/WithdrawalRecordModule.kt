package com.wy.adbook.di.module

import android.support.v7.widget.LinearLayoutManager
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.mvp.contranct.WithdrawalRecordContract
import com.wy.adbook.mvp.model.WithdrawalRecordModel
import com.wy.adbook.mvp.model.entity.WithdrawalRecordItem
import com.wy.adbook.mvp.view.adapter.WithdrawalRecordAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-26.
 */
@Module
class WithdrawalRecordModule(private val view: WithdrawalRecordContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): WithdrawalRecordContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: WithdrawalRecordModel): WithdrawalRecordContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    fun withdrawalRecordAdapter(list: MutableList<WithdrawalRecordItem>) = WithdrawalRecordAdapter(list)


    @ActivityScope
    @Provides
    fun llm() = LinearLayoutManager(view.getContext())

    @ActivityScope
    @Provides
    fun withdrawalRecordItemList() = mutableListOf<WithdrawalRecordItem>()


}