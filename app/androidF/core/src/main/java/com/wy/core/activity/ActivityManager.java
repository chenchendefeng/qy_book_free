package com.wy.core.activity;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.wy.core.utils.Action;
import com.wy.core.utils.Iterator;
import com.wy.core.utils.LogUtils;

import java.lang.ref.SoftReference;
import java.util.ListIterator;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;


public class ActivityManager implements Application.ActivityLifecycleCallbacks {

    private static final String TAG = ActivityManager.class.getSimpleName();

    private ActivityManager() {
    }


    /***
     * 结束指定类名的Activity
     *
     * @param cls
     */
    public void finishActivity(Class<?> cls) {
        try {
            ListIterator<SoftReference<Activity>> listIterator = mOpenedActivityReference.listIterator();
            while (listIterator.hasNext()) {
                Activity activity = listIterator.next().get();
                if (activity == null) {
                    listIterator.remove();
                    continue;
                }
                if (activity.getClass() == cls || activity.getClass().getName().equals(cls.getName())) {
                    listIterator.remove();
                    if (activity != null) {
                        activity.finish();
                    }
                    break;
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }

    public void finishActivityExcept(Class<?> cls) {
        try {
            ListIterator<SoftReference<Activity>> listIterator = mOpenedActivityReference.listIterator();
            while (listIterator.hasNext()) {
                Activity activity = listIterator.next().get();
                if (activity == null) {
                    listIterator.remove();
                    continue;
                }
                if (!activity.getClass().getName().equals(cls.getName())) {
                    listIterator.remove();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }

    private static class ActivityManagerInstanceHolder {

        static final ActivityManager INSTANCE = new ActivityManager();
    }

    public static ActivityManager getInstance() {
        return ActivityManagerInstanceHolder.INSTANCE;
    }

    private SoftReference<Activity> mCurrentTopActivityWeakRef;


    private Stack<SoftReference<Activity>> mOpenedActivityReference = new Stack<>();
    /**
     * 记录当前APP打开的Activity个数， 为1时表示刚启动，为0时表示APP进入后台
     */
    private int mActivityStartCount = 0;
    /**
     * 记录上次App退回后台的时间戳
     */
    private long mLastReturnBackTime = 0;

    /**
     * 获取当前在栈顶的activity
     *
     * @return
     */
    public Activity getCurrentTopActivity() {
        Activity currentActivity = null;
        if (mCurrentTopActivityWeakRef != null) {
            currentActivity = mCurrentTopActivityWeakRef.get();
        }
        return currentActivity;
    }

    /**
     * 保存当前栈顶Activity的实例
     *
     * @param activity
     */
    public void setCurrentTopActivity(@NonNull Activity activity) {
        mCurrentTopActivityWeakRef = new SoftReference<>(activity);
    }

    /**
     * 清除当前栈顶Activity实例引用
     */
    public void clearCurrentTopActivityReference() {
        mCurrentTopActivityWeakRef.clear();
    }


    @Override
    public void onActivityCreated(final Activity activity, final Bundle savedInstanceState) {
        SoftReference<Activity> activityRef = new SoftReference<>(activity);
        if (!mOpenedActivityReference.contains(activityRef)) {
            mOpenedActivityReference.add(activityRef);
        }

        Iterator.foreach(mActivityLifeCycles,
                new Action<ActivityLifeCycle>() {
                    @Override
                    public void call(ActivityLifeCycle data) {
                        data.onActivityCreated(new SoftReference<>(activity), savedInstanceState);
                    }
                }
        );
    }

    @Override
    public void onActivityStarted(final Activity activity) {
        mActivityStartCount++;
        if (mActivityStartCount == 1) {
            if (mLastReturnBackTime == 0) {
                //当前App刚启动
                Iterator.foreach(mAppLifeCycles,

                        new Action<AppLifeCycle>() {
                            @Override
                            public void call(AppLifeCycle data) {
                                data.onOpen();
                            }
                        }
                );
            } else {
                final long duration = System.currentTimeMillis() - mLastReturnBackTime;
                //当前App回到前台
                Iterator.foreach(mAppLifeCycles, new Action<AppLifeCycle>() {
                    @Override
                    public void call(AppLifeCycle data) {
                        data.onBackForeground(duration);
                    }
                });
            }
        }
        mLastReturnBackTime = 0;
        Iterator.foreach(mActivityLifeCycles, new Action<ActivityLifeCycle>() {
            @Override
            public void call(ActivityLifeCycle data) {
                data.onActivityStarted(new SoftReference<>(activity));
            }
        });
    }

    @Override
    public void onActivityResumed(final Activity activity) {
        //保存当前的activity实例,不要放到onActivityCreated里面，
        // 因为MainActivity是只会创建一次的，后面就没法保存MainActivity的实例了
        ActivityManager.getInstance().setCurrentTopActivity(activity);

        Iterator.foreach(mActivityLifeCycles, new Action<ActivityLifeCycle>() {
            @Override
            public void call(ActivityLifeCycle data) {
                data.onActivityResumed(new SoftReference<>(activity));
            }
        });
    }

    @Override
    public void onActivityPaused(final Activity activity) {
        //这里可以手动清除一下引用，ActivityManager使用弱引用保存的activity，这里也可以不处理，让GC自己回收
        if (activity.isFinishing()) {
            ActivityManager.getInstance().clearCurrentTopActivityReference();
        }

        Iterator.foreach(mActivityLifeCycles, new Action<ActivityLifeCycle>() {
            @Override
            public void call(ActivityLifeCycle data) {
                data.onActivityPaused(new SoftReference<>(activity));
            }
        });
    }

    @Override
    public void onActivityStopped(final Activity activity) {
        mActivityStartCount--;
        if (mActivityStartCount == 0) {
            //当前App退回后台
            mLastReturnBackTime = System.currentTimeMillis();
            Iterator.foreach(mAppLifeCycles, new Action<AppLifeCycle>() {
                @Override
                public void call(AppLifeCycle data) {
                    data.onReturnBackground();
                }
            });
        }

        Iterator.foreach(mActivityLifeCycles, new Action<ActivityLifeCycle>() {
            @Override
            public void call(ActivityLifeCycle data) {
                data.onActivityStopped(new SoftReference<>(activity));
            }
        });
    }

    @Override
    public void onActivitySaveInstanceState(final Activity activity, final Bundle outState) {
        Iterator.foreach(mActivityLifeCycles, new Action<ActivityLifeCycle>() {
            @Override
            public void call(ActivityLifeCycle data) {
                data.onActivitySaveInstanceState(new SoftReference<>(activity), outState);
            }
        });
    }

    @Override
    public void onActivityDestroyed(final Activity activity) {
        if (mActivityStartCount == 0) {
            //App没有打开的界面,此时app关闭
            mLastReturnBackTime = 0;
            Iterator.foreach(mAppLifeCycles, new Action<AppLifeCycle>() {
                @Override
                public void call(AppLifeCycle data) {
                    data.onClose();
                }
            });
        }

        SoftReference<Activity> activityRef = new SoftReference<>(activity);
        if (mOpenedActivityReference.contains(activityRef)) {
            mOpenedActivityReference.remove(activityRef);
        }

        Iterator.foreach(mActivityLifeCycles, new Action<ActivityLifeCycle>() {
            @Override
            public void call(ActivityLifeCycle data) {
                data.onActivityDestroyed(new SoftReference<>(activity));
            }
        });
    }

    /**
     * 获取当前进程所有打开的界面
     *
     * @return
     */
    public Stack<SoftReference<Activity>> getOpenedActivityReference() {
        return mOpenedActivityReference;
    }

    private CopyOnWriteArrayList<ActivityLifeCycle> mActivityLifeCycles = new CopyOnWriteArrayList<>();

    /**
     * 监听Activity的生命周期
     *
     * @param lifeCycle
     */
    public synchronized void registerActivityLifeCycle(ActivityLifeCycle lifeCycle) {
        if (!mActivityLifeCycles.contains(lifeCycle)) {
            mActivityLifeCycles.add(lifeCycle);
        }
    }

    /**
     * 移除Activity生命周期监听
     *
     * @param lifeCycle
     */
    public synchronized void removeActivityLifeCycle(ActivityLifeCycle lifeCycle) {
        if (mActivityLifeCycles.contains(lifeCycle)) {
            mActivityLifeCycles.remove(lifeCycle);
        }
    }

    /**
     * 判断当前app是否在前台，只支持当前进程
     *
     * @return true: 前台<br>false: 后台
     */
    public boolean appIsInForeground() {
        return mActivityStartCount > 0;
    }

    private CopyOnWriteArrayList<AppLifeCycle> mAppLifeCycles = new CopyOnWriteArrayList<>();

    /**
     * 注册App生命周期监听, 在Activity的onCreate方法中注册，必须在onDestroy方法中移除。也可以在Application中注册
     *
     * @param lifeCycle
     */
    public synchronized void registerAppLifeCycle(AppLifeCycle lifeCycle) {
        if (!mAppLifeCycles.contains(lifeCycle)) {
            mAppLifeCycles.add(lifeCycle);
        }
    }

    /**
     * 移除App生命周期监听，如果在Activity的onCreate方法中注册了，必须要在onDestroy中移除
     *
     * @param lifeCycle
     */
    public synchronized void removeAppLifeCycle(AppLifeCycle lifeCycle) {
        if (mAppLifeCycles.contains(lifeCycle)) {
            mAppLifeCycles.remove(lifeCycle);
        }
    }
}