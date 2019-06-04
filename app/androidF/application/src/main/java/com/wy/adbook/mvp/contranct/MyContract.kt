package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.accout.NetPersonalCenterPage
import com.wy.adbook.mvp.model.entity.accout.NetUserInfo
import com.wy.adbook.mvp.model.entity.accout.NetWechatLoginSuccess
import com.wy.adbook.view.status.IStatusCoverView
import io.reactivex.Observable

/**
 * Created by leafye on 2019/4/30.
 */
interface MyContract {

    interface View : QYView {

        fun refreshView()

        fun setRefresh(isRefresh:Boolean)

        fun changeStatus(status: IStatusCoverView.Status)

    }

    interface Model : QYModel {

        fun personalCenterPage(): Observable<NetPersonalCenterPage>

        fun wxLogin(code:String):Observable<NetWechatLoginSuccess>

        fun getCustomerBizInfo(cid:Int):Observable<NetUserInfo>
    }

}