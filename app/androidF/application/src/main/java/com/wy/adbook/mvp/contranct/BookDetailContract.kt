package com.wy.adbook.mvp.contranct

import com.wy.adbook.app.base.QYModel
import com.wy.adbook.app.base.QYView
import com.wy.adbook.mvp.model.entity.NetChapterList
import com.wy.adbook.mvp.model.entity.NetTogetherRead
import com.wy.adbook.mvp.model.entity.book.NetBook
import com.wy.adbook.mvp.model.entity.book.NetPutOn
import com.jess.arms.integration.IRepositoryManager
import io.reactivex.Observable

/**
 * Created by leafye on 2019/5/7.
 */
interface BookDetailContract {

    interface View : QYView {
        /**
         * 刷新大家都在看
         */
        fun refreshGuessYouLike()

        /**
         * 刷新书籍信息
         */
        fun refreshBookInfo(isShowBtm: Boolean)

        /**
         * 刷新广告内容
         */
        fun refreshAd()

        /**
         * 设置下拉刷新是否显示
         */
        fun isRefresh(isRefresh: Boolean)
    }

    interface Model : QYModel {

        fun getRm(): IRepositoryManager
        /**
         * 大家都在看
         */
        fun pageListTogetherRead(pageNo: Int, pageSize: Int, category: String):
                Observable<NetTogetherRead>

        /**
         * 书籍详情
         */
        fun bookDetail(bid: Int): Observable<NetBook>

        /**
         * 加入书架
         */
        fun putOn(uid: Int, bid: Int): Observable<NetPutOn>

        /**
         * 获取章节列表
         */
        fun getChapterList(bid: Int): Observable<NetChapterList>

    }

}