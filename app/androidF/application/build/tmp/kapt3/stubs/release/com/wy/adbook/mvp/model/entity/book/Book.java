package com.wy.adbook.mvp.model.entity.book;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u001b\u0018\u0000 W2\u00020\u0001:\u0003WXYB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010T\u001a\u00020\"J\u0006\u0010U\u001a\u00020\"J\u0006\u0010V\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001e\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0006\"\u0004\b(\u0010\bR\u001e\u0010)\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014R\u001e\u0010,\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0012\"\u0004\b.\u0010\u0014R\u001e\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001a\u00102\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0012\"\u0004\b4\u0010\u0014R\u001e\u00105\u001a\u0002068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0012\"\u0004\b=\u0010\u0014R\u001e\u0010>\u001a\u00020?8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001e\u0010D\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0012\"\u0004\bF\u0010\u0014R\u001e\u0010G\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0012\"\u0004\bI\u0010\u0014R$\u0010J\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\bK\u0010\u0002\u001a\u0004\bL\u0010\u0012\"\u0004\bM\u0010\u0014R\u001e\u0010N\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR\u001e\u0010Q\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0012\"\u0004\bS\u0010\u0014\u00a8\u0006Z"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/book/Book;", "Ljava/io/Serializable;", "()V", "allwords", "", "getAllwords", "()Ljava/lang/String;", "setAllwords", "(Ljava/lang/String;)V", "amount", "getAmount", "setAmount", "author", "getAuthor", "setAuthor", "bid", "", "getBid", "()I", "setBid", "(I)V", "bookCovers", "getBookCovers", "setBookCovers", "bookName", "getBookName", "setBookName", "category", "getCategory", "setCategory", "chapterCount", "getChapterCount", "setChapterCount", "collBookBean", "Lcom/wy/adbook/mvp/model/dao/CollBookBean;", "collectionCount", "getCollectionCount", "setCollectionCount", "description", "getDescription", "setDescription", "finishFlag", "getFinishFlag", "setFinishFlag", "id", "getId", "setId", "keywords", "getKeywords", "setKeywords", "lastReadChapterId", "getLastReadChapterId", "setLastReadChapterId", "lastUpdateTime", "", "getLastUpdateTime", "()J", "setLastUpdateTime", "(J)V", "originalBid", "getOriginalBid", "setOriginalBid", "readProgress", "", "getReadProgress", "()F", "setReadProgress", "(F)V", "readedCount", "getReadedCount", "setReadedCount", "readingCount", "getReadingCount", "setReadingCount", "shelfStatus", "shelfStatus$annotations", "getShelfStatus", "setShelfStatus", "source", "getSource", "setSource", "totalWordCount", "getTotalWordCount", "setTotalWordCount", "createCollBookBean", "getCollBookBean", "getFinishFlagStatus", "Companion", "FinishFlag", "ShelfStatus", "application_release"})
public final class Book implements java.io.Serializable {
    @com.google.gson.annotations.SerializedName(value = "bid")
    private int bid;
    
    /**
     * * 分类
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "category")
    private java.lang.String category;
    
    /**
     * * 章节数
     */
    @com.google.gson.annotations.SerializedName(value = "chapterCount")
    private int chapterCount;
    
    /**
     * * 封面图
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "coverImg")
    private java.lang.String bookCovers;
    
    /**
     * *描述
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "description")
    private java.lang.String description;
    
    /**
     * *@link FINISH_FLAG_SERIAL
     *     * @link FINISH_FLAG_FINISH
     */
    @com.google.gson.annotations.SerializedName(value = "finishFlag")
    private int finishFlag;
    
    /**
     * * 书名
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "name")
    private java.lang.String bookName;
    
    /**
     * * 作者
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "author")
    private java.lang.String author;
    @com.google.gson.annotations.SerializedName(value = "id")
    private int id;
    
    /**
     * * 原书籍ID
     */
    @com.google.gson.annotations.SerializedName(value = "originalBid")
    private int originalBid;
    
    /**
     * * 关键字
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "keywords")
    private java.lang.String keywords;
    
    /**
     * * 最近修改时间
     */
    @com.google.gson.annotations.SerializedName(value = "lastUpdateTime")
    private long lastUpdateTime;
    
    /**
     * * 已读
     */
    @com.google.gson.annotations.SerializedName(value = "readedCount")
    private int readedCount;
    
    /**
     * * 在读
     */
    @com.google.gson.annotations.SerializedName(value = "readingCount")
    private int readingCount;
    
    /**
     * * 收藏
     */
    @com.google.gson.annotations.SerializedName(value = "collectionCount")
    private int collectionCount;
    
    /**
     * * 书籍状态
     *     * 上架状态 （0：下架 | 1：上架）
     *     * @link SHELF_STATUS_OFF
     *     * @link SHELF_STATUS_ON
     */
    @com.google.gson.annotations.SerializedName(value = "shelfStatus")
    private int shelfStatus;
    
