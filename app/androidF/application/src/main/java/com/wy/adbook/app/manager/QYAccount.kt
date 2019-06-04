package com.wy.adbook.app.manager

import android.text.TextUtils
import com.freebookqy.application.R
import com.freebookqy.utilslib.ResUtils
import com.google.gson.Gson
import com.jess.arms.integration.EventBusManager
import com.jess.arms.utils.DataHelper
import com.wy.adbook.app.QYApplication
import com.wy.adbook.mvp.model.entity.accout.LoginSuccess
import com.wy.adbook.mvp.model.entity.accout.UserInfo
import com.wy.adbook.mvp.model.event.LoginEvent
import java.util.*

/**
 * Created by leafye on 2019-05-08.
 */
object QYAccount {

    init {
        DataHelper.getStringSF(QYApplication.cxt(), ResUtils.getString(R.string.sp_qy_user_info))?.let {
            val info = Gson().fromJson(it, UserInfo::class.java)
            setUserInfo(info)
        }
        DataHelper.getStringSF(QYApplication.cxt(), ResUtils.getString(R.string.sp_qy_user_token))?.let {
            if (!TextUtils.isEmpty(it)) {
                setUserToke(it)
            }
        }
    }

    private var userInfo: UserInfo? = null

    private var userToken: String = ""

    private var isRegister: Boolean = false

    fun setRegister(register: Boolean) {
        isRegister = register
        DataHelper.setIntergerSF(
            QYApplication.cxt(),
            ResUtils.getString(R.string.sp_qy_is_register),
            if (isRegister) 1 else 0
        )
    }

    fun isRegister(): Boolean {
        val rigsterInt = DataHelper.getIntergerSF(
            QYApplication.cxt(),
            ResUtils.getString(R.string.sp_qy_is_register)
        )
        return rigsterInt == 1
    }

    fun setUserToke(userToken: String) {
        QYAccount.userToken = userToken
        DataHelper.setStringSF(QYApplication.cxt(), ResUtils.getString(R.string.sp_qy_user_token), userToken)
    }

    fun getUserToken(): String {
        return userToken
    }

    fun setUserInfo(userInfo: UserInfo?) {
        QYAccount.userInfo = userInfo
        userInfo?.let {
            val json = Gson().toJson(it)
            DataHelper.setStringSF(QYApplication.cxt(), ResUtils.getString(R.string.sp_qy_user_info), json)
        }
    }

    /**
     *"avatar": "string",
    "cuId": 0,
    "cuName": "string",
    "freeAdvTime": "2019-05-28T08:50:18.095Z",
    "nickName": "string",
    "userStatus": "string",
    "userType": "string",
    "vipEndDate": "2019-05-28T08:50:18.095Z",
    "vipFlag": "string",
    "vipStartDate": "2019-05-28T08:50:18.095Z"
     */
    fun updateUserCustomerBizInfo(userInfo: UserInfo?) {
        val cacheUserInfo = QYAccount.userInfo
        cacheUserInfo?.apply {
            userInfo?.let { info ->
                info.avatar.takeIf { !TextUtils.isEmpty(it) }?.let { avatar = it }
                info.nickName.takeIf { !TextUtils.isEmpty(it) }?.let { nickName = it }
                info.freeAdvTime.takeIf { !TextUtils.isEmpty(it) }?.let { freeAdvTime = it }
                info.userStatus.takeIf { !TextUtils.isEmpty(it) }?.let { userStatus = it }
                info.userType.takeIf { !TextUtils.isEmpty(it) }?.let { userType = it }
                info.vipEndDate.takeIf { !TextUtils.isEmpty(it) }?.let { vipEndDate = it }
                info.vipFlag.takeIf { !TextUtils.isEmpty(it) }?.let { vipFlag = it }
                info.vipStartDate.takeIf { !TextUtils.isEmpty(it) }?.let { vipStartDate = it }
                info.cuId.takeIf { it > 0 }?.let { cuId = it }
                info
            }
        }
        cacheUserInfo?.let {
            val json = Gson().toJson(it)
            DataHelper.setStringSF(QYApplication.cxt(), ResUtils.getString(R.string.sp_qy_user_info), json)
        }
    }

