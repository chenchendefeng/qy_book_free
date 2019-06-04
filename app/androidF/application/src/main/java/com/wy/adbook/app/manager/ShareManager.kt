package com.wy.adbook.app.manager

import android.content.Context
import com.freebookqy.application.R
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.utils.RxLifecycleUtils
import com.wy.adbook.app.base.QYView
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.dialog.share.ShareBookDialog
import com.wy.adbook.dialog.share.ShareDialog
import com.wy.adbook.dialog.share.ShareListener
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetWatchForGole
import com.wy.adbook.mvp.view.adapter.ShareItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import org.jetbrains.anko.toast

/**
 * Created by leafye on 2019-05-22.
 */
object ShareManager {

    fun showShareDialog(context: Context, l: ShareListener) {
        ShareDialog(context).apply {
            setData(getShareNormal())
            setShareListener(l)
        }.show()
    }

    fun showShareBookDialog(context: Context, l: ShareListener) {
        ShareBookDialog(context).apply {
            setData(getShareNormal())
            setData("xxxxxx", "")
            setShareListener(l)
        }.show()
    }

    fun showInviteFriendDialog(context: Context, l: ShareListener) {
        ShareDialog(context).apply {
            setData(getInviteFriend())
            setShareListener(l)
        }.show()
    }

    private fun getShareNormal() = mutableListOf<ShareItem>().apply {
        add(ShareItem("微信好友", R.mipmap.icon_share_weixin, Constant.ShareType.SHARE_TYPE_WX_HY))
        add(ShareItem("朋友圈", R.mipmap.icon_share_pyq, Constant.ShareType.SHARE_TYPE_WX_PYQ))
        add(ShareItem("QQ", R.mipmap.icon_share_qq, Constant.ShareType.SHARE_TYPE_QQ))
    }

    private fun getInviteFriend() = mutableListOf<ShareItem>().apply {
        add(ShareItem("微信好友", R.mipmap.icon_share_weixin, Constant.ShareType.SHARE_TYPE_WX_HY))
        add(ShareItem("朋友圈", R.mipmap.icon_share_pyq, Constant.ShareType.SHARE_TYPE_WX_PYQ))
        add(ShareItem("面对面邀请", R.mipmap.icon_erweima, Constant.ShareType.SHARE_TYPE_FACE_TO_FACE))
        add(ShareItem("QQ好友", R.mipmap.icon_share_qq, Constant.ShareType.SHARE_TYPE_QQ))
        add(ShareItem("QQ空间", R.mipmap.icon_qqz, Constant.ShareType.SHARE_TYPE_QQ_ZONE))
    }


    fun shareSuccess(
        rootView: QYView,
        rm: IRepositoryManager,
        uid: Int,
        errorHandler: RxErrorHandler
    ) {
        rootView.showLoading()
        rm.obtainRetrofitService(QYService::class.java)
            .watchForGole(uid)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(rootView))
            .subscribe(object : ErrorHandleSubscriber<NetWatchForGole>(errorHandler) {
                override fun onNext(t: NetWatchForGole) {
                    if (t.isOk()) {
                        rootView.showSuccess(t.msg)
                    } else {
                        rootView.hideLoading()
                        rootView.getContext().toast(t.msg)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    rootView.hideLoading()
                }

            })
    }


}