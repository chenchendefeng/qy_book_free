package com.wy.adbook.app.constant

import android.support.annotation.IntDef
import android.support.annotation.StringDef
import com.freebookqy.application.BuildConfig
import com.freebookqy.utilslib.FileUtils
import com.wy.adbook.mvp.view.web.callback.QYJsCallJava
import java.io.File

/**
 * Created by leafye on 2019/4/29.
 */
class Constant {

    @IntDef(
        ShareType.SHARE_TYPE_QQ,
        ShareType.SHARE_TYPE_WX_HY,
        ShareType.SHARE_TYPE_WX_PYQ
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class ShareType {
        companion object {
            const val SHARE_TYPE_WX_HY = 0
            const val SHARE_TYPE_WX_PYQ = 1
            const val SHARE_TYPE_QQ = 2
            const val SHARE_TYPE_FACE_TO_FACE = 3
            const val SHARE_TYPE_QQ_ZONE = 4
        }
    }

    /**
     * 性别
     */
    @IntDef(Gender.MALE, Gender.FEMALE)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Gender {
        companion object {
            const val NO_GENDER = -1

            const val MALE = 0

            const val FEMALE = 1
        }
    }

    companion object {
        //----------配置数据--------------
        /**
         * 登录源 都是Android
         */
        const val DEF_SOURCE = "Android"

        /**
         * 连续签到最高可获得的金豆数
         */
        const val maxSignGoldBean: Int = 10000
        //-------------------------------

        /**
         * 微信的appId
         * ad: wx1f9ae90e23e42cb7
         * qy: wx08ad162781657c74
         */
        const val APP_ID_WX = "wx1f9ae90e23e42cb7"
        /**
         * qq id
         */
        const val QQ_APP_ID = ""


        const val PAGE_SIZE = 10
        /**
         * 默认的电话前缀
         */
        const val DEF_PHONE_ZONE = "+86"

        /**
         * 书籍的存储路径
         */
        @JvmStatic
        val BOOK_CACHE_PATH = (FileUtils.getCachePath() + File.separator
                + "book_cache" + File.separator)

        @JvmStatic
        val FORMAT_BOOK_DATE = "yyyy-MM-dd'T'HH:mm:ss"

        @JvmStatic
        val FORMAT_TIME = "HH:mm"


        /**
         * js调java方法协议
         */
        const val JS_CALL_JAVA_PROTOCOL = "qywebkit"

        /**
         * 注入WebView中供js上下文调用的java类
         */
        val INJECT_INTO_WEB_VIEW_CLASS: Class<*> = QYJsCallJava::class.java

        /**
         * WebView是否可以调试
         */
        const val WEB_DEBUGABLE = BuildConfig.WEB_DEBUG

        /**
         * 阅读福利中,阅读xx秒获得奖励
         */
        const val readSecondsToGetReward = 30
        /**
         * 查看视频获取的跳过广告时间
         */
        const val watchingVideoGetSkipAdTimeMinute = 20
        /**
         * 每日分享可获得的金豆
         */
        const val shareGetRewardNum = 100

        const val readLevelReward1 = 30
        const val readLevelReward2 = 60
        const val readLevelReward3 = 80
        const val readLevelReward4 = 100


        const val readLevelMinute1 = 30
        const val readLevelMinute2 = 60
        const val readLevelMinute3 = 90
        const val readLevelMinute4 = 120


    }

    /**
     * 网络请求banner的position
     */
    @StringDef(
        NetBannerPosition.BOOK_STORE,
        NetBannerPosition.CHOICE,
        NetBannerPosition.READER_GUIDING
    )
    annotation class NetBannerPosition {
        companion object {
            /**
             * 书库
             */
            const val BOOK_STORE = "bookStore"
            /**
             * 精选
             */
            const val CHOICE = "choice"
            /**
             * 导读
             */
            const val READER_GUIDING = "readerGuiding"
        }
    }


    /**
     * vip状态
     */
    class VipStatus {

        companion object {
            /**
             * vip 是
             */
            @JvmStatic
            val VIP_STATUS_YES = 1
            /**
             * vip 否
             */
            @JvmStatic
            val VIP_STATUS_NO = 0
        }
    }

    /**
     * 背景颜色设置
     */
    @IntDef(
        BookBgColor.BG_YELLOW,
        BookBgColor.BG_GREEN,
        BookBgColor.BG_BLUE,
        BookBgColor.BG_PINK,
        BookBgColor.BG_BLACK
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class BookBgColor {
        companion object {
            const val BG_YELLOW = 0
            const val BG_GREEN = 1
            const val BG_BLUE = 2
            const val BG_PINK = 3
            const val BG_BLACK = 4
        }
    }

    /**
     * 翻页滚动效果
     */
    @IntDef(
        BookPageTurn.UP_DOWN,
        BookPageTurn.SMOOTH,
        BookPageTurn.SIMULATION,
        BookPageTurn.AUTOMATIC
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class BookPageTurn {
        companion object {
            const val UP_DOWN = 0
            const val SMOOTH = 1
            const val SIMULATION = 2
            const val AUTOMATIC = 3
        }
    }

}