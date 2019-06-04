package com.wy.adbook.wxapi

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.Toast
import com.wy.adbook.app.utils.ShareUtils
import com.wy.adbook.mvp.model.event.ShareEvent
import com.jess.arms.integration.EventBusManager
import com.jess.arms.utils.LogUtils
import com.tencent.mm.opensdk.modelbase.BaseReq
import com.tencent.mm.opensdk.modelbase.BaseResp
import com.tencent.mm.opensdk.modelmsg.SendAuth
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler


/**
 * Created by leafye on 2019-05-12.
 */
class WXEntryActivity : FragmentActivity(), IWXAPIEventHandler {

    companion object {

        const val WX_LOGIN_KEY = "wxLogin"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            val result = WxManager.wxApi().handleIntent(intent, this)
            if (!result) {
                LogUtils.debugInfo("参数不合法，未被SDK处理，退出")
                finish()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        WxManager.wxApi().handleIntent(data, this)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        WxManager.wxApi().handleIntent(intent, this)
        finish()
    }


    override fun onResp(p0: BaseResp?) {
        val resp = p0 ?: return
        LogUtils.debugInfo("baseReq:$resp")
        var result = ""
        when (resp.errCode) {
            BaseResp.ErrCode.ERR_OK -> {
                val newResp = resp as SendAuth.Resp
                val code = newResp.code
                when (resp.state) {
                    WXEntryActivity.WX_LOGIN_KEY -> // 登录回调
                        EventBusManager
                            .getInstance()
                            .post(WxEventBusKey(key = WxEventBusKey.WX_LOGIN_SUCCESS, strArgs = code))
                    ShareUtils.SHARE_WX_SCENE_SESSION -> //分享成功
                        EventBusManager
                            .getInstance()
                            .post(ShareEvent(key = ShareEvent.EVENT_SHARE_SUCCESS, strArgs = code))
                    ShareUtils.SHARE_WX_SCENE_TIMELINE -> //分享成功
                        EventBusManager
                            .getInstance()
                            .post(ShareEvent(key = ShareEvent.EVENT_SHARE_SUCCESS, strArgs = code))
                }
                finish()
            }
            BaseResp.ErrCode.ERR_USER_CANCEL -> {
                Toast.makeText(this, "取消", Toast.LENGTH_SHORT).show()
                finish()
            }
            BaseResp.ErrCode.ERR_AUTH_DENIED -> {
                Toast.makeText(this, "被拒绝", Toast.LENGTH_SHORT).show()
                finish()
            }
            else -> {
                Toast.makeText(this, "返回", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    override fun onReq(p0: BaseReq?) {

    }

    class WxEventBusKey(
        val key: Int,
        var args: Int = -1,
        var strArgs: String = "",
        var obj: Any? = null
    ) {
        companion object {
            /**
             * 微信登录成功
             */
            const val WX_LOGIN_SUCCESS = 100
            /**
             * 分享成功
             */
            const val WX_SHARE_SUCCESS = 101
        }

    }


}