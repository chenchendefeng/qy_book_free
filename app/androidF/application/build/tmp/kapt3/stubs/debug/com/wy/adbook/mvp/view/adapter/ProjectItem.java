package com.wy.adbook.mvp.view.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/wy/adbook/mvp/view/adapter/ProjectItem;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "()V", "any", "", "getAny", "()Ljava/lang/Object;", "setAny", "(Ljava/lang/Object;)V", "projectItemType", "", "getProjectItemType", "()I", "setProjectItemType", "(I)V", "getItemType", "Companion", "application_debug"})
public final class ProjectItem implements com.chad.library.adapter.base.entity.MultiItemEntity {
    private int projectItemType;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Object any;
    
    /**
     * * 上面一个 下面3个
     */
    public static final int TYPE_1_3 = 0;
    
    /**
     * * 上面一个 下面4个 每排2个
     */
    public static final int TYPE_1_2_GRID = 1;
    
    /**
     * *上面N个
     */
    public static final int TYPE_N = 2;
    
    /**
     * * 上面一个 下面4个 列表
     */
    public static final int TYPE_1_4_LIST = 3;
    public static final com.wy.adbook.mvp.view.adapter.ProjectItem.Companion Companion = null;
    
    @java.lang.Override()
    public int getItemType() {
        return 0;
    }
    
    public final int getProjectItemType() {
        return 0;
    }
    
    public final void setProjectItemType(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAny() {
        return null;
    }
    
    public final void setAny(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
    }
    
    public ProjectItem() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/wy/adbook/mvp/view/adapter/ProjectItem$Companion;", "", "()V", "TYPE_1_2_GRID", "", "TYPE_1_3", "TYPE_1_4_LIST", "TYPE_N", "application_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}