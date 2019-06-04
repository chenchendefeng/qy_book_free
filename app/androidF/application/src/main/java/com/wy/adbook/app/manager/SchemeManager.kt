package com.wy.adbook.app.manager

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import com.freebookqy.application.R
import com.freebookqy.utilslib.ResUtils
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.jess.arms.integration.EventBusManager
import com.jess.arms.integration.IRepositoryManager
import com.wy.adbook.app.base.QYView
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.app.rx.net
import com.wy.adbook.app.utils.ShareUtils
import com.wy.adbook.dialog.share.ShareBookDialog
import com.wy.adbook.dialog.share.ShareDialog
import com.wy.adbook.dialog.share.ShareListener
import com.wy.adbook.ext.toIntS
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.NetAttendanceStatus
import com.wy.adbook.mvp.model.event.MainEvent
import com.wy.adbook.mvp.model.event.ShareEvent
import com.wy.adbook.mvp.view.activity.*
import com.wy.adbook.mvp.view.web.act.WebActivity
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber

/**
 * Created by leafye on 2019-05-24.
 */
object SchemeManager {

    /**
     * 进入书籍界面的scheme
     */
    private const val BOOK_SCHEME_BOOK = "book://"

    /**
     * 判断链接是否为广告
     */
    fun isAdScheme(url: String): Boolean {
        //todo 判断链接是否为广告
        return false
    }

    /**
    url:"http://www.baidu.com"  (h5)
    url:"bookshelf"  (书架页)
    url:"bindPhone" (绑定手机)
    url:"rewardCode" (填红包码)
    url:"wallet" (我的钱包)
    url:"withdraw"   (我要提现)
    url:"invite"   (邀请好友)
    url:"checkIn"   (签到页)
    url:"welfare"   (福利页)
    url:"book://1234"  (书籍详情)
     */
    fun parseScheme(rootView: QYView, url: String?, rm: IRepositoryManager, handler: RxErrorHandler) {
        if (TextUtils.isEmpty(url)) return
        val context = rootView.getContext()
        try {
            val scheme = Gson().fromJson<Scheme>(url, Scheme::class.java)
            if (scheme.linkType == "h5") {
                WebActivity.startActivity(context, scheme.url, "")
            } else if (scheme.linkType == "app") {
                if (scheme.url.startsWith(BOOK_SCHEME_BOOK)) {
                    val bookIdStr = scheme.url.substring(BOOK_SCHEME_BOOK.length, scheme.url.length)
                    val bookId = bookIdStr.toIntS()
                    BookDetailActivity.startActivity(context, bookId)
                } else
                    when (scheme.url) {
                        "bookshelf" -> {
                            MainActivity.startActivity(context)
                            val mainEvent = MainEvent(MainEvent.EVENT_ENTER_BOOKCASE)
                            EventBusManager.getInstance().post(mainEvent)
                        }
                        "bindPhone" -> {

                        }
                        "rewardCode" -> {
                            RedEnvelopesForCodeActivity.startActivity(context)
                        }
                        "wallet" -> {
                            MyWalletActivity.startActivity(context)
                        }
                        "withdraw" -> {
                            WithdrawalActivity.startActivity(context)
                        }
                        "invite" -> {
                            WebActivity.startActivity(
                                rootView.getContext(),
                                ResUtils.getString(R.string.url_invite_friend),
                                "邀请好友"
                            )
                        }
                        "checkIn" -> {
                            getAttendanceStatus(rootView, rm, handler)
                        }
                        "welfare" -> {
                            MainActivity.startActivity(context)
                            val mainEvent = MainEvent(MainEvent.EVENT_ENTER_WELFARE)
                            EventBusManager.getInstance().post(mainEvent)
                        }
                    }
            }
        } catch (e: Exception) {

        }
    }

    private fun getAttendanceStatus(rootView: QYView, rm: IRepositoryManager, handler: RxErrorHandler) {
        rootView.showLoading()
        rm.obtainRetrofitService(QYService::class.java)
            .attendanceStatus(QYAccount.uid())
            .net(rootView)
            .subscribe(object : ErrorHandleSubscriber<NetAttendanceStatus>(handler) {
                override fun onNext(t: NetAttendanceStatus) {
                    if (t.isOk() && t.data != null) {
                        SignCalenderActivity.startActivity(rootView.getContext(), t.data!!)
                        rootView.hideLoading()
                    } else {
                        rootView.showError(t.msg)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    rootView.hideLoading()
                }
            })
    }

    private fun share(context: Context) {
        ShareManager.showShareBookDialog(context, object : ShareListener {
            override fun share(shareDialog: ShareDialog, shareType: Int) {
                shareDialog.dismiss()
                if (shareDialog !is ShareBookDialog) {
                    return
                }
                val shareBitmap = shareDialog.getShareBitmap()
                when (shareType) {
                    Constant.ShareType.SHARE_TYPE_WX_PYQ -> ShareUtils.ShareWXSceneTimeline(shareBitmap)
                    Constant.ShareType.SHARE_TYPE_WX_HY -> ShareUtils.ShareWXSceneSession(shareBitmap)
                    Constant.ShareType.SHARE_TYPE_QQ -> ShareUtils.ShareQQ(
                        context as Activity,
                        shareBitmap,
                        object : ShareUtils.BaseUiListener() {
                            override fun onComplete(response: Any?) {
                                super.onComplete(response)
                                EventBusManager
                                    .getInstance()
                                    .post(ShareEvent(key = ShareEvent.EVENT_SHARE_SUCCESS))
                            }
                        }
                    )
                }
            }
        })
    }

    class Scheme {

        @SerializedName("linkType")
        var linkType: String = ""

        @SerializedName("url")
        var url: String = ""

    }


}