package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.view.status.IStatusCoverView

/**
 * Created by leafye on 2019-05-26.
 */
interface WithdrawalRecordContract {

    interface View : QYView {

        fun changeStatus(status: IStatusCoverView.Status)

    }

    interface Model : QYModel

}