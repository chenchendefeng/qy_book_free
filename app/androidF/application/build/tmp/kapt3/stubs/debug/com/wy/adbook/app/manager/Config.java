package com.wy.adbook.app.manager;

import java.lang.System;

/**
 * * Created by leafye on 2019-05-17.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/wy/adbook/app/manager/Config;", "", "()V", "getWelefareConfig", "Lcom/wy/adbook/app/manager/Config$WelfareConfig;", "WelfareConfig", "application_debug"})
public final class Config {
    public static final com.wy.adbook.app.manager.Config INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.wy.adbook.app.manager.Config.WelfareConfig getWelefareConfig() {
        return null;
    }
    
    private Config() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/wy/adbook/app/manager/Config$WelfareConfig;", "", "()V", "defRetroactiveConsumptionGoldBeans", "", "defWatchVideoForGold", "spRetroactiveConsumptionGoldBeans", "", "spfWatchVideoForGold", "getRetroactiveConsumptionGoldBeans", "getWatchVideoGetGold", "setRetroactiveConsumptionGoldBeans", "", "consumptionGoldBeans", "setWatchVideoGetGold", "watchVideoGetGold", "application_debug"})
    public static final class WelfareConfig {
        private final java.lang.String spfWatchVideoForGold = "spWatchVideoForGold";
        private final java.lang.String spRetroactiveConsumptionGoldBeans = "spRetroactiveConsumptionGoldBeans";
        
        /**
         * * 看视频可以获取的金豆数
         */
        private final int defWatchVideoForGold = 50;
        
        /**
         * * 补签要消耗的金豆
         */
        private final int defRetroactiveConsumptionGoldBeans = 200;
        
        /**
         * * 获取查看视频获取金豆的数额
         */
        public final int getWatchVideoGetGold() {
            return 0;
        }
        
        /**
         * * 设置查看视频获取金豆的数额
         */
        public final void setWatchVideoGetGold(int watchVideoGetGold) {
        }
        
        /**
         * * 获取补签需要的金豆
         */
        public final int getRetroactiveConsumptionGoldBeans() {
            return 0;
        }
        
        /**
         * * 设置补签需要的金豆
         */
        public final void setRetroactiveConsumptionGoldBeans(int consumptionGoldBeans) {
        }
        
        public WelfareConfig() {
            super();
        }
    }
}