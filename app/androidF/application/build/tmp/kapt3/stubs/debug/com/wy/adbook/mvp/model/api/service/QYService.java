package com.wy.adbook.mvp.model.api.service;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00e8\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u008a\u00012\u00020\u0001:\u0004\u008a\u0001\u008b\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H\'J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u0006H\'J\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u0006H\'J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u0006H\'J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0017\u001a\u00020\b2\b\b\u0001\u0010\u0018\u001a\u00020\b2\b\b\u0001\u0010\u0019\u001a\u00020\bH\'J\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u0006H\'J\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u0006H\'J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0003H\'J\"\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\bH\'J\"\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u00062\b\b\u0001\u0010%\u001a\u00020\u0006H\'J\"\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010(\u001a\u00020\bH\'J\"\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010+\u001a\u00020\bH\'J\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00032\b\b\u0001\u0010.\u001a\u00020\u0006H\'J,\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00032\b\b\u0001\u00101\u001a\u00020\b2\b\b\u0001\u00102\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H\'J\"\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u00105\u001a\u00020\bH\'J,\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H\'J\u0018\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\"\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00032\b\b\u0001\u0010<\u001a\u00020\b2\b\b\u0001\u0010=\u001a\u00020\bH\'J\u0018\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u00032\b\b\u0001\u0010%\u001a\u00020\u0006H\'J,\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H\'J\"\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00032\b\b\u0001\u0010D\u001a\u00020\b2\b\b\u0003\u0010E\u001a\u00020\bH\'J\u0018\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u0006H\'J\"\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010J\u001a\u00020\bH\'J6\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u00032\b\b\u0001\u0010M\u001a\u00020\b2\b\b\u0001\u0010N\u001a\u00020\b2\b\b\u0001\u0010O\u001a\u00020\b2\b\b\u0001\u0010\u0019\u001a\u00020\bH\'J\u000e\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u0003H\'J,\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u00032\b\b\u0003\u0010\t\u001a\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010T\u001a\u00020\u0006H\'J6\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u00032\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010W\u001a\u00020\u00062\b\b\u0001\u0010X\u001a\u00020\bH\'J,\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010Z\u001a\u00020\bH\'J\"\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0\u00032\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H\'J,\u0010]\u001a\b\u0012\u0004\u0012\u00020^0\u00032\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010_\u001a\u00020\bH\'J\u0018\u0010`\u001a\b\u0012\u0004\u0012\u00020a0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'JJ\u0010b\u001a\b\u0012\u0004\u0012\u00020c0\u00032\b\b\u0001\u0010d\u001a\u00020\b2\b\b\u0001\u0010e\u001a\u00020\b2\b\b\u0001\u0010M\u001a\u00020\b2\b\b\u0001\u0010N\u001a\u00020\b2\b\b\u0001\u0010O\u001a\u00020\b2\b\b\u0001\u0010\u0019\u001a\u00020\bH\'J\"\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u00032\b\b\u0003\u0010T\u001a\u00020\u00062\b\b\u0003\u0010\u001c\u001a\u00020\u0006H\'J\"\u0010h\u001a\b\u0012\u0004\u0012\u00020i0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u001c\u001a\u00020\u0006H\'J\u0018\u0010j\u001a\b\u0012\u0004\u0012\u00020k0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u0006H\'J\"\u0010l\u001a\b\u0012\u0004\u0012\u00020m0\u00032\b\b\u0003\u0010T\u001a\u00020\u00062\b\b\u0003\u0010\u001c\u001a\u00020\u0006H\'J,\u0010n\u001a\b\u0012\u0004\u0012\u00020o0\u00032\b\b\u0001\u0010p\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H\'J\u0014\u0010q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020s0r0\u0003H\'J\u0018\u0010t\u001a\b\u0012\u0004\u0012\u00020u0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u0006H\'J\"\u0010v\u001a\b\u0012\u0004\u0012\u00020w0\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u00062\b\b\u0001\u0010(\u001a\u00020\bH\'J6\u0010x\u001a\b\u0012\u0004\u0012\u00020y0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u001c\u001a\u00020\u00062\b\b\u0001\u0010%\u001a\u00020\u00062\b\b\u0001\u0010z\u001a\u00020\u0006H\'J\"\u0010{\u001a\b\u0012\u0004\u0012\u00020|0\u00032\b\b\u0001\u0010}\u001a\u00020\b2\b\b\u0001\u0010<\u001a\u00020\bH\'J\"\u0010~\u001a\b\u0012\u0004\u0012\u00020\u007f0\u00032\b\b\u0001\u0010}\u001a\u00020\b2\b\b\u0001\u0010<\u001a\u00020\bH\'J\u001a\u0010\u0080\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u0006H\'J.\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010\u00032\b\b\u0001\u0010N\u001a\u00020\b2\b\b\u0001\u0010O\u001a\u00020\b2\b\b\u0001\u0010\u0019\u001a\u00020\bH\'J\u001a\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u001a\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u001a\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010\u00032\b\b\u0001\u0010%\u001a\u00020\u0006H\'\u00a8\u0006\u008c\u0001"}, d2 = {"Lcom/wy/adbook/mvp/model/api/service/QYService;", "", "accountFLowPage", "Lio/reactivex/Observable;", "Lcom/wy/adbook/mvp/model/entity/accout/NetFlowPage;", "cuId", "", "currencyType", "", "pageNo", "pageSize", "addFriend", "Lcom/wy/adbook/mvp/model/entity/friend/NetAddFriend;", "fuId", "attendancePage", "Lcom/wy/adbook/mvp/model/entity/accout/NetAttendancePage;", "cuid", "attendanceStatus", "Lcom/wy/adbook/mvp/model/entity/NetAttendanceStatus;", "balance", "Lcom/wy/adbook/mvp/model/entity/accout/NetBalance;", "bannerList", "Lcom/wy/adbook/mvp/model/entity/NetBanner;", "systemType", "position", "channel", "bookCover", "Lcom/wy/adbook/mvp/model/entity/book/NetBook;", "bid", "bookDetail", "categoryData", "Lcom/wy/adbook/mvp/model/entity/NetClassification;", "changeNickname", "Lcom/wy/adbook/mvp/model/entity/accout/NetChangeNick;", "nickname", "chapterContent", "Lcom/wy/adbook/mvp/model/entity/NetChapter;", "cid", "compensateChanceReceive", "Lcom/wy/adbook/mvp/model/entity/NetCompensateChance;", "type", "compensateSign", "Lcom/wy/adbook/mvp/model/entity/accout/NetCompensateSign;", "date", "deleteReadFooter", "Lcom/wy/adbook/mvp/model/entity/NetDeleteReadFooter;", "id", "faqList", "Lcom/wy/adbook/mvp/model/entity/NetFaqList;", "channle", "page", "fillInCode", "Lcom/wy/adbook/mvp/model/entity/NetInvitationCode;", "invitationCode", "friendPage", "Lcom/wy/adbook/mvp/model/entity/NetFriendPage;", "get30sWelfareRead", "Lcom/wy/adbook/mvp/model/entity/NetGet30sWelfareRead;", "getCurStartPage", "Lcom/wy/adbook/mvp/model/entity/NetStartPage;", "clientType", "channelCode", "getCustomeBizInfo", "Lcom/wy/adbook/mvp/model/entity/accout/NetUserInfo;", "getReadFooterPage", "Lcom/wy/adbook/mvp/model/entity/NetReadFooterPage;", "listBySubjectType", "Lcom/wy/adbook/mvp/model/entity/NetSubjectType;", "subjectType", "sexMark", "listChapter", "Lcom/wy/adbook/mvp/model/entity/NetChapterList;", "logout", "Lcom/wy/adbook/mvp/model/entity/accout/NetLogOut;", "userToken", "mainwechatLogin", "Lcom/wy/adbook/mvp/model/entity/accout/NetWechatLoginSuccess;", "code", "imei", "source", "newBookNumPerWeek", "Lcom/wy/adbook/mvp/model/entity/book/NetNewBookNumPerWeek;", "pageList", "Lcom/wy/adbook/mvp/model/entity/NetBookcase;", "uid", "pageListByBookClass", "Lcom/wy/adbook/mvp/model/entity/NetPageListByBookClass;", "finishFlag", "className", "pageListBySexType", "sexType", "pageListGuessYouLike", "Lcom/wy/adbook/mvp/model/entity/NetGuessYouLike;", "pageListTogetherRead", "Lcom/wy/adbook/mvp/model/entity/NetTogetherRead;", "category", "personalCenterPage", "Lcom/wy/adbook/mvp/model/entity/accout/NetPersonalCenterPage;", "phoneLogin", "Lcom/wy/adbook/mvp/model/entity/accout/NetPhoneLoginSuccess;", "phone", "zone", "putOn", "Lcom/wy/adbook/mvp/model/entity/book/NetPutOn;", "readFooterRecord", "Lcom/wy/adbook/mvp/model/entity/NetReadFooterRecord;", "registerAward", "Lcom/wy/adbook/mvp/model/entity/accout/NetRegisterAward;", "remove", "Lcom/wy/adbook/mvp/model/entity/book/NetRemove;", "search", "Lcom/wy/adbook/mvp/model/entity/NetSearchResult;", "wd", "setGender", "Lcom/wy/adbook/app/base/BaseEntity;", "Lcom/wy/adbook/mvp/model/entity/SetGender;", "sign", "Lcom/wy/adbook/mvp/model/entity/accout/NetSign;", "statistics", "Lcom/wy/adbook/mvp/model/entity/NetStatistics;", "updateBookProgress", "Lcom/wy/adbook/mvp/model/entity/NetBookProgress;", "readWords", "versionCheck", "Lcom/wy/adbook/mvp/model/entity/update/NetVersionCheck;", "versionCode", "versionCheckUpdate", "Lcom/wy/adbook/mvp/model/entity/update/NetVersionCheckUpdate;", "videoForGole", "Lcom/wy/adbook/mvp/model/entity/NetVideoForGole;", "visitorLogin", "Lcom/wy/adbook/mvp/model/entity/accout/NetVisitorLoginSuccess;", "watchForFreeAdv", "Lcom/wy/adbook/mvp/model/entity/NetWatchForFreeAdv;", "watchForGole", "Lcom/wy/adbook/mvp/model/entity/NetWatchForGole;", "welfareList", "Lcom/wy/adbook/mvp/model/entity/NetWelfare;", "Companion", "NetGenderParam", "application_debug"})
public abstract interface QYService {
    public static final com.wy.adbook.mvp.model.api.service.QYService.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOK_SHELF_PAGE_LIST = "bookShelf/pageList";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOK_SUBJECT_LIST_BY_SUBJECT_TYPE = "bookSubject/listBySubjectType";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String API_BANNER_LIST = "api/banner/list";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOK_CATEGORY_PAGE_LIST_BY_SEX_TYPE = "bookCategory/pageListBySexType";
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "")
    public abstract io.reactivex.Observable<com.wy.adbook.app.base.BaseEntity<com.wy.adbook.mvp.model.entity.SetGender>> setGender();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "bookShelf/pageList")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetBookcase> pageList(@retrofit2.http.Field(value = "pageNo")
    int pageNo, @retrofit2.http.Field(value = "pageSize")
    int pageSize, @retrofit2.http.Field(value = "uid")
    int uid);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "bookInfo/pageListGuessYouLike")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetGuessYouLike> pageListGuessYouLike(@retrofit2.http.Field(value = "pageNo")
    int pageNo, @retrofit2.http.Field(value = "pageSize")
    int pageSize);
    
    /**
     * * 加入书架
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "bookShelf/putOn")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetPutOn> putOn(@retrofit2.http.Field(value = "uid")
    int uid, @retrofit2.http.Field(value = "bid")
    int bid);
    
    /**
     * * 移除书架
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "bookShelf/remove")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetRemove> remove(@retrofit2.http.Field(value = "uid")
    int uid, @retrofit2.http.Field(value = "bid")
    int bid);
    
    /**
     * * 按类型查询书籍专题
     *     * @subjectType boy|girl|recommend request
     *     * @sexMark boy|girl noRequest
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "bookSubject/listBySubjectType")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetSubjectType> listBySubjectType(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "subjectType")
    java.lang.String subjectType, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "sexMark")
    java.lang.String sexMark);
    
    /**
     * * 查询分类
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetClassification> categoryData();
    
    /**
     * * 大家都在看（同分类阅读量最高的 前 3 本）
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "bookInfo/pageListTogetherRead")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetTogetherRead> pageListTogetherRead(@retrofit2.http.Field(value = "pageNo")
    int pageNo, @retrofit2.http.Field(value = "pageSize")
    int pageSize, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "category")
    java.lang.String category);
    
    /**
     * * 书籍封面
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "bookInfo/cover")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetBook> bookCover(@retrofit2.http.Field(value = "bid")
    int bid);
    
    /**
     * * 书籍详情
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "bookInfo/detail")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetBook> bookDetail(@retrofit2.http.Field(value = "bid")
    int bid);
    
    /**
     * * 每周新增书籍数
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "bookInfo/newBookNumPerWeek")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.book.NetNewBookNumPerWeek> newBookNumPerWeek();
    
    /**
     * * @param finishFlag 1 完结 0 连载
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "bookCategory/pageListByBookClass")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetPageListByBookClass> pageListByBookClass(@retrofit2.http.Field(value = "pageNo")
    int pageNo, @retrofit2.http.Field(value = "pageSize")
    int pageSize, @retrofit2.http.Field(value = "finishFlag")
    int finishFlag, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "className")
    java.lang.String className);
    
    /**
     * * 书籍分类列表（按男生女生分类）
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "bookCategory/pageListBySexType")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetClassification> pageListBySexType(@retrofit2.http.Field(value = "pageNo")
    int pageNo, @retrofit2.http.Field(value = "pageSize")
    int pageSize, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "sexType")
    java.lang.String sexType);
    
    /**
     * * 退出
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "main/logout")
    @retrofit2.http.Headers(value = {"Domain-Name: post2"})
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetLogOut> logout(@retrofit2.http.Field(value = "cuId")
    int cuId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "userToken")
    java.lang.String userToken);
    
    /**
     * * 手机登录
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "main/phoneLogin")
    @retrofit2.http.Headers(value = {"Domain-Name: post2"})
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetPhoneLoginSuccess> phoneLogin(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "phone")
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "zone")
    java.lang.String zone, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "code")
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "imei")
    java.lang.String imei, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "source")
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "channel")
    java.lang.String channel);
    
    /**
     * * 游客登录
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name: post2"})
    @retrofit2.http.POST(value = "main/visitorLogin")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetVisitorLoginSuccess> visitorLogin(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "imei")
    java.lang.String imei, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "source")
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "channel")
    java.lang.String channel);
    
    /**
     * * 微信登录
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name: post2"})
    @retrofit2.http.POST(value = "main/wechatLogin")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetWechatLoginSuccess> mainwechatLogin(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "code")
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "imei")
    java.lang.String imei, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "source")
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "channel")
    java.lang.String channel);
    
    /**
     * * 个人中心选项集合
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "personalCenter/page")
    @retrofit2.http.Headers(value = {"Domain-Name: post2"})
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetPersonalCenterPage> personalCenterPage(@retrofit2.http.Field(value = "cuId")
    int cuId);
    
    /**
     * * 账户信息
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name: post2"})
    @retrofit2.http.POST(value = "my-wallet/balance")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetBalance> balance(@retrofit2.http.Query(value = "cuId")
    int cuid);
    
    /**
     * * 奖励
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "award-register/award")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetRegisterAward> registerAward(@retrofit2.http.Field(value = "cuid")
    int cuid);
    
    /**
     * * 账户流水
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name: post2"})
    @retrofit2.http.POST(value = "account-flow/page")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetFlowPage> accountFLowPage(@retrofit2.http.Query(value = "cuId")
    int cuId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "currencyType")
    java.lang.String currencyType, @retrofit2.http.Query(value = "pageNo")
    int pageNo, @retrofit2.http.Query(value = "pageSize")
    int pageSize);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "search/list")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetSearchResult> search(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "wd")
    java.lang.String wd, @retrofit2.http.Query(value = "pageNo")
    int pageNo, @retrofit2.http.Query(value = "pageSize")
    int pageSize);
    
    /**
     * * 获取章节列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "chapter/listChapter")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetChapterList> listChapter(@retrofit2.http.Field(value = "bid")
    int bid);
    
    /**
     * * 获取章节内容详情
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "chapter/chapterContent")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetChapter> chapterContent(@retrofit2.http.Field(value = "bid")
    int bid, @retrofit2.http.Field(value = "cid")
    int cid);
    
    /**
     * * 获取用户信息
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "customer/getCustomerBizInfo")
    @retrofit2.http.Headers(value = {"Domain-Name: post2"})
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetUserInfo> getCustomeBizInfo(@retrofit2.http.Query(value = "cuId")
    int cid);
    
    /**
     * * 请求banner列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "api/banner/list")
    @retrofit2.http.Headers(value = {"Domain-Name:post6"})
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetBanner> bannerList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "systemType")
    java.lang.String systemType, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "position")
    @com.wy.adbook.app.constant.Constant.NetBannerPosition()
    java.lang.String position, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "channel")
    java.lang.String channel);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "welfare/list")
    @retrofit2.http.Headers(value = {"Domain-name:post6"})
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetWelfare> welfareList(@retrofit2.http.Query(value = "cuId")
    int cid);
    
    /**
     * * 看视频免广告20分钟
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "welfare/watchForFreeAdv")
    @retrofit2.http.Headers(value = {"Domain-Name:post6"})
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetWatchForFreeAdv> watchForFreeAdv(@retrofit2.http.Field(value = "cuId")
    int cuId);
    
    /**
     * *每日分享奖励金豆
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "welfare/watchForGole")
    @retrofit2.http.Headers(value = {"Domain-Name:post6"})
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetWatchForGole> watchForGole(@retrofit2.http.Query(value = "cuId")
    int cuId);
    
    /**
     * * 补签
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "attendance/compensateSign")
    @retrofit2.http.Headers(value = {"Domain-Name:post6"})
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetCompensateSign> compensateSign(@retrofit2.http.Query(value = "cuId")
    int cuId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "date")
    java.lang.String date);
    
    /**
     * * 签到
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "attendance/sign")
    @retrofit2.http.Headers(value = {"Domain-Name:post6"})
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetSign> sign(@retrofit2.http.Field(value = "cuId")
    int cuid);
    
    /**
     * * 签到日历
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "attendance/page")
    @retrofit2.http.Headers(value = {"Domain-Name:post6"})
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetAttendancePage> attendancePage(@retrofit2.http.Query(value = "cuId")
    int cuid);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "attendance/status")
    @retrofit2.http.Headers(value = {"Domain-Name:post6"})
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetAttendanceStatus> attendanceStatus(@retrofit2.http.Query(value = "cuId")
    int cuId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "bookhot/statistics")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetStatistics> statistics(@retrofit2.http.Field(value = "bid")
    int bid, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "type")
    java.lang.String type);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name:post6"})
    @retrofit2.http.POST(value = "startPage/getCurStartPage")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetStartPage> getCurStartPage(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "clientType")
    java.lang.String clientType, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "channelCode")
    java.lang.String channelCode);
    
    /**
     * * 读书进度
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "read-process/update")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetBookProgress> updateBookProgress(@retrofit2.http.Field(value = "cuId")
    int cuId, @retrofit2.http.Field(value = "bid")
    int bid, @retrofit2.http.Field(value = "cid")
    int cid, @retrofit2.http.Field(value = "readWords")
    int readWords);
    
    /**
     * * 获取30秒阅读福利
     *     * 读书界面每30s调用一次
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "welfareRead/get30sWelfareRead")
    @retrofit2.http.Headers(value = {"Domain-Name:post6"})
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetGet30sWelfareRead> get30sWelfareRead(@retrofit2.http.Field(value = "cuId")
    int cuId);
    
    /**
     * * 领取补签机会
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name:post6"})
    @retrofit2.http.POST(value = "compensate-chance/receive")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetCompensateChance> compensateChanceReceive(@retrofit2.http.Field(value = "cuId")
    int cuId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "type")
    java.lang.String type);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name:post6"})
    @retrofit2.http.POST(value = "welfare/videoForGole")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetVideoForGole> videoForGole(@retrofit2.http.Query(value = "cuid")
    int cuid);
    
    /**
     * * 填写邀请码
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name:post2"})
    @retrofit2.http.POST(value = "invitation/fillInCode")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetInvitationCode> fillInCode(@retrofit2.http.Query(value = "cuId")
    int cuId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "invitationCode")
    java.lang.String invitationCode);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name:post2"})
    @retrofit2.http.POST(value = "read-footprint/record")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetReadFooterRecord> readFooterRecord(@retrofit2.http.Query(value = "cuId")
    int cuId, @retrofit2.http.Query(value = "bid")
    int bid);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name:post2"})
    @retrofit2.http.POST(value = "read-footprint/getPage")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetReadFooterPage> getReadFooterPage(@retrofit2.http.Query(value = "cuId")
    int cuId, @retrofit2.http.Query(value = "pageNo")
    int pageNo, @retrofit2.http.Query(value = "pageSize")
    int pageSize);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name:post2"})
    @retrofit2.http.POST(value = "read-footprint/delete")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetDeleteReadFooter> deleteReadFooter(@retrofit2.http.Query(value = "id")
    int id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name:post2"})
    @retrofit2.http.GET(value = "api/faq/list")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetFaqList> faqList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "channle")
    java.lang.String channle, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "pageSize")
    int pageSize);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name:post2"})
    @retrofit2.http.POST(value = "friend/page")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.NetFriendPage> friendPage(@retrofit2.http.Query(value = "cuId")
    int cuId, @retrofit2.http.Query(value = "pageNo")
    int pageNo, @retrofit2.http.Query(value = "pageSize")
    int pageSize);
    
    /**
     * * 添加朋友
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name:post2"})
    @retrofit2.http.POST(value = "friend/add")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.friend.NetAddFriend> addFriend(@retrofit2.http.Query(value = "cuId")
    int cuId, @retrofit2.http.Query(value = "fuId")
    int fuId);
    
    /**
     * * 检查审核
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name:post2"})
    @retrofit2.http.POST(value = "version/check")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.update.NetVersionCheck> versionCheck(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "versionCode")
    java.lang.String versionCode, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "clientType")
    java.lang.String clientType);
    
    /**
     * * 检查更新
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"Domain-Name:post2"})
    @retrofit2.http.POST(value = "version/checkUpdate")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.update.NetVersionCheckUpdate> versionCheckUpdate(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "versionCode")
    java.lang.String versionCode, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "clientType")
    java.lang.String clientType);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "")
    public abstract io.reactivex.Observable<com.wy.adbook.mvp.model.entity.accout.NetChangeNick> changeNickname(@retrofit2.http.Query(value = "cuId")
    int cuid, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "nickname")
    java.lang.String nickname);
    
    @android.support.annotation.StringDef(value = {"boy", "girl"})
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/wy/adbook/mvp/model/api/service/QYService$NetGenderParam;", "", "Companion", "application_debug"})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
    public static abstract @interface NetGenderParam {
        public static final com.wy.adbook.mvp.model.api.service.QYService.NetGenderParam.Companion Companion = null;
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BOY = "boy";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String GIRL = "girl";
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/wy/adbook/mvp/model/api/service/QYService$NetGenderParam$Companion;", "", "()V", "BOY", "", "GIRL", "application_debug"})
        public static final class Companion {
            @org.jetbrains.annotations.NotNull()
            public static final java.lang.String BOY = "boy";
            @org.jetbrains.annotations.NotNull()
            public static final java.lang.String GIRL = "girl";
            
            private Companion() {
                super();
            }
        }
    }
    
    /**
     * * Created by leafye on 2019/4/29.
     */
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/wy/adbook/mvp/model/api/service/QYService$Companion;", "", "()V", "API_BANNER_LIST", "", "BOOK_CATEGORY_PAGE_LIST_BY_SEX_TYPE", "BOOK_SHELF_PAGE_LIST", "BOOK_SUBJECT_LIST_BY_SUBJECT_TYPE", "application_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BOOK_SHELF_PAGE_LIST = "bookShelf/pageList";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BOOK_SUBJECT_LIST_BY_SUBJECT_TYPE = "bookSubject/listBySubjectType";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String API_BANNER_LIST = "api/banner/list";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BOOK_CATEGORY_PAGE_LIST_BY_SEX_TYPE = "bookCategory/pageListBySexType";
        
        private Companion() {
            super();
        }
    }
}