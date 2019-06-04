package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.accout.NetChangeNick
import io.reactivex.Observable

/**
 * Created by leafye on 2019-05-30.
 */
interface BasicInfoContract {

    interface View: QYView {

        fun showChangeNickNameDialog()
    }

    interface Model: QYModel{

        fun changeNickName(
            uid:Int,
            nickname:String
        ):Observable<NetChangeNick>

    }

}