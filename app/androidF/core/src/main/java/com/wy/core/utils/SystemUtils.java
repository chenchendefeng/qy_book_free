package com.wy.core.utils;

import android.app.Service;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import android.telephony.TelephonyManager;

import com.wy.core.BaseApplicationProxy;

import java.util.UUID;


/**
 * Created by 步惊云 on 2018/12/21.
 */

public class SystemUtils {

    public static String getModel() {
        String model = android.os.Build.MODEL;
        return model;
    }

    //获取版本号
    public static String getAppVersionName(Context context) {
        String version = "";
        try {
            version = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    public static int getAppVersionCode(Context context) {
        int versionCode = 0;
        try {
            versionCode = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取手机IMEI
     *
     * @param context
     * @return
     */
    public static final String getIMEI(Context context) {
        try {
            //实例化TelephonyManager对象
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            //获取IMEI号
            String imei = telephonyManager.getDeviceId();
            //在次做个验证，也不是什么时候都能获取到的啊
            if (imei == null) {
                imei = "";
            }
            return imei;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    /**
     * 获取手机IMSI
     */
    public static String getIMSI(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            //获取IMSI号
            String imsi = telephonyManager.getSubscriberId();
            if (null == imsi) {
                imsi = "";
            }
            return imsi;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获取手机SN
     */
    public static String getSN(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            String sn = telephonyManager.getSimSerialNumber();
            if (null == sn) {
                sn = "";
            }
            return sn;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    //震动
    public static void startVibrator() {
        Vibrator vibrator = (Vibrator) BaseApplicationProxy.getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        //设置震动周期，数组表示时间：等待+执行，单位是毫秒，下面操作代表:等待100，执行100，等待100，执行1000，
        //后面的数字如果为-1代表不重复，之执行一次，其他代表会重复，0代表从数组的第0个位置开始
        vibrator.vibrate(new long[]{100, 100, 100, 1000}, -1);
    }

}
