package com.freebookqy.application.mvp.model.entity.book.bookread;

import java.io.Serializable;

/**
 *
 */
public class BookDetailBean {


    public DataBean data;


    public static class DataBean implements Serializable {

        public String allwords;
        public String amount;
        public String authorName;
        public String buyStatus;
        public String cBID;
        public String categoryid;
        public String coverUrl;
        public String freeOrSpecial;
        public String freeStatus;
        public String intro;
        public String isReadCard;
        public String lastReadChapterId;
        public String onShelf;
        public String readCount;
        public String readWords;
        public int status;
        public String title;
        public String updatetime;
        public String lastUpdateTime;
        public int chapterCount;
        public String wappageData;

        public String starAvgNum;
        public String commendNum;
        public String curUserStarNum;

    }
}