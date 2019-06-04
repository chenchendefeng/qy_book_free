package com.wy.adbook.mvp.model.api.service

import android.support.annotation.StringDef
import com.wy.adbook.app.base.BaseEntity
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.mvp.model.api.Api
import com.wy.adbook.mvp.model.entity.*
import com.wy.adbook.mvp.model.entity.accout.*
import com.wy.adbook.mvp.model.entity.book.NetBook
import com.wy.adbook.mvp.model.entity.book.NetNewBookNumPerWeek
import com.wy.adbook.mvp.model.entity.book.NetPutOn
import com.wy.adbook.mvp.model.entity.book.NetRemove
import com.wy.adbook.mvp.model.entity.friend.NetAddFriend
import com.wy.adbook.mvp.model.entity.update.NetVersionCheck
import com.wy.adbook.mvp.model.entity.update.NetVersionCheckUpdate
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by leafye on 2019/4/29.
 */
interface QYService {

    companion object {

        const val BOOK_SHELF_PAGE_LIST = "bookShelf/pageList"
        const val BOOK_SUBJECT_LIST_BY_SUBJECT_TYPE = "bookSubject/listBySubjectType"
        const val API_BANNER_LIST = "api/banner/list"
        const val BOOK_CATEGORY_PAGE_LIST_BY_SEX_TYPE = "bookCategory/pageListBySexType"
    }

    @GET("")
    fun setGender(): Observable<BaseEntity<SetGender>>

    @FormUrlEncoded
    @POST(BOOK_SHELF_PAGE_LIST)
    fun pageList(
        @Field("pageNo") pageNo: Int = 0,
        @Field("pageSize") pageSize: Int = 0,
        @Field("uid") uid: Int
    ): Observable<NetBookcase>

    @FormUrlEncoded
    @POST("bookInfo/pageListGuessYouLike")
    fun pageListGuessYouLike(
        @Field("pageNo") pageNo: Int,
        @Field("pageSize") pageSize: Int
    ): Observable<NetGuessYouLike>

    /**
     * 加入书架
     */
    @FormUrlEncoded
    @POST("bookShelf/putOn")
    fun putOn(
        @Field("uid") uid: Int = 0,
        @Field("bid") bid: Int = 0
    ): Observable<NetPutOn>

    /**
     * 移除书架
     */
    @FormUrlEncoded
    @POST("bookShelf/remove")
    fun remove(
        @Field("uid") uid: Int = 0,
        @Field("bid") bid: Int = 0
    ): Observable<NetRemove>


    /**
     * 按类型查询书籍专题
     * @subjectType boy|girl|recommend request
     * @sexMark boy|girl noRequest
     */
    @FormUrlEncoded
    @POST(BOOK_SUBJECT_LIST_BY_SUBJECT_TYPE)
    fun listBySubjectType(
        @Field("subjectType") subjectType: String,
        @Field("sexMark") sexMark: String = ""
    ): Observable<NetSubjectType>

    /**
     * 查询分类
     */
    @FormUrlEncoded
    @POST("")
    fun categoryData(): Observable<NetClassification>

    /**
     * 大家都在看（同分类阅读量最高的 前 3 本）
     */
    @FormUrlEncoded
    @POST("bookInfo/pageListTogetherRead")
    fun pageListTogetherRead(
        @Field("pageNo") pageNo: Int,
        @Field("pageSize") pageSize: Int,
        @Field("category") category: String
    ): Observable<NetTogetherRead>

    /**
     * 书籍封面
     */
    @FormUrlEncoded
    @POST("bookInfo/cover")
    fun bookCover(
        @Field("bid") bid: Int
    ): Observable<NetBook>

    /**
     * 书籍详情
     */
    @FormUrlEncoded
    @POST("bookInfo/detail")
    fun bookDetail(
        @Field("bid") bid: Int
    ): Observable<NetBook>

    /**
     * 每周新增书籍数
     */
    @POST("bookInfo/newBookNumPerWeek")
    fun newBookNumPerWeek(): Observable<NetNewBookNumPerWeek>

    /**
     * @param finishFlag 1 完结 0 连载
     */
    @FormUrlEncoded
    @POST("bookCategory/pageListByBookClass")
    fun pageListByBookClass(
        @Field("pageNo") pageNo: Int,
        @Field("pageSize") pageSize: Int,
        @Field("finishFlag") finishFlag: Int,
        @Field("className") className: String
    ): Observable<NetPageListByBookClass>

    @StringDef(
        NetGenderParam.BOY,
        NetGenderParam.GIRL
    )
    annotation class NetGenderParam {

        companion object {
            const val BOY = "boy"
            const val GIRL = "girl"
        }
    }


