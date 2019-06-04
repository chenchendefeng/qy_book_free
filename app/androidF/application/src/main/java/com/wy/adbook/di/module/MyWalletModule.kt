package com.wy.adbook.di.module

import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.mvp.contranct.MyWalletContract
import com.wy.adbook.mvp.model.MyWalletModel
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

//    @ActivityScope
//    @Provides
//    @Named("l1")
//    fun linearLayout1() = LinearLayoutManager(view.getContext())
//
//    @ActivityScope
//    @Provides
//    @Named("l2")
//    fun linearLayout2() = LinearLayoutManager(view.getContext())
//
//
//    @ActivityScope
//    @Provides
//    @Named("rmbAdapter")
//    fun rmbAdapter() = WalletItemAdapter(null).apply {
//        val view = View.inflate(view.getContext(), R.layout.empty_wallet, null).apply {
//            val str = "现金"
//            find<TextView>(R.id.empty_text_tv).text =
//                ResUtils.getString(R.string.no_cash_detail, str)
//            find<TextView>(R.id.empty_tip_tv).text =
//                ResUtils.getString(R.string.detailed_system_retain_only_last_3_days_cash, str)
//        }
//        emptyView = view
//    }
//
//    @ActivityScope
//    @Provides
//    @Named("goldAdapter")
//    fun goldAdapter() = WalletItemAdapter(null).apply {
//        val view = View.inflate(view.getContext(), R.layout.empty_wallet, null).apply {
//            val str = "金豆"
//            find<TextView>(R.id.empty_text_tv).text =
//                ResUtils.getString(R.string.no_cash_detail, str)
//            find<TextView>(R.id.empty_tip_tv).text =
//                ResUtils.getString(R.string.detailed_system_retain_only_last_3_days_cash, str)
//        }
//        emptyView = view
//    }


}