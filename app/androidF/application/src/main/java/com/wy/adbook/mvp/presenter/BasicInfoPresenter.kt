package com.wy.adbook.mvp.presenter

import android.text.TextUtils
import com.jess.arms.di.scope.ActivityScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.rx.net
import com.wy.adbook.mvp.contranct.BasicInfoContract
import com.wy.adbook.mvp.model.entity.accout.NetChangeNick
import com.wy.adbook.mvp.model.view.BasicInfo
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-30.
 */
@ActivityScope
class BasicInfoPresenter
@Inject
constructor(model: BasicInfoContract.Model, view: BasicInfoContract.View) :
    QYBasePresenter<BasicInfoContract.Model, BasicInfoContract.View>(model, view) {


    fun handleBasicInfo(item: BasicInfo) {
        when (item.type) {
            BasicInfo.Type.TYPE_ACCOUNT -> {

            }
            BasicInfo.Type.TYPE_GENDER -> {

            }
            BasicInfo.Type.TYPE_HEAD -> {

            }
            BasicInfo.Type.TYPE_NICKNAME -> {
                mRootView.showChangeNickNameDialog()
            }
        }
    }

    fun toChangeNickname(inputContent: String) {
        if (TextUtils.isEmpty(inputContent)) {
            mRootView.getContext().toast("请输入昵称")
            return
        }
        mModel.changeNickName(QYAccount.uid(), inputContent)
            .net(mRootView)
            .doOnSubscribe {
                mRootView.showLoading()
            }
            .subscribe(object : ErrorHandleSubscriber<NetChangeNick>(mErrorHandler) {
                override fun onNext(t: NetChangeNick) {
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