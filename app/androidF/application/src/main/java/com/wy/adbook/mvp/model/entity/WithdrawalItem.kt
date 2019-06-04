package com.wy.adbook.mvp.model.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019-05-30.
 */
/**
 * 提现兑换规则
 */
class WithdrawalItem : Serializable {

    @SerializedName("is_new")
    var isNew: Int = 0

    @SerializedName("withdrawal_cash")
    var withdrawalCash: Int = 0

    @SerializedName("need_gold")
    var goldCount: Int = 0

    @SerializedName("id")
    var withdrawalId: Int = 0


}