    /**
     * 书籍分类列表（按男生女生分类）
     */
    @FormUrlEncoded
    @POST(BOOK_CATEGORY_PAGE_LIST_BY_SEX_TYPE)
    fun pageListBySexType(
        @Field("pageNo") pageNo: Int,
        @Field("pageSize") pageSize: Int,
        @Field("sexType") sexType: String
    ): Observable<NetClassification>

    /**
     * 退出
     */
    @FormUrlEncoded
    @Headers("Domain-Name: ${Api.APP_DOMAIN_KEY_2}")
    @POST("main/logout")
    fun logout(
        @Field("cuId") cuId: Int,
        @Field("userToken") userToken: String
    ): Observable<NetLogOut>

    /**
     * 手机登录
     */
    @FormUrlEncoded
    @Headers("Domain-Name: ${Api.APP_DOMAIN_KEY_2}")
    @POST("main/phoneLogin")
    fun phoneLogin(
        @Field("phone") phone: String,
        @Field("zone") zone: String,
        @Field("code") code: String,
        @Field("imei") imei: String,
        @Field("source") source: String,
        @Field("channel") channel: String
    ): Observable<NetPhoneLoginSuccess>

    /**
     * 游客登录
     */
    @FormUrlEncoded
    @POST("main/visitorLogin")
    @Headers("Domain-Name: ${Api.APP_DOMAIN_KEY_2}")
    fun visitorLogin(
        @Field("imei") imei: String,
        @Field("source") source: String,
        @Field("channel") channel: String
    ): Observable<NetVisitorLoginSuccess>

    /**
     * 微信登录
     */
    @FormUrlEncoded
    @POST("main/wechatLogin")
    @Headers("Domain-Name: ${Api.APP_DOMAIN_KEY_2}")
    fun mainwechatLogin(
        @Field("code") code: String,
        @Field("imei") imei: String,
        @Field("source") source: String,
        @Field("channel") channel: String
    ): Observable<NetWechatLoginSuccess>

    /**
     * 个人中心选项集合
     */
    @FormUrlEncoded
    @Headers("Domain-Name: ${Api.APP_DOMAIN_KEY_2}")
    @POST("personalCenter/page")
    fun personalCenterPage(
        @Field("cuId") cuId: Int
    ): Observable<NetPersonalCenterPage>

    /**
     * 账户信息
     */
    @POST("my-wallet/balance")
    @Headers("Domain-Name: ${Api.APP_DOMAIN_KEY_2}")
    fun balance(
        @Query("cuId") cuid: Int
    ): Observable<NetBalance>

    /**
     * 奖励
     */
    @FormUrlEncoded
    @POST("award-register/award")
    fun registerAward(
        @Field("cuid") cuid: Int
    ): Observable<NetRegisterAward>

    /**
     * 账户流水
     */
    @POST("account-flow/page")
    @Headers("Domain-Name: ${Api.APP_DOMAIN_KEY_2}")
    fun accountFLowPage(
        @Query("cuId") cuId: Int,
        @Query("currencyType") currencyType: String,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<NetFlowPage>


    @GET("search/list")
    fun search(
        @Query("wd") wd: String,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<NetSearchResult>

    /**
     * 获取章节列表
     */
    @FormUrlEncoded
    @POST("chapter/listChapter")
    fun listChapter(
        @Field("bid") bid: Int
    ): Observable<NetChapterList>

    /**
     * 获取章节内容详情
     */
    @FormUrlEncoded
    @POST("chapter/chapterContent")
    fun chapterContent(
        @Field("bid") bid: Int,
        @Field("cid") cid: Int
    ): Observable<NetChapter>

    /**
     * 获取用户信息
     */
    @Headers("Domain-Name: ${Api.APP_DOMAIN_KEY_2}")
    @POST("customer/getCustomerBizInfo")
    fun getCustomeBizInfo(
        @Query("cuId") cid: Int
    ): Observable<NetUserInfo>

    /**
     * 请求banner列表
     */
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    @GET(API_BANNER_LIST)
    fun bannerList(
        @Query("systemType") systemType: String,
        @Constant.NetBannerPosition
        @Query("position") position: String,
        @Query("channel") channel: String
    ): Observable<NetBanner>


    @Headers("Domain-name:${Api.APP_DOMAIN_KEY_6}")
    @GET("welfare/list")
    fun welfareList(
        @Query("cuId") cid: Int
    ): Observable<NetWelfare>

    /**
     * 看视频免广告20分钟
     */
    @FormUrlEncoded
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    @POST("welfare/watchForFreeAdv")
    fun watchForFreeAdv(
        @Field("cuId") cuId: Int
    ): Observable<NetWatchForFreeAdv>

    /**
     *每日分享奖励金豆
     */
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    @POST("welfare/watchForGole")
    fun watchForGole(
        @Query("cuId") cuId: Int
    ): Observable<NetWatchForGole>


    //签到相关----------------------------
    /**
     * 补签
     */
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    @POST("attendance/compensateSign")
    fun compensateSign(
        @Query("cuId") cuId: Int,
        @Query("date") date: String
    ): Observable<NetCompensateSign>

    /**
     * 签到
     */
    @FormUrlEncoded
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    @POST("attendance/sign")
    fun sign(
        @Field("cuId") cuid: Int
    ): Observable<NetSign>

    /**
     * 签到日历
     */
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    @POST("attendance/page")
    fun attendancePage(
        @Query("cuId") cuid: Int
    ): Observable<NetAttendancePage>

    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    @POST("attendance/status")
    fun attendanceStatus(
        @Query("cuId") cuId: Int
    ): Observable<NetAttendanceStatus>


    //签到相关----------------------------end


    //书籍统计-------------------------------

    @FormUrlEncoded
    @POST("bookhot/statistics")
    fun statistics(
        @Field("bid") bid: Int,
        @Field("type") type: String
    ): Observable<NetStatistics>


    @FormUrlEncoded
    @POST("startPage/getCurStartPage")
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    fun getCurStartPage(
        @Field("clientType") clientType: String,
        @Field("channelCode") channelCode: String
    ): Observable<NetStartPage>

    /**
     * 读书进度
     */
    @FormUrlEncoded
    @POST("read-process/update")
    fun updateBookProgress(
        @Field("cuId") cuId: Int,
        @Field("bid") bid: Int,
        @Field("cid") cid: Int,
        @Field("readWords") readWords: Int
    ): Observable<NetBookProgress>

    /**
     * 获取30秒阅读福利
     * 读书界面每30s调用一次
     */
    @FormUrlEncoded
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    @POST("welfareRead/get30sWelfareRead")
    fun get30sWelfareRead(
        @Field("cuId") cuId: Int
    ): Observable<NetGet30sWelfareRead>

    /**
     * 领取补签机会
     */
    @FormUrlEncoded
    @POST("compensate-chance/receive")
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    fun compensateChanceReceive(
        @Field("cuId") cuId: Int,
        @Field("type") type: String
    ): Observable<NetCompensateChance>

    @POST("welfare/videoForGole")
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    fun videoForGole(
        @Query("cuid") cuid: Int
    ): Observable<NetVideoForGole>

    /**
     * 填写邀请码
     */
    @POST("invitation/fillInCode")
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_2}")
    fun fillInCode(
        @Query("cuId") cuId: Int,
        @Query("invitationCode") invitationCode: String
    ): Observable<NetInvitationCode>

    //足迹
    @POST("read-footprint/record")
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_2}")
    fun readFooterRecord(
        @Query("cuId") cuId: Int,
        @Query("bid") bid: Int
    ): Observable<NetReadFooterRecord>

    @POST("read-footprint/getPage")
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_2}")
    fun getReadFooterPage(
        @Query("cuId") cuId: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<NetReadFooterPage>

    @POST("read-footprint/delete")
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_2}")
    fun deleteReadFooter(
        @Query("id") id: Int
    ): Observable<NetDeleteReadFooter>

    @GET("api/faq/list")
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_2}")
    fun faqList(
        @Query("channle") channle: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<NetFaqList>

    @POST("friend/page")
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_2}")
    fun friendPage(
        @Query("cuId") cuId: Int,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<NetFriendPage>

    /**
     * 添加朋友
     */
    @POST("friend/add")
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_2}")
    fun addFriend(
        @Query("cuId") cuId:Int,
        @Query("fuId") fuId:Int
    ):Observable<NetAddFriend>

    /**
     * 检查审核
     */
    @POST("version/check")
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_2}")
    fun versionCheck(
        @Query("versionCode") versionCode: String,
        @Query("clientType") clientType: String
    ): Observable<NetVersionCheck>

    /**
     * 检查更新
     */
    @POST("version/checkUpdate")
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_2}")
    fun versionCheckUpdate(
        @Query("versionCode") versionCode: String,
        @Query("clientType") clientType: String
    ): Observable<NetVersionCheckUpdate>

    @POST("")
    fun changeNickname(
        @Query("cuId") cuid:Int,
        @Query("nickname") nickname:String
    ):Observable<NetChangeNick>


}