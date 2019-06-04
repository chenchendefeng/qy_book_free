package com.wy.adbook.di.module

import com.jess.arms.di.scope.FragmentScope
import com.wy.adbook.mvp.contranct.WalletItemContract
import com.wy.adbook.mvp.model.WalletItemModel
import com.wy.adbook.mvp.model.entity.accout.FlowItem
import com.wy.adbook.mvp.view.adapter.WalletItemAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by leafye on 2019-05-28.
 */
@Module
class WalletItemModule(private val view: WalletItemContract.View) {
    @FragmentScope
    @Provides
    fun provideAboutView(): WalletItemContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideAboutModel(model: WalletItemModel): WalletItemContract.Model {
        return model
    }

    @FragmentScope
    @Provides
    fun provideAdapter(list: MutableList<FlowItem>) = WalletItemAdapter(list)

}