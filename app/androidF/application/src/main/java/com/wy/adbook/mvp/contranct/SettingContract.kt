package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.accout.NetLogOut
import com.wy.adbook.mvp.model.entity.accout.NetVisitorLoginSuccess
import io.reactivex.Observable

/**
 * Created by leafye on 2019-05-29.
 */
interface SettingContract {

    interface View : QYView {

        fun refreshView()
    }

    interface Model : QYModel {

        fun logout(
            cuid: Int
        ): Observable<NetLogOut>

        fun visitorLogin(
            imei: String
        ): Observable<NetVisitorLoginSuccess>
    }

}