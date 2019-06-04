package com.wy.core.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.wy.core.BaseApplicationProxy;
import com.wy.core.storage.LibPreference;


/**
 * 渠道获取工具类，建议放置到这里。
 */

public class ChannelUtils {
    private static String mChannelId;
    private static String mChannelName;
    private static final String MARKET_SPLITE = "___";
    private static String CHANNEL_KEY = "UMENG_CHANNEL";

    public static String getChannel() {
        return ChannelUtils.getChannelId(BaseApplicationProxy.getApplicationContext());
    }
    /**
     * 获取渠道
     */
    private static void initChannel(Context context) {
        if (context == null)
            return;

        mChannelId = LibPreference.getInstance().getString(LibPreference.KEY_CHANNEL_ID, null);
        mChannelName = LibPreference.getInstance().getString(LibPreference.KEY_CHANNEL_NAME, null);
        if (!TextUtils.isEmpty(mChannelId)) {
            return;
        }
        boolean isDeuggable = (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        if (isDeuggable) { //debug 测试打包，release 开发打包走if代码，所以release下走else代码，只能用打包工具打包才有渠道信息
            initDebugChannel();
        } else {
            initMetaDataChannel(context);
        }

        if (TextUtils.isEmpty(mChannelId)) {
            mChannelId = "";
        } else {
            LibPreference.getInstance().setValue(LibPreference.KEY_CHANNEL_ID, mChannelId);
            LibPreference.getInstance().setValue(LibPreference.KEY_CHANNEL_NAME, mChannelName);
        }

    }

    //测试渠道获取
    private static void initDebugChannel() {

        String market = "100" + MARKET_SPLITE + "官方渠道";
        if (!TextUtils.isEmpty(market)) {
            int index = market.indexOf(MARKET_SPLITE);//渠道号 渠道名 用 ___隔开
            if (index < 0) {
                mChannelId = market.trim();
                mChannelName = "";
            } else {
                mChannelId = market.substring(0, index).trim();
                mChannelName = market.substring(index + 3).trim();
            }
        }

    }

    //配置渠道号获取
    private static void initMetaDataChannel(Context context) {
        try {
            String market = getMetaData(context, CHANNEL_KEY);
            if (!TextUtils.isEmpty(market)) {
                int index = market.indexOf(MARKET_SPLITE);//渠道号 渠道名 用 ___隔开
                if (index < 0) {
                    mChannelId = market.trim();
                    mChannelName = "";
                } else {
                    mChannelId = market.substring(0, index).trim();
                    mChannelName = market.substring(index + 3).trim();
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static String getMetaData(Context context, String key) throws PackageManager.NameNotFoundException {
        ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
        String value = appInfo.metaData.getString(key);
        if (TextUtils.isEmpty(value)) {
            value = appInfo.metaData.getInt(key) + "";
        }
        return value;
    }

    public static String getChannelId(Context context) {
        if (TextUtils.isEmpty(mChannelId)) {
            initChannel(context);
        }
        return mChannelId;

    }

    public static String getChannelName(Context context) {
        if (TextUtils.isEmpty(mChannelId)) {//ChanneName 允许为null
            initChannel(context);
        }
        return mChannelName;
    }
}
