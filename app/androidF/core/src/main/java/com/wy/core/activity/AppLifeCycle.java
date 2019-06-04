package com.wy.core.activity;


public interface AppLifeCycle {
    /**
     * 启动app，只是指打开进程Activity
     */
    void onOpen();

    /**
     * APP回到前台（从后台进程变成前台进程）
     * @param backgroundRunningTime
     *      App在后台运行的时间（就是从App上次退回后台后到这次回到前台总耗时）如果App是刚启动或进程被回收了，这个值就是0。<br>
     *      可以根据这个值的大小做一些处理，比如App在后台10分钟后再次打开需要重新打开手势密码界面，或重新启动App
     */
    void onBackForeground(long backgroundRunningTime);

    /**
     * app返回后台（从前台进程变为后台进程）
     */
    void onReturnBackground();

    /**
     * 关闭app，并不是退出进程，而是变为空进程，但如果当前进程被其它前台进程绑定，那么当前进程依然处于前台
     */
    void onClose();
}