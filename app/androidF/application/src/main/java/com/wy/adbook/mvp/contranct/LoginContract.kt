package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.accout.NetPhoneLoginSuccess
import com.wy.adbook.mvp.model.entity.accout.NetWechatLoginSuccess
import io.reactivex.Observable

/**
 * Created by leafye on 2019-05-08.
 */
interface LoginContract {

    interface View : QYView {
        /**
         * 开始倒计时
         */
        fun startCountdown()
    }

    interface Model : QYModel {

        fun loginPhone(phone: String, code: String): Observable<NetPhoneLoginSuccess>

        fun loginWx(code: String):Observable<NetWechatLoginSuccess>
    }

}