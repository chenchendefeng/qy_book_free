package com.freebookqy.application.mvp.contranct

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYView
import com.freebookqy.application.mvp.model.entity.accout.VisitorLoginSuccess
import com.jess.arms.mvp.IModel
import io.reactivex.Observable

/**
 * Created by leafye on 2019/4/29.
 */
interface IWelcomeContract {

    interface View : QYView {

        fun showAd()

        fun showSkipCount(currentCount: Long)

    }

    interface Model : IModel {
        fun visitorLogin(): Observable<BaseEntity<VisitorLoginSuccess>>
    }

}