//Copyright (c) 2017. 章钦豪. All rights reserved.
package com.wy.adbook.mvp.model.entity.book.bookread;

import android.os.Parcel;
import android.os.Parcelable;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 章节列表
 */
@Entity
public class ChapterListBean implements Parcelable, Cloneable {
    public String cBID;
    @Id
    public String cCID;  //当前章节对应的文章地址
    public String durChapterName;  //当前章节名称
    public String authority;
    public String allWords;// 字数

    public ChapterListBean() {
    }

    @Keep
    public ChapterListBean(String cBID, String cCID, String durChapterName, String authority, String allWords) {
        this.cBID = cBID;
        this.cCID = cCID;
        this.durChapterName = durChapterName;
        this.authority = authority;
        this.allWords = allWords;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cBID);
        dest.writeString(cCID);
        dest.writeString(durChapterName);
        dest.writeString(authority);
        dest.writeString(allWords);


    }


    protected ChapterListBean(Parcel in) {
        cBID = in.readString();
        cCID = in.readString();
        durChapterName = in.readString();
        authority = in.readString();
        allWords = in.readString();

    }


    @Override
    public int describeContents() {
        return 0;
    }


    @Transient
    public static final Creator<ChapterListBean> CREATOR = new Creator<ChapterListBean>() {
        @Override
        public ChapterListBean createFromParcel(Parcel in) {
            return new ChapterListBean(in);
        }

        @Override
        public ChapterListBean[] newArray(int size) {
            return new ChapterListBean[size];
        }
    };

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ChapterListBean chapterListBean = (ChapterListBean) super.clone();
        chapterListBean.cBID = cBID;
        chapterListBean.cCID = cCID;
        chapterListBean.durChapterName = durChapterName;
        chapterListBean.authority = authority;
        chapterListBean.allWords = allWords;

        return chapterListBean;
    }

    public String getDurChapterName() {
        return this.durChapterName;
    }

    public void setDurChapterName(String durChapterName) {
        this.durChapterName = durChapterName;
    }


    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


    public String getCCID() {
        return this.cCID;
    }

    public void setCCID(String cCID) {
        this.cCID = cCID;
    }

    public String getCBID() {
        return this.cBID;
    }

    public void setCBID(String cBID) {
        this.cBID = cBID;
    }


    public String getAllWords() {
        return this.allWords;
    }

    public void setAllWords(String allWords) {
        this.allWords = allWords;
    }


}
