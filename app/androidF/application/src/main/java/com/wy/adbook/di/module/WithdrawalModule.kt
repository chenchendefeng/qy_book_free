package com.wy.adbook.di.module

import com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.mvp.contranct.WithdrawalContract
import com.wy.adbook.mvp.model.WithdrawalModel
import com.wy.adbook.mvp.model.entity.WithdrawalItem
import com.wy.adbook.mvp.view.adapter.WithdrawablAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by leafye on 2019-05-26.
 */
@Module
class WithdrawalModule(private val view: WithdrawalContract.View) {
    @ActivityScope
    @Provides
    fun provideAboutView(): WithdrawalContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAboutModel(model: WithdrawalModel): WithdrawalContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    @Named("glm1")
    fun glm1() = getFglm()

    @ActivityScope
    @Provides
    @Named("glm2")
    fun glm2() = getFglm()

    private fun getFglm() = object : FullyGridLayoutManager(view.getContext(), 2) {
        override fun canScrollVertically(): Boolean {
            return false
        }
    }

    @ActivityScope
    @Provides
    @Named("list1")
    fun goldWithdrawalItemList() = getList()

    @ActivityScope
    @Provides
    @Named("list2")
    fun cashWithdrawalItemList() = getList()

    private fun getList() = mutableListOf<WithdrawalItem>()

    @ActivityScope
    @Provides
    @Named("adapter1")
    fun withdrawalAdapter(
        @Named("list1")
        list1: MutableList<WithdrawalItem>
    ) = getAdapter(list1)


    @ActivityScope
    @Provides
    @Named("adapter2")
    fun cashWithdrawalAdapter(
        @Named("list2")
        list2: MutableList<WithdrawalItem>
    ) = getAdapter(list2)

    private fun getAdapter(list:MutableList<WithdrawalItem>) = WithdrawablAdapter(list)


}