    /**
     * * 书籍来源 （ twoCloo : 二层楼 | tadu：塔读 ）
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "source")
    private java.lang.String source;
    
    /**
     * * 总字数
     */
    @com.google.gson.annotations.SerializedName(value = "totalWordCount")
    private int totalWordCount;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String allwords;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String amount;
    private int lastReadChapterId;
    
    /**
     * * 读书进度
     */
    @com.google.gson.annotations.SerializedName(value = "readProcess")
    private float readProgress;
    private com.wy.adbook.mvp.model.dao.CollBookBean collBookBean;
    public static final com.wy.adbook.mvp.model.entity.book.Book.Companion Companion = null;
    
    public final int getBid() {
        return 0;
    }
    
    public final void setBid(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getChapterCount() {
        return 0;
    }
    
    public final void setChapterCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBookCovers() {
        return null;
    }
    
    public final void setBookCovers(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getFinishFlag() {
        return 0;
    }
    
    public final void setFinishFlag(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBookName() {
        return null;
    }
    
    public final void setBookName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthor() {
        return null;
    }
    
    public final void setAuthor(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    public final int getOriginalBid() {
        return 0;
    }
    
    public final void setOriginalBid(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKeywords() {
        return null;
    }
    
    public final void setKeywords(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final long getLastUpdateTime() {
        return 0L;
    }
    
    public final void setLastUpdateTime(long p0) {
    }
    
    public final int getReadedCount() {
        return 0;
    }
    
    public final void setReadedCount(int p0) {
    }
    
    public final int getReadingCount() {
        return 0;
    }
    
    public final void setReadingCount(int p0) {
    }
    
    public final int getCollectionCount() {
        return 0;
    }
    
    public final void setCollectionCount(int p0) {
    }
    
    @com.wy.adbook.mvp.model.entity.book.Book.ShelfStatus()
    public static void shelfStatus$annotations() {
    }
    
    public final int getShelfStatus() {
        return 0;
    }
    
    public final void setShelfStatus(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSource() {
        return null;
    }
    
    public final void setSource(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getTotalWordCount() {
        return 0;
    }
    
    public final void setTotalWordCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAllwords() {
        return null;
    }
    
    public final void setAllwords(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAmount() {
        return null;
    }
    
    public final void setAmount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getLastReadChapterId() {
        return 0;
    }
    
    public final void setLastReadChapterId(int p0) {
    }
    
    public final float getReadProgress() {
        return 0.0F;
    }
    
    public final void setReadProgress(float p0) {
    }
    
    /**
     * * 获取书籍状态 已完结/连载中
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFinishFlagStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.model.dao.CollBookBean getCollBookBean() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.mvp.model.dao.CollBookBean createCollBookBean() {
        return null;
    }
    
    public Book() {
        super();
    }
    
    @android.support.annotation.IntDef(value = {0, 1})
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/book/Book$FinishFlag;", "", "Companion", "application_release"})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
    public static abstract @interface FinishFlag {
        public static final com.wy.adbook.mvp.model.entity.book.Book.FinishFlag.Companion Companion = null;
        public static final int ALL = -1;
        
        /**
         * * 连载
         */
        public static final int FINISH_FLAG_SERIAL = 0;
        
        /**
         * * 完结
         */
        public static final int FINISH_FLAG_FINISH = 1;
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/book/Book$FinishFlag$Companion;", "", "()V", "ALL", "", "FINISH_FLAG_FINISH", "FINISH_FLAG_SERIAL", "application_release"})
        public static final class Companion {
            public static final int ALL = -1;
            
            /**
             * * 连载
             */
            public static final int FINISH_FLAG_SERIAL = 0;
            
            /**
             * * 完结
             */
            public static final int FINISH_FLAG_FINISH = 1;
            
            private Companion() {
                super();
            }
        }
    }
    
    @android.support.annotation.IntDef(value = {0, 1})
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/book/Book$ShelfStatus;", "", "Companion", "application_release"})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
    public static abstract @interface ShelfStatus {
        public static final com.wy.adbook.mvp.model.entity.book.Book.ShelfStatus.Companion Companion = null;
        
        /**
         * * 下架
         */
        public static final int SHELF_STATUS_OFF = 0;
        
        /**
         * * 上架
         */
        public static final int SHELF_STATUS_ON = 1;
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/book/Book$ShelfStatus$Companion;", "", "()V", "SHELF_STATUS_OFF", "", "SHELF_STATUS_ON", "application_release"})
        public static final class Companion {
            
            /**
             * * 下架
             */
            public static final int SHELF_STATUS_OFF = 0;
            
            /**
             * * 上架
             */
            public static final int SHELF_STATUS_ON = 1;
            
            private Companion() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/wy/adbook/mvp/model/entity/book/Book$Companion;", "", "()V", "getBookSource", "", "source", "application_release"})
    public static final class Companion {
        
        /**
         * * 获取书籍来源
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBookSource(@org.jetbrains.annotations.NotNull()
        java.lang.String source) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}