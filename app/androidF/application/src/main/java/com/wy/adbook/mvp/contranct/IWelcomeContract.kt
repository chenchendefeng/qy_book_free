package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.NetStartPage
import com.wy.adbook.mvp.model.entity.accout.NetVisitorLoginSuccess
import com.jess.arms.mvp.IModel
import io.reactivex.Observable

/**
 * Created by leafye on 2019/4/29.
 */
interface IWelcomeContract {

    interface View : QYView {

        fun showAd()

        fun showSkipCount(currentCount: Long)

        fun showImg(fileUrl: String)

        fun showGif(fileUrl: String)

        fun showVideo(fileUrl: String)


    }

    interface Model : IModel {
        /**
         * 游客登录
         */
        fun visitorLogin(): Observable<NetVisitorLoginSuccess>

        /**
         * 启动页数据
         */
        fun getCurStartPage(clientType: String, channelCode: String): Observable<NetStartPage>
    }

}