package com.wy.adbook.mvp.view.web.bean;

/**
 * Created by tianwei on 2017/11/14.
 * js调java
 */

public class ExitInfo {
    /**
     * 1表示完成退出WebView，0表示返回上一个页面
     */
    public String isExit;
    /**
     * 回上一个页面
     */
    public static final String BACK = "0";
    /**
     * 关闭Activity
     */
    public static final String FINISH = "1";
}
