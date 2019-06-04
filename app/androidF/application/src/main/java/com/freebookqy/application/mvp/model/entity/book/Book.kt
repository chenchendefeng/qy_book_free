package com.freebookqy.application.mvp.model.entity.book

import android.support.annotation.IntDef
import com.freebookqy.application.mvp.model.dao.CollBookBean
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019/4/30.
 */
class Book : Serializable {

    @SerializedName("bid")
    var bid: Int = 0
    /**
     * 分类
     */
    @SerializedName("category")
    var category: String = ""
    /**
     * 章节数
     */
    @SerializedName("chapterCount")
    var chapterCount: Int = 0
    /**
     * 封面图
     */
    @SerializedName("coverImg")
    var bookCovers: String = ""
    /**
     *描述
     */
    @SerializedName("description")
    var description: String = ""
    /**
     *@link FINISH_FLAG_SERIAL
     * @link FINISH_FLAG_FINISH
     */
    @SerializedName("finishFlag")
    var finishFlag: Int = 0
    /**
     * 书名
     */
    @SerializedName("name")
    var bookName: String = ""
    /**
     * 作者
     */
    @SerializedName("author")
    var author: String = ""

    @SerializedName("id")
    var id: Int = 0
    /**
     * 原书籍ID
     */
    @SerializedName("originalBid")
    var originalBid: Int = 0
    /**
     * 关键字
     */
    @SerializedName("keywords")
    var keywords: String = ""


    /**
     * 最近修改时间
     */
    @SerializedName("lastUpdateTime")
    var lastUpdateTime: Long = 0
    /**
     * 已读
     */
    @SerializedName("readedCount")
    var readedCount: Int = 0
    /**
     * 在读
     */
    @SerializedName("readingCount")
    var readingCount: Int = 0
    /**
     * 收藏
     */
    @SerializedName("collectionCount")
    var collectionCount: Int = 0

    /**
     * 书籍状态
     * 上架状态 （0：下架 | 1：上架）
     * @link SHELF_STATUS_OFF
     * @link SHELF_STATUS_ON
     */
    @ShelfStatus
    @SerializedName("shelfStatus")
    var shelfStatus: Int = 0
    /**
     * 书籍来源 （ twoCloo : 二层楼 | tadu：塔读 ）
     */
    @SerializedName("source")
    var source: String = ""
    /**
     * 总字数
     */
    @SerializedName("totalWordCount")
    var totalWordCount: Int = 0

    var allwords: String = ""

    var amount: String = ""

    var lastReadChapterId: Int = 0

    /**
     * 读书进度
     */
    @SerializedName("")
    var readProgress: Int = 0

    /**
     * 获取书籍状态 已完结/连载中
     */
    fun getFinishFlagStatus(): String {
        return when (finishFlag) {
            FinishFlag.FINISH_FLAG_FINISH -> "已完结"
            FinishFlag.FINISH_FLAG_SERIAL -> "连载中"
            else -> ""
        }
    }

    @IntDef(
        FinishFlag.FINISH_FLAG_SERIAL,
        FinishFlag.FINISH_FLAG_FINISH
    )
    annotation class FinishFlag {
        companion object {

            const val ALL = -1
            /**
             * 连载
             */
            const val FINISH_FLAG_SERIAL = 0

            /**
             * 完结
             */
            const val FINISH_FLAG_FINISH = 1
        }
    }

    @IntDef(
        ShelfStatus.SHELF_STATUS_OFF,
        ShelfStatus.SHELF_STATUS_ON
    )
    annotation class ShelfStatus {
        companion object {
            /**
             * 下架
             */
            const val SHELF_STATUS_OFF = 0
            /**
             * 上架
             */
            const val SHELF_STATUS_ON = 1
        }
    }


    companion object {

        /**
         * 获取书籍来源
         */
        fun getBookSource(source: String): String {
            return when (source) {
                "twoCloo" -> "二层楼"
                "tadu" -> "塔读"
                else -> ""
            }
        }

    }

    private var collBookBean: CollBookBean? = null

    fun getCollBookBean(): CollBookBean {
        if (collBookBean == null) {
            collBookBean = createCollBookBean()
        }
        return collBookBean!!
    }

    fun createCollBookBean(): CollBookBean {
        val bean = CollBookBean()
        bean._id = "" + bid
        bean.title = bookName
        bean.author = author
        bean.shortIntro = description
        bean.cover = bookCovers
        //bean.setHasCp()
        //bean.setLatelyFollower(getLatelyFollower())
        //bean.retentionRatio = java.lang.Double.parseDouble(getRetentionRatio())
        //bean.updated = lastUpdateTime
        //bean.chaptersCount = getChaptersCount()
        //bean.lastChapter = getLastChapter()
        return bean
    }

}