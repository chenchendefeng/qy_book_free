package com.wy.adbook.mvp.presenter

import android.text.TextUtils
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.rx.net
import com.wy.adbook.mvp.contranct.RedEnvelopesForCodeContract
import com.wy.adbook.mvp.model.entity.NetInvitationCode
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-27.
 */
@ActivityScope
class RedEnvelopesForCodePresenter
@Inject
constructor(model: RedEnvelopesForCodeContract.Model, view: RedEnvelopesForCodeContract.View) :
    QYBasePresenter<RedEnvelopesForCodeContract.Model, RedEnvelopesForCodeContract.View>(model, view) {


    fun fillInvitationCode(code: String) {
        if (TextUtils.isEmpty(code)) {
            mRootView.showError("请输入邀请码")
            return
        }
        mRootView.showLoading()
        mModel.fillInCode(QYAccount.uid(), code)
            .net(mRootView)
            .subscribe(object : ErrorHandleSubscriber<NetInvitationCode>(mErrorHandler) {
                override fun onNext(t: NetInvitationCode) {
                    if (t.isOk()) {
                        mRootView.showSuccess(t.msg)

                    } else {
                        mRootView.showError(t.msg)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.hideLoading()
                }
            })
    }


}