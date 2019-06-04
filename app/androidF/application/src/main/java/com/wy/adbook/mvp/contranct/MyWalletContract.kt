package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.accout.NetBalance
import com.wy.adbook.mvp.model.entity.accout.NetFlowPage
import com.wy.adbook.mvp.view.adapter.WalletItemAdapter
import com.wy.adbook.view.status.IStatusCoverView
import io.reactivex.Observable

/**
 * Created by leafye on 2019/5/6.
 */
interface MyWalletContract {

    interface View : QYView {

        fun changeStatusCoverView(status: IStatusCoverView.Status)

        fun refreshView()

        fun getCurrentAdapter(): WalletItemAdapter

    }

    interface Model : QYModel {

        fun balance(cuId: Int): Observable<NetBalance>

        fun accountFLowPage(
            cuId: Int,
            currencyType: String,
            pageNo: Int,
            pageSize: Int
        ): Observable<NetFlowPage>

    }

}