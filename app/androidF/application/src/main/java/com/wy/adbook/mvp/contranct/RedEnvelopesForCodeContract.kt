package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.NetInvitationCode
import io.reactivex.Observable

/**
 * Created by leafye on 2019-05-27.
 */
interface RedEnvelopesForCodeContract {

    interface View : QYView {
        fun showRedRevelopesDialog()

        fun waitSubmit()

        fun setSubmited()
    }

    interface Model : QYModel {
        /**
         * 填写邀请码
         */
        fun fillInCode(
            cuId: Int,
            code: String
        ): Observable<NetInvitationCode>

    }

}