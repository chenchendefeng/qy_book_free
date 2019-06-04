package com.freebookqy.application.wxapi

import com.freebookqy.application.app.QYApplication
import com.freebookqy.application.app.constant.Constant
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory

/**
 * Created by leafye on 2019-05-12.
 */
object WxManager {

    private val api: IWXAPI by lazy {
        WXAPIFactory.createWXAPI(QYApplication.cxt(), Constant.APP_ID_WX, true).apply {
            registerApp(Constant.APP_ID_WX)
        }
    }

    fun isWXAppInstalled(): Boolean {
        return api.isWXAppInstalled
    }

    fun wxApi() = api

}