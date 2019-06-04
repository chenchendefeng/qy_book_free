package com.freebookqy.application.mvp.contranct

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYModel
import com.freebookqy.application.app.base.QYView
import com.freebookqy.application.mvp.model.entity.accout.PhoneLoginSuccess
import com.freebookqy.application.mvp.model.entity.accout.WechatLoginSuccess
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

        fun loginPhone(phone: String, code: String): Observable<BaseEntity<PhoneLoginSuccess>>

        fun loginWx(code: String):Observable<BaseEntity<WechatLoginSuccess>>
    }

}