    fun getUserInfo(): UserInfo {
        if (userInfo == null) {
            userInfo = UserInfo()
        }
        return userInfo!!
    }

    fun uid(): Int {
        val cuId = getUserInfo().cuId
        return try {
            Integer.valueOf(cuId)
        } catch (e: Exception) {
            0
        }
    }

    fun isLogin(): Boolean {
        return !TextUtils.isEmpty(getUserInfo().bindPhone)
                || !TextUtils.isEmpty(getUserInfo().bindOpenid)
    }

    /**
     * 设置gender
     */
    fun setGender(gender: Int) {
        DataHelper.setIntergerSF(QYApplication.cxt(), ResUtils.getString(R.string.sp_qy_gender), gender)
    }

    /**
     * 获取gender
     */
    fun getGender(): Int {
        return DataHelper.getIntergerSF(QYApplication.cxt(), ResUtils.getString(R.string.sp_qy_gender))
    }

    /**
     * 金豆
     */
    fun goldBeanNum(): Int {
        return 10000
    }

    /**
     * 现金
     */
    fun cashNum(): Int {
        return 10000
    }

    /**
     * 今日阅读
     */
    fun getTodayReadMinute(): Int {
        var minutes = DataHelper.getIntergerSF(
            QYApplication.cxt(),
            getTodayReadKey()
        )
        if (minutes == -1) {
            minutes = 0
        }
        return minutes
    }

    fun updateTodayReadMinute(minutes: Long) {
        DataHelper.setIntergerSF(
            QYApplication.cxt(),
            getTodayReadKey(), minutes.toInt()
        )
    }

    private fun getTodayReadKey(): String {
        val instance = Calendar.getInstance()
        val year = instance.get(Calendar.YEAR)
        val month = instance.get(Calendar.MONTH)
        val day = instance.get(Calendar.DAY_OF_MONTH)
        return "today_read" + year + "_" + month + "_" + day
    }

    fun loginSuccess(loginSuccess: LoginSuccess) {
        setUserInfo(loginSuccess.userInfo)
        setUserToke(loginSuccess.userToken)
        setRegister(loginSuccess.isRegister)
        postLoginSuccess()
    }

    private fun postLoginSuccess() {
        EventBusManager.getInstance().post(LoginEvent(LoginEvent.EVENT_LOGIN_SUCCESS))
    }

    fun logoutSuccess(){
        setUserInfo(null)
        EventBusManager.getInstance().post(LoginEvent(LoginEvent.EVENT_LOGOUT_SUCCESS))
    }

    fun todayIsWatchVideoSuccess() {
        DataHelper.setIntergerSF(
            QYApplication.cxt(),
            getTodayWatchVideoKey(), 1
        )
    }

    fun isTodayWatchVideo(): Boolean {
        return DataHelper.getIntergerSF(
            QYApplication.cxt(),
            getTodayWatchVideoKey()
        ) == 1
    }

    private fun getTodayWatchVideoKey(): String {
        val instance = Calendar.getInstance()
        val year = instance.get(Calendar.YEAR)
        val month = instance.get(Calendar.MONTH)
        val day = instance.get(Calendar.DAY_OF_MONTH)
        return "today_watch" + year + "_" + month + "_" + day
    }

    /**
     * 是否vip
     */
    fun isVip(): Boolean {
        return TextUtils.equals(userInfo?.vipFlag, "vip")
    }

    /**
     * 获取用户红包码
     */
    fun getInviteCode(): String {
        return getUserInfo().invitationCode
    }

    /**
     * 获取下载图片二维码
     */
    fun getInviteQrCode(): String {
        return ""
    }


}



