package com.wy.adbook.app.manager

import com.freebookqy.utilslib.ApkUtils
import com.jess.arms.integration.IRepositoryManager
import com.wy.adbook.app.base.QYView
import com.wy.adbook.app.rx.net
import com.wy.adbook.app.utils.ChannelUtils
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.update.NetVersionCheckUpdate
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber

/**
 * Created by leafye on 2019-05-30.
 */
object UpdateManager {

    /**
     * 去检查是否有更新
     */
    fun toCheckUpdate(
        rm: IRepositoryManager,
        errorHandler: RxErrorHandler,
        rootView: QYView
    ) {
        val versionName = ApkUtils.getVersionName(rootView.getContext())
        val channel = ChannelUtils.getChannel()
        rm.obtainRetrofitService(QYService::class.java)
            .versionCheckUpdate(versionName,channel)
            .net(rootView)
            .subscribe(object:ErrorHandleSubscriber<NetVersionCheckUpdate>(errorHandler){
                override fun onNext(t: NetVersionCheckUpdate) {
                    if (t.isOk()){

                    }else{

                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)

                }
            })
    }

    interface CheckUpdateListener{



    }

}