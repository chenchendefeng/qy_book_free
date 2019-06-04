package com.freebookqy.application.mvp.model.api.service

import android.support.annotation.StringDef
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.constant.Constant
import com.freebookqy.application.mvp.model.api.Api
import com.freebookqy.application.mvp.model.entity.*
import com.freebookqy.application.mvp.model.entity.accout.*
import com.freebookqy.application.mvp.model.entity.book.Book
import com.freebookqy.application.mvp.model.entity.book.PutOn
import com.freebookqy.application.mvp.model.entity.book.Remove
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by leafye on 2019/4/29.
 */
interface QYService {

    @GET("")
    fun setGender(): Observable<BaseEntity<SetGender>>

    @FormUrlEncoded
    @POST("bookShelf/pageList")
    fun pageList(
        @Field("pageNo") pageNo: Int = 0,
        @Field("pageSize") pageSize: Int = 0,
        @Field("uid") uid: Int
    ): Observable<BaseEntity<Bookcase>>

    @FormUrlEncoded
    @POST("bookInfo/pageListGuessYouLike")
    fun pageListGuessYouLike(
        @Field("pageNo") pageNo: Int,
        @Field("pageSize") pageSize: Int
    ): Observable<BaseEntity<GuessYouLike>>

    /**
     * 加入书架
     */
    @FormUrlEncoded
    @POST("bookShelf/putOn")
    fun putOn(
        @Field("uid") uid: Int = 0,
        @Field("bid") bid: Int = 0
    ): Observable<BaseEntity<PutOn>>

    /**
     * 移除书架
     */
    @FormUrlEncoded
    @POST("bookShelf/remove")
    fun remove(
        @Field("uid") uid: Int = 0,
        @Field("bid") bid: Int = 0
    ): Observable<BaseEntity<Remove>>


    /**
     * 按类型查询书籍专题
     * @subjectType boy|girl|recommend request
     * @sexMark boy|girl noRequest
     */
    @FormUrlEncoded
    @POST("bookSubject/listBySubjectType")
    fun listBySubjectType(
        @Field("subjectType") subjectType: String,
        @Field("sexMark") sexMark: String = ""
    ): Observable<BaseEntity<MutableList<SubjectType>>>

    /**
     * 查询分类
     */
    @FormUrlEncoded
    @POST("")
    fun categoryData(): Observable<BaseEntity<MutableList<Classification>>>

    /**
     * 大家都在看（同分类阅读量最高的 前 3 本）
     */
    @FormUrlEncoded
    @POST("bookInfo/pageListTogetherRead")
    fun pageListTogetherRead(
        @Field("pageNo") pageNo: Int,
        @Field("pageSize") pageSize: Int,
        @Field("category") category: String
    ): Observable<BaseEntity<TogetherRead>>

    /**
     * 书籍封面
     */
    @FormUrlEncoded
    @POST("bookInfo/cover")
    fun bookCover(
        @Field("bid") bid: Int
    ): Observable<BaseEntity<Book>>

    /**
     * 书籍详情
     */
    @FormUrlEncoded
    @POST("bookInfo/detail")
    fun bookDetail(
        @Field("bid") bid: Int
    ): Observable<BaseEntity<Book>>

    /**
     * 每周新增书籍数
     */
    @POST("bookInfo/newBookNumPerWeek")
    fun newBookNumPerWeek(): Observable<BaseEntity<Int>>

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
    ): Observable<BaseEntity<PageListByBookClass>>

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
    @POST("bookCategory/pageListBySexType")
    fun pageListBySexType(
        @Field("pageNo") pageNo: Int,
        @Field("pageSize") pageSize: Int,
        @Field("sexType") sexType: String
    ): Observable<BaseEntity<Classification>>

    /**
     * 退出
     */
    @FormUrlEncoded
    @POST("main/logout")
    fun logiut(
        @Field("cuId") cuId: Int,
        @Field("userToken") userToken: String
    ): Observable<BaseEntity<LogOut>>

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
    ): Observable<BaseEntity<PhoneLoginSuccess>>

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
    ): Observable<BaseEntity<VisitorLoginSuccess>>

    /**
     * 微信登录
     */
    @FormUrlEncoded
    @POST("main/wechatLogin")
    fun mainwechatLogin(
        @Field("code") code: String,
        @Field("imei") imei: String,
        @Field("source") source: String,
        @Field("channel") channel: String
    ): Observable<BaseEntity<WechatLoginSuccess>>

    /**
     * 个人中心选项集合
     */
    @FormUrlEncoded
    @Headers("Domain-Name: ${Api.APP_DOMAIN_KEY_2}")
    @POST("personalCenter/page")
    fun personalCenterPage(
        @Field("cuId") cuId: Int
    ): Observable<BaseEntity<PersonalCenterPage>>

    /**
     * 账户信息
     */
    @FormUrlEncoded
    @POST("my-wallet/balance")
    fun balance(
        @Field("cuid") cuid: Int
    ): Observable<BaseEntity<Balance>>

    /**
     * 奖励
     */
    @FormUrlEncoded
    @POST("award-register/award")
    fun registerAward(
        @Field("cuid") cuid: Int
    ): Observable<BaseEntity<RegisterAward>>

    /**
     * 账户流水
     */
    @FormUrlEncoded
    @POST("account-flow/page")
    fun accountFLowPage(
        @Field("cuId") cuId: Int,
        @Field("currencyType") currencyType: String,
        @Field("pageNo") pageNo: Int,
        @Field("pageSize") pageSize: Int
    ): Observable<BaseEntity<AccountFlowPage>>


    @GET("search/list")
    fun search(
        @Query("wd") wd: String,
        @Query("pageNo") pageNo: Int,
        @Query("pageSize") pageSize: Int
    ): Observable<BaseEntity<SearchResult>>

    /**
     * 获取章节列表
     */
    @FormUrlEncoded
    @POST("chapter/listChapter")
    fun listChapter(
        @Field("bid") bid: Int
    ): Observable<BaseEntity<MutableList<Chapter>>>

    /**
     * 获取章节内容详情
     */
    @FormUrlEncoded
    @POST("chapter/chapterContent")
    fun chapterContent(
        @Field("bid") bid: Int,
        @Field("cid") cid: Int
    ): Observable<BaseEntity<Chapter>>

    /**
     * 获取用户信息
     */
    @FormUrlEncoded
    @Headers("Domain-Name: ${Api.APP_DOMAIN_KEY_2}")
    @POST("customer/getCustomerBizInfo")
    fun getCustomeBizInfo(
        @Field("cid") cid: String
    ): Observable<BaseEntity<UserInfo>>

    /**
     * 请求banner列表
     */
    @FormUrlEncoded
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    @POST("api/banner/list")
    fun bannerList(
        @Field("systemType") systemType: String,
        @Constant.NetBannerPosition
        @Field("position") position: String,
        @Field("channel") channel: String
    ): Observable<BaseEntity<Any>>


    @Headers("Domain-name:${Api.APP_DOMAIN_KEY_6}")
    @GET("welfare/list")
    fun welfareList(
        @Query("cuId") cid: Int
    ): Observable<BaseEntity<Welfare>>

    /**
     * 看视频免广告20分钟
     */
    @FormUrlEncoded
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    @POST("welfare/watchForFreeAdv")
    fun watchForFreeAdv(
        @Field("cuId") cuId: Int
    ): Observable<BaseEntity<WatchForFreeAdv>>


    //签到相关----------------------------
    /**
     * 补签
     */
    @FormUrlEncoded
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    @POST("attendance/compensateSign")
    fun compensateSign(
        @Field("cuId") cuId: Int,
        @Field("date") date: String
    ): Observable<BaseEntity<CompensateSign>>

    /**
     * 签到
     */
    @FormUrlEncoded
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    @POST("attendance/sign")
    fun sign(
        @Field("cuid") cuid: Int
    ): Observable<BaseEntity<Sign>>

    /**
     * 签到日历
     */
    @FormUrlEncoded
    @Headers("Domain-Name:${Api.APP_DOMAIN_KEY_6}")
    @POST("attendance/page")
    fun attendancePage(
        @Field("cuid") cuid: Int
    ): Observable<BaseEntity<AttendancePage>>


    //签到相关----------------------------end



    //书籍统计-------------------------------

    @FormUrlEncoded
    @POST("bookhot/statistics")
    fun statistics(
        @Field("bid") bid:Int,
        @Field("type") type:String
    ):Observable<BaseEntity<Statistics>>




}