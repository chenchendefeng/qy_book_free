package com.wy.adbook.mvp.view.web;

/**
 * Created by wenzhonghu on 2017/4/26.
 */
public final class NDWebConfig {
    public static String mProtocol;
    public static Class<?> mClazz;
    public static boolean mIsDebug;

    /**
     * 注入jsconfig
     *
     * @param protocol 对应的协议
     * @param c   对应的协议解析类
     */
    public static void init(String protocol, Class c, boolean isDebug) {
        mProtocol = protocol;
        mClazz = c;
        mIsDebug = isDebug;
    }


}
