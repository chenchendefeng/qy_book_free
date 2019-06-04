package com.freebookqy.application.mvp.contranct

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYModel
import com.freebookqy.application.app.base.QYView
import com.freebookqy.application.mvp.model.entity.Chapter
import com.freebookqy.application.mvp.model.entity.book.Book
import com.freebookqy.application.mvp.model.entity.book.PutOn
import com.freebookqy.application.mvp.model.entity.TogetherRead
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
        fun refreshBookInfo()

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
        /**
         * 大家都在看
         */
        fun pageListTogetherRead(pageNo: Int, pageSize: Int, category: String):
                Observable<BaseEntity<TogetherRead>>

        /**
         * 书籍详情
         */
        fun bookDetail(bid: Int): Observable<BaseEntity<Book>>

        /**
         * 加入书架
         */
        fun putOn(uid: Int, bid: Int): Observable<BaseEntity<PutOn>>

        /**
         * 获取章节列表
         */
        fun getChapterList(bid:Int):Observable<BaseEntity<MutableList<Chapter>>>

    }

}