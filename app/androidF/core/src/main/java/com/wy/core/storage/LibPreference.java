package com.wy.core.storage;


import com.wy.core.utils.BasePreference;

/**
 * 通用配置项
 */
public class LibPreference extends BasePreference {

    private static final String PREFERENCE_NAME = "lib_common";

    public static final String KEY_WIFI_MAC = "wifiMac";
    public static final String KEY_CHANNEL_ID = "key_channel_id";//渠道号
    public static final String KEY_CHANNEL_NAME = "key_channel_name";//渠道名称
    public static final String KEY_WIFI_UUID = "uuid";


    private static LibPreference mLibPreference;

    public static LibPreference getInstance() {
        if (mLibPreference == null) {
            mLibPreference = new LibPreference();
        }
        return mLibPreference;
    }


    @Override
    protected String getPreferenceName() {
        return PREFERENCE_NAME;
    }


}