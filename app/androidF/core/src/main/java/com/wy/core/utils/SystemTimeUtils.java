package com.wy.core.utils;

import android.os.SystemClock;

public class SystemTimeUtils {
    private static long mCurrecPutTime;//当前存入的时间
    private static long mCurrecPutLast;//当前存入的时间

    public synchronized static void putTime(long time) {
        mCurrecPutTime = time;
        mCurrecPutLast = SystemClock.elapsedRealtime();
    }


    public synchronized static long getTime() {
        if (mCurrecPutTime <= 0) {
            return System.currentTimeMillis();
        }
        return mCurrecPutTime + SystemClock.elapsedRealtime() - mCurrecPutLast;
    }

}
