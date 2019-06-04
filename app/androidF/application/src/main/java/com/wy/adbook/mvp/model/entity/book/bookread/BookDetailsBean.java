package com.wy.adbook.mvp.model.entity.book.bookread;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 书籍详情
 */
@Entity
public class BookDetailsBean {

    private String allwords;

    private String amount;

    private String authorName;

    private String buyStatus;
    @Id
    private String cBID;

    private String categoryid;

    private String coverUrl;

    private String freeOrSpecial;

    private String freeStatus;

    private String intro;

    private String lastReadChapterId;

    private String onShelf;

    private String readCount;

    private String readWords;

    private int status;

    private String title;

    private String updatetime;

    private String isReadCard;

    private String lastUpdateTime;// 存储的更新时间

    private int chapterCount;

    private String wappageData;

    @Keep
    public BookDetailsBean(String allwords, String amount, String authorName,
                           String buyStatus, String cBID, String categoryid, String coverUrl,
                           String freeOrSpecial, String freeStatus, String intro, String lastReadChapterId,
                           String onShelf, String readCount, String readWords, int status, String title,
                           String updatetime, String isReadCard, String lastUpdateTime, int chapterCount, String wappageData) {
        this.allwords = allwords;
        this.amount = amount;
        this.authorName = authorName;
        this.buyStatus = buyStatus;
        this.cBID = cBID;
        this.categoryid = categoryid;
        this.coverUrl = coverUrl;
        this.freeOrSpecial = freeOrSpecial;
        this.freeStatus = freeStatus;
        this.intro = intro;
        this.lastReadChapterId = lastReadChapterId;
        this.onShelf = onShelf;
        this.readCount = readCount;
        this.readWords = readWords;
        this.status = status;
        this.title = title;
        this.updatetime = updatetime;
        this.isReadCard = isReadCard;
        this.lastUpdateTime = lastUpdateTime;
        this.chapterCount = chapterCount;
        this.wappageData = wappageData;
    }

    @Keep
    public BookDetailsBean() {
    }

    public String getAllwords() {
        return allwords;
    }

    public void setAllwords(String allwords) {
        this.allwords = allwords;
    }

    public String getWappageData() {
        return wappageData;
    }

    public void setWappageData(String wappageData) {
        this.wappageData = wappageData;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBuyStatus() {
        return buyStatus;
    }

    public void setBuyStatus(String buyStatus) {
        this.buyStatus = buyStatus;
    }


    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getFreeOrSpecial() {
        return freeOrSpecial;
    }

    public void setFreeOrSpecial(String freeOrSpecial) {
        this.freeOrSpecial = freeOrSpecial;
    }

    public String getFreeStatus() {
        return freeStatus;
    }

    public void setFreeStatus(String freeStatus) {
        this.freeStatus = freeStatus;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getLastReadChapterId() {
        return lastReadChapterId;
    }

    public void setLastReadChapterId(String lastReadChapterId) {
        this.lastReadChapterId = lastReadChapterId;
    }

    public String getOnShelf() {
        return onShelf;
    }

    public void setOnShelf(String onShelf) {
        this.onShelf = onShelf;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public String getReadWords() {
        return readWords;
    }

    public void setReadWords(String readWords) {
        this.readWords = readWords;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getCBID() {
        return this.cBID;
    }

    public void setCBID(String cBID) {
        this.cBID = cBID;
    }

    public String getIsReadCard() {
        return isReadCard;
    }

    public void setIsReadCard(String isReadCard) {
        this.isReadCard = isReadCard;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(int chapterCount) {
        this.chapterCount = chapterCount;
    }
}
