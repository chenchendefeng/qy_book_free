package com.freebookqy.application.mvp.model.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by leafye on 2019/5/5.
 * 章节
 */
class Chapter:Serializable {


    var isSelected:Boolean = false
    /**
     * 书籍id
     */
    @SerializedName("bid")
    var bid:Int = 0
    /**
     * 章节标题
     */
    @SerializedName("chapterTitle")
    var chapterTitle:String = ""
    /**
     * 章节ID
     */
    @SerializedName("cid")
    var cid:Int = 0
    /**
     * 排序
     */
    @SerializedName("displayOrder")
    var displayOrder:Int = 0

    @SerializedName("id")
    var id:Int = 0
    /**
     *
     * 是否导入内容 （0：否 | 1：是）
     * @link IMPORT_OFF
     * @link IMPORT_ON
     */
    @SerializedName("importContent")
    var importContent:Int =0

    /**
     * 原书籍ID
     */
    @SerializedName("originalBid")
    var originalBid:Int = 0
    /**
     * 修改时间
     */
    @SerializedName("updateTime")
    var updateTime:Long = 0
    /**
     * vip  id
     */
    @SerializedName("vid")
    var vid:Int = 0
    /**
     * VIP状态 （0：否 | 1：是）
     */
    @SerializedName("vipStatus")
    var vipStatus:Int = 0
    /**
     * 字数
     */
    @SerializedName("wordNum")
    var  wordNum:Int = 0

    @SerializedName("ossUrl")
    var ossUrl:String = ""


    companion object {
        /**
         * 是否导入内容 否
         */
        const val IMPORT_OFF = 0
        /**
         * 是否导入内容 是
         */
        const val IMPORT_ON = 1

    }


}