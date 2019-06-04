package com.freebookqy.application.mvp.model.entity.accout

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-13.
 */
open class LoginSuccess:Serializable{
    @SerializedName("userToken")
    var userToken: String = ""

    @SerializedName("isRegister")
    var isRegister: Boolean = false

    @SerializedName("userInfo")
    var userInfo: UserInfo? = null
}