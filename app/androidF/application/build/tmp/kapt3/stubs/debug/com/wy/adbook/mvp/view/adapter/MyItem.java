package com.wy.adbook.mvp.view.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/wy/adbook/mvp/view/adapter/MyItem;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "type", "", "any", "", "(ILjava/lang/Object;)V", "getAny", "()Ljava/lang/Object;", "getItemType", "Companion", "application_debug"})
public final class MyItem implements com.chad.library.adapter.base.entity.MultiItemEntity {
    private final int type = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object any = null;
    public static final int TYPE_HEADER = 1;
    public static final int TYPE_NORMAL = 2;
    public static final com.wy.adbook.mvp.view.adapter.MyItem.Companion Companion = null;
    
    @java.lang.Override()
    public int getItemType() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAny() {
        return null;
    }
    
    public MyItem(int type, @org.jetbrains.annotations.Nullable()
    java.lang.Object any) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/wy/adbook/mvp/view/adapter/MyItem$Companion;", "", "()V", "TYPE_HEADER", "", "TYPE_NORMAL", "application_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}