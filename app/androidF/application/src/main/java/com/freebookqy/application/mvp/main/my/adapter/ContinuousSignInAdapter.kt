package com.freebookqy.application.mvp.main.my.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by leafye on 2019-05-09.
 */
class ContinuousSignInAdapter(list:MutableList<SignInRewardItem>?)
    : BaseQuickAdapter<SignInRewardItem,BaseViewHolder>(list) {
    override fun convert(helper: BaseViewHolder, item: SignInRewardItem) {

    }

}


class SignInRewardItem(
    var reward: Int,
    var days: Int
) {

}