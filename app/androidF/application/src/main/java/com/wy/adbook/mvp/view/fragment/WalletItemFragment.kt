package com.wy.adbook.mvp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freebookqy.application.R
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseFragment
import com.wy.adbook.di.component.DaggerWalletItemComponent
import com.wy.adbook.di.module.WalletItemModule
import com.wy.adbook.mvp.contranct.WalletItemContract
import com.wy.adbook.mvp.presenter.WalletItemPresenter
import kotlinx.android.synthetic.main.fragment_wallet_item.*

/**
 * Created by leafye on 2019-05-28.
 */
class WalletItemFragment : QYBaseFragment<WalletItemPresenter>(), WalletItemContract.View {

    companion object {

        fun newInstance(): WalletItemFragment = WalletItemFragment()

    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerWalletItemComponent
            .builder()
            .appComponent(appComponent)
            .walletItemModule(WalletItemModule(this@WalletItemFragment))
            .build()
            .inject(this@WalletItemFragment)
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun setData(data: Any?) {

    }

    override fun startInitView() {
        super.startInitView()
        refresh_layout.setOnRefreshListener {  }

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_wallet_item, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}