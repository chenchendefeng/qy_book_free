package com.wy.adbook.mvp.model.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/FaqItem;", "Ljava/io/Serializable;", "()V", "answer", "", "getAnswer", "()Ljava/lang/String;", "setAnswer", "(Ljava/lang/String;)V", "isOpen", "", "()Z", "setOpen", "(Z)V", "question", "getQuestion", "setQuestion", "application_release"})
public final class FaqItem implements java.io.Serializable {
    
    /**
     * * 是否展开
     */
    private boolean isOpen;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "answer")
    private java.lang.String answer;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "question")
    private java.lang.String question;
    
    public final boolean isOpen() {
        return false;
    }
    
    public final void setOpen(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAnswer() {
        return null;
    }
    
    public final void setAnswer(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getQuestion() {
        return null;
    }
    
    public final void setQuestion(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public FaqItem() {
        super();
    }
}