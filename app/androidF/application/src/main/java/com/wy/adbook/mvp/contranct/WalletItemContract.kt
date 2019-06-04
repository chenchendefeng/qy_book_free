package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.accout.NetFlowPage
import io.reactivex.Observable

/**
 * Created by leafye on 2019-05-28.
 */
interface WalletItemContract {

    interface View: QYView

    interface Model: QYModel{
        fun accountFLowPage(
            cuId: Int,
            currencyType: String,
            pageNo: Int,
            pageSize: Int
        ): Observable<NetFlowPage>
    }

}