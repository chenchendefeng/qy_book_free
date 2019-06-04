package com.wy.adbook.app;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/wy/adbook/app/QYApplication;", "Lcom/jess/arms/base/BaseApplication;", "Lcom/wy/adbook/app/QY;", "()V", "yangYanComponent", "Lcom/wy/adbook/di/component/QYComponent;", "initDao", "", "initMob", "onCreate", "yangYangComponent", "Companion", "application_release"})
public final class QYApplication extends com.jess.arms.base.BaseApplication implements com.wy.adbook.app.QY {
    private com.wy.adbook.di.component.QYComponent yangYanComponent;
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    private static android.content.Context context;
    @org.jetbrains.annotations.NotNull()
    public static greendao.DaoSession daoSession;
    public static final com.wy.adbook.app.QYApplication.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final void initMob() {
    }
    
    private final void initDao() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.wy.adbook.di.component.QYComponent yangYangComponent() {
        return null;
    }
    
    public QYApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.content.Context cxt() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0004H\u0007J\u0006\u0010\r\u001a\u00020\u0007R\u0018\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083.\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/wy/adbook/app/QYApplication$Companion;", "", "()V", "context", "Landroid/content/Context;", "context$annotations", "daoSession", "Lgreendao/DaoSession;", "getDaoSession", "()Lgreendao/DaoSession;", "setDaoSession", "(Lgreendao/DaoSession;)V", "cxt", "getDaoInstant", "application_release"})
    public static final class Companion {
        
        private static void context$annotations() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final greendao.DaoSession getDaoSession() {
            return null;
        }
        
        public final void setDaoSession(@org.jetbrains.annotations.NotNull()
        greendao.DaoSession p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context cxt() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final greendao.DaoSession getDaoInstant() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}