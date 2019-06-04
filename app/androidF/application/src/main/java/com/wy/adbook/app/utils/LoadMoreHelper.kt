package com.wy.adbook.app.utils

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.loadmore.LoadMoreView

/**
 * Created by leafye on 2019/5/5.
 */
class LoadMoreHelper {

    companion object {

        fun loadMoreStatus(adapter: BaseQuickAdapter<*, BaseViewHolder>, status: Int, isVIsibleWhenEnd: Boolean) {
            when (status) {
                LoadMoreView.STATUS_END -> adapter.loadMoreEnd(isVIsibleWhenEnd)
                LoadMoreView.STATUS_FAIL -> adapter.loadMoreFail()
                LoadMoreView.STATUS_DEFAULT -> adapter.loadMoreComplete()
                LoadMoreView.STATUS_LOADING -> adapter.notifyLoadMoreToLoading()
            }
        }

        fun loadMoreStatus(adapter: BaseQuickAdapter<*, BaseViewHolder>, status: Int) {
            loadMoreStatus(adapter, status, false)
        }
    }

}