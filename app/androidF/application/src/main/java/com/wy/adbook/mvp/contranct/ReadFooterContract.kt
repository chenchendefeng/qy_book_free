package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.NetDeleteReadFooter
import com.wy.adbook.mvp.model.entity.NetReadFooterPage
import com.wy.adbook.view.status.IStatusCoverView
import io.reactivex.Observable

/**
 * Created by leafye on 2019-05-28.
 */
interface ReadFooterContract {

    interface View : QYView {

        fun changeCoverStatus(status: IStatusCoverView.Status)

        fun setRefresh(isRefresh: Boolean)
    }

    interface Model : QYModel {
        /**
         * 获取足迹列表
         */
        fun getReadFooterPage(
            cuid: Int,
            pageNo: Int,
            pageSize: Int
        ): Observable<NetReadFooterPage>

        /**
         * 删除足迹
         */
        fun deleteReadFooter(
            id: Int
        ): Observable<NetDeleteReadFooter>

    }

}