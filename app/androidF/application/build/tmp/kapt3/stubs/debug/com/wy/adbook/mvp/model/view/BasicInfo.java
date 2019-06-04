package com.wy.adbook.mvp.model.view;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-30.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001\u001cB?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0012\"\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"Lcom/wy/adbook/mvp/model/view/BasicInfo;", "", "title", "", "content", "imageUrl", "isShowTopLine", "", "isEnter", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZI)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getImageUrl", "setImageUrl", "()Z", "setEnter", "(Z)V", "setShowTopLine", "getTitle", "setTitle", "getType", "()I", "setType", "(I)V", "Type", "application_debug"})
public final class BasicInfo {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String title;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String content;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String imageUrl;
    private boolean isShowTopLine;
    private boolean isEnter;
    private int type;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    public final void setContent(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImageUrl() {
        return null;
    }
    
    public final void setImageUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isShowTopLine() {
        return false;
    }
    
    public final void setShowTopLine(boolean p0) {
    }
    
    public final boolean isEnter() {
        return false;
    }
    
    public final void setEnter(boolean p0) {
    }
    
    public final int getType() {
        return 0;
    }
    
    public final void setType(int p0) {
    }
    
    public BasicInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl, boolean isShowTopLine, boolean isEnter, @com.wy.adbook.mvp.model.view.BasicInfo.Type()
    int type) {
        super();
    }
    
    @android.support.annotation.IntDef(value = {0, 1, 2, 3})
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/wy/adbook/mvp/model/view/BasicInfo$Type;", "", "Companion", "application_debug"})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.SOURCE)
    public static abstract @interface Type {
        public static final com.wy.adbook.mvp.model.view.BasicInfo.Type.Companion Companion = null;
        public static final int TYPE_HEAD = 0;
        public static final int TYPE_NICKNAME = 1;
        public static final int TYPE_GENDER = 2;
        public static final int TYPE_ACCOUNT = 3;
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/wy/adbook/mvp/model/view/BasicInfo$Type$Companion;", "", "()V", "TYPE_ACCOUNT", "", "TYPE_GENDER", "TYPE_HEAD", "TYPE_NICKNAME", "application_debug"})
        public static final class Companion {
            public static final int TYPE_HEAD = 0;
            public static final int TYPE_NICKNAME = 1;
            public static final int TYPE_GENDER = 2;
            public static final int TYPE_ACCOUNT = 3;
            
            private Companion() {
                super();
            }
        }
    }
}