package com.freebookqy.application.mvp.contranct

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYModel
import com.freebookqy.application.app.base.QYView
import com.freebookqy.application.mvp.model.entity.accout.PersonalCenterPage
import com.freebookqy.application.mvp.model.entity.accout.UserInfo
import com.freebookqy.application.mvp.model.entity.accout.WechatLoginSuccess
import io.reactivex.Observable

/**
 * Created by leafye on 2019/4/30.
 */
interface MyContract {

    interface View : QYView {

        fun refreshView()

        fun setRefresh(isRefresh:Boolean)

    }

    interface Model : QYModel {

        fun personalCenterPage(): Observable<BaseEntity<PersonalCenterPage>>

        fun wxLogin(code:String):Observable<BaseEntity<WechatLoginSuccess>>

        fun getCustomerBizInfo(cid:String):Observable<BaseEntity<UserInfo>>
    }

}