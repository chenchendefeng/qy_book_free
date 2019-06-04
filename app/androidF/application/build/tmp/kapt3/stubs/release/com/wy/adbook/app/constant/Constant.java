package com.wy.adbook.app.constant;

import java.lang.System;

/**
 * * Created by leafye on 2019/4/29.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u0000 \u00052\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\n"}, d2 = {"Lcom/wy/adbook/app/constant/Constant;", "", "()V", "BookBgColor", "BookPageTurn", "Companion", "Gender", "NetBannerPosition", "ShareType", "VipStatus", "application_release"})
public final class Constant {
    
    /**
     * * 登录源 都是Android
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DEF_SOURCE = "Android";
    
    /**
     * * 连续签到最高可获得的金豆数
     */
    public static final int maxSignGoldBean = 10000;
    
    /**
     * * 微信的appId
     *         * ad: wx1f9ae90e23e42cb7
     *         * qy: wx08ad162781657c74
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String APP_ID_WX = "wx1f9ae90e23e42cb7";
    
    /**
     * * qq id
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String QQ_APP_ID = "";
    public static final int PAGE_SIZE = 10;
    
    /**
     * * 默认的电话前缀
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DEF_PHONE_ZONE = "+86";
    
    /**
     * * 书籍的存储路径
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BOOK_CACHE_PATH = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FORMAT_BOOK_DATE = "yyyy-MM-dd\'T\'HH:mm:ss";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FORMAT_TIME = "HH:mm";
    
    /**
     * * js调java方法协议
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String JS_CALL_JAVA_PROTOCOL = "qywebkit";
    
    /**
     * * 注入WebView中供js上下文调用的java类
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.Class<?> INJECT_INTO_WEB_VIEW_CLASS = null;
    
    /**
     * * WebView是否可以调试
     */
    public static final boolean WEB_DEBUGABLE = true;
    
    /**
     * * 阅读福利中,阅读xx秒获得奖励
     */
    public static final int readSecondsToGetReward = 30;
    
    /**
     * * 查看视频获取的跳过广告时间
     */
    public static final int watchingVideoGetSkipAdTimeMinute = 20;
    
    /**
     * * 每日分享可获得的金豆
     */
    public static final int shareGetRewardNum = 100;
    public static final int readLevelReward1 = 30;
    public static final int readLevelReward2 = 60;
    public static final int readLevelReward3 = 80;
    public static final int readLevelReward4 = 100;
    public static final int readLevelMinute1 = 30;
    public static final int readLevelMinute2 = 60;
    public static final int readLevelMinute3 = 90;
    public static final int readLevelMinute4 = 120;
    public static final com.wy.adbook.app.constant.Constant.Companion Companion = null;
    
    public Constant() {
        super();
    }
    
    /**
     * * 书籍的存储路径
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getBOOK_CACHE_PATH() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getFORMAT_BOOK_DATE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getFORMAT_TIME() {
        return null;
    }
    
    @android.support.annotation.IntDef(value = {2, 0, 1})
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/wy/adbook/app/constant/Constant$ShareType;", "", "Companion", "application_release"})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.SOURCE)
    public static abstract @interface ShareType {
        public static final com.wy.adbook.app.constant.Constant.ShareType.Companion Companion = null;
        public static final int SHARE_TYPE_WX_HY = 0;
        public static final int SHARE_TYPE_WX_PYQ = 1;
        public static final int SHARE_TYPE_QQ = 2;
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/app/constant/Constant$ShareType$Companion;", "", "()V", "SHARE_TYPE_QQ", "", "SHARE_TYPE_WX_HY", "SHARE_TYPE_WX_PYQ", "application_release"})
        public static final class Companion {
            public static final int SHARE_TYPE_WX_HY = 0;
            public static final int SHARE_TYPE_WX_PYQ = 1;
            public static final int SHARE_TYPE_QQ = 2;
            
            private Companion() {
                super();
            }
        }
    }
    
    /**
     * * 性别
     */
    @android.support.annotation.IntDef(value = {0, 1})
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/wy/adbook/app/constant/Constant$Gender;", "", "Companion", "application_release"})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.SOURCE)
    public static abstract @interface Gender {
        public static final com.wy.adbook.app.constant.Constant.Gender.Companion Companion = null;
        public static final int NO_GENDER = -1;
        public static final int MALE = 0;
        public static final int FEMALE = 1;
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/app/constant/Constant$Gender$Companion;", "", "()V", "FEMALE", "", "MALE", "NO_GENDER", "application_release"})
        public static final class Companion {
            public static final int NO_GENDER = -1;
            public static final int MALE = 0;
            public static final int FEMALE = 1;
            
            private Companion() {
                super();
            }
        }
    }
    
    /**
     * * 网络请求banner的position
     */
    @android.support.annotation.StringDef(value = {"bookStore", "choice", "readerGuiding"})
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/wy/adbook/app/constant/Constant$NetBannerPosition;", "", "Companion", "application_release"})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
    public static abstract @interface NetBannerPosition {
        public static final com.wy.adbook.app.constant.Constant.NetBannerPosition.Companion Companion = null;
        
        /**
         * * 书库
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BOOK_STORE = "bookStore";
        
        /**
         * * 精选
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String CHOICE = "choice";
        
        /**
         * * 导读
         */
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String READER_GUIDING = "readerGuiding";
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/app/constant/Constant$NetBannerPosition$Companion;", "", "()V", "BOOK_STORE", "", "CHOICE", "READER_GUIDING", "application_release"})
        public static final class Companion {
            
            /**
             * * 书库
             */
            @org.jetbrains.annotations.NotNull()
            public static final java.lang.String BOOK_STORE = "bookStore";
            
            /**
             * * 精选
             */
            @org.jetbrains.annotations.NotNull()
            public static final java.lang.String CHOICE = "choice";
            
            /**
             * * 导读
             */
            @org.jetbrains.annotations.NotNull()
            public static final java.lang.String READER_GUIDING = "readerGuiding";
            
            private Companion() {
                super();
            }
        }
    }
    
    /**
     * * vip状态
     */
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/wy/adbook/app/constant/Constant$VipStatus;", "", "()V", "Companion", "application_release"})
    public static final class VipStatus {
        
        /**
         * * vip 是
         */
        private static final int VIP_STATUS_YES = 1;
        
        /**
         * * vip 否
         */
        private static final int VIP_STATUS_NO = 0;
        public static final com.wy.adbook.app.constant.Constant.VipStatus.Companion Companion = null;
        
        public VipStatus() {
            super();
        }
        
        /**
         * * vip 是
         */
        public static final int getVIP_STATUS_YES() {
            return 0;
        }
        
        /**
         * * vip 否
         */
        public static final int getVIP_STATUS_NO() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/wy/adbook/app/constant/Constant$VipStatus$Companion;", "", "()V", "VIP_STATUS_NO", "", "VIP_STATUS_NO$annotations", "getVIP_STATUS_NO", "()I", "VIP_STATUS_YES", "VIP_STATUS_YES$annotations", "getVIP_STATUS_YES", "application_release"})
        public static final class Companion {
            
            public static void VIP_STATUS_YES$annotations() {
            }
            
            public final int getVIP_STATUS_YES() {
                return 0;
            }
            
            public static void VIP_STATUS_NO$annotations() {
            }
            
            public final int getVIP_STATUS_NO() {
                return 0;
            }
            
            private Companion() {
                super();
            }
        }
    }
    
    /**
     * * 背景颜色设置
     */
    @android.support.annotation.IntDef(value = {0, 1, 2, 3, 4})
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/wy/adbook/app/constant/Constant$BookBgColor;", "", "Companion", "application_release"})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.SOURCE)
    public static abstract @interface BookBgColor {
        public static final com.wy.adbook.app.constant.Constant.BookBgColor.Companion Companion = null;
        public static final int BG_YELLOW = 0;
        public static final int BG_GREEN = 1;
        public static final int BG_BLUE = 2;
        public static final int BG_PINK = 3;
        public static final int BG_BLACK = 4;
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/wy/adbook/app/constant/Constant$BookBgColor$Companion;", "", "()V", "BG_BLACK", "", "BG_BLUE", "BG_GREEN", "BG_PINK", "BG_YELLOW", "application_release"})
        public static final class Companion {
            public static final int BG_YELLOW = 0;
            public static final int BG_GREEN = 1;
            public static final int BG_BLUE = 2;
            public static final int BG_PINK = 3;
            public static final int BG_BLACK = 4;
            
            private Companion() {
                super();
            }
        }
    }
    
    /**
     * * 翻页滚动效果
     */
    @android.support.annotation.IntDef(value = {0, 1, 2, 3})
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/wy/adbook/app/constant/Constant$BookPageTurn;", "", "Companion", "application_release"})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.SOURCE)
    public static abstract @interface BookPageTurn {
        public static final com.wy.adbook.app.constant.Constant.BookPageTurn.Companion Companion = null;
        public static final int UP_DOWN = 0;
        public static final int SMOOTH = 1;
        public static final int SIMULATION = 2;
        public static final int AUTOMATIC = 3;
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/wy/adbook/app/constant/Constant$BookPageTurn$Companion;", "", "()V", "AUTOMATIC", "", "SIMULATION", "SMOOTH", "UP_DOWN", "application_release"})
        public static final class Companion {
            public static final int UP_DOWN = 0;
            public static final int SMOOTH = 1;
            public static final int SIMULATION = 2;
            public static final int AUTOMATIC = 3;
            
            private Companion() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\bR\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\bR\u0015\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0017X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/wy/adbook/app/constant/Constant$Companion;", "", "()V", "APP_ID_WX", "", "BOOK_CACHE_PATH", "BOOK_CACHE_PATH$annotations", "getBOOK_CACHE_PATH", "()Ljava/lang/String;", "DEF_PHONE_ZONE", "DEF_SOURCE", "FORMAT_BOOK_DATE", "FORMAT_BOOK_DATE$annotations", "getFORMAT_BOOK_DATE", "FORMAT_TIME", "FORMAT_TIME$annotations", "getFORMAT_TIME", "INJECT_INTO_WEB_VIEW_CLASS", "Ljava/lang/Class;", "getINJECT_INTO_WEB_VIEW_CLASS", "()Ljava/lang/Class;", "JS_CALL_JAVA_PROTOCOL", "PAGE_SIZE", "", "QQ_APP_ID", "WEB_DEBUGABLE", "", "maxSignGoldBean", "readLevelMinute1", "readLevelMinute2", "readLevelMinute3", "readLevelMinute4", "readLevelReward1", "readLevelReward2", "readLevelReward3", "readLevelReward4", "readSecondsToGetReward", "shareGetRewardNum", "watchingVideoGetSkipAdTimeMinute", "application_release"})
    public static final class Companion {
        
        public static void BOOK_CACHE_PATH$annotations() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBOOK_CACHE_PATH() {
            return null;
        }
        
        public static void FORMAT_BOOK_DATE$annotations() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFORMAT_BOOK_DATE() {
            return null;
        }
        
        public static void FORMAT_TIME$annotations() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFORMAT_TIME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Class<?> getINJECT_INTO_WEB_VIEW_CLASS() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}