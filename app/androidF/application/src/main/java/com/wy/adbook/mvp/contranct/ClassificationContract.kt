package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.NetBanner
import com.wy.adbook.mvp.model.entity.NetClassification
import io.reactivex.Observable

/**
 * Created by leafye on 2019/5/5.
 */
interface ClassificationContract {

    interface View : QYView {
        fun refreshView()

        //fun getAdapter(): ClassificationContentAdapter

        fun isRefresh(isRefresh: Boolean)
    }

    interface Model : QYModel {

        fun categoryData(
            pageNo: Int,
            pageSize: Int,
            sexType: String
        ): Observable<NetClassification>

        fun fetchBanner(
            systemType: String,
            position: String,
            channel: String
        ):Observable<NetBanner>


    }


}
