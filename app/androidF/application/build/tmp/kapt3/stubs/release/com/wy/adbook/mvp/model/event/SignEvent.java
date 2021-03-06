package com.wy.adbook.mvp.model.event;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-24.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/wy/adbook/mvp/model/event/SignEvent;", "Lcom/wy/adbook/app/base/BaseEvent;", "key", "", "args", "strArgs", "", "obj", "", "(IILjava/lang/String;Ljava/lang/Object;)V", "Companion", "application_release"})
public final class SignEvent extends com.wy.adbook.app.base.BaseEvent {
    public static final int EVENT_SIGN_SUCCESS = 0;
    public static final com.wy.adbook.mvp.model.event.SignEvent.Companion Companion = null;
    
    public SignEvent(int key, int args, @org.jetbrains.annotations.NotNull()
    java.lang.String strArgs, @org.jetbrains.annotations.Nullable()
    java.lang.Object obj) {
        super(0, 0, null, null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/wy/adbook/mvp/model/event/SignEvent$Companion;", "", "()V", "EVENT_SIGN_SUCCESS", "", "application_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}