package com.freebookqy.application.mvp.model.entity

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
     * 书籍状态
     * 上架状态 （0：下架 | 1：上架）
     * @link SHELF_STATUS_OFF
     * @link SHELF_STATUS_ON
     */
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
            Book.FINISH_FLAG_FINISH -> "已完结"
            else -> "连载中"
        }
    }


    companion object {
        /**
         * 连载
         */
        const val FINISH_FLAG_SERIAL = 0

        /**
         * 完结
         */
        const val FINISH_FLAG_FINISH = 1

        /**
         * 下架
         */
        const val SHELF_STATUS_OFF = 0
        /**
         * 上架
         */
        const val SHELF_STATUS_ON = 1

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

}