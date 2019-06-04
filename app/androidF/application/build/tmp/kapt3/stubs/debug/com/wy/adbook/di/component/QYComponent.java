package com.wy.adbook.di.component;

import java.lang.System;

/**
 * * Author : zhongwenpeng
 * * Email : 1340751953@qq.com
 * * Time :  2018/11/23
 * * Description : 提供项目中的单例
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\rH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&\u00a8\u0006\u0019"}, d2 = {"Lcom/wy/adbook/di/component/QYComponent;", "", "appManager", "Lcom/jess/arms/integration/AppManager;", "application", "Landroid/app/Application;", "cacheFactory", "Lcom/jess/arms/integration/cache/Cache$Factory;", "cacheFile", "Ljava/io/File;", "executorService", "Ljava/util/concurrent/ExecutorService;", "extras", "Lcom/jess/arms/integration/cache/Cache;", "", "gson", "Lcom/google/gson/Gson;", "imageLoader", "Lcom/jess/arms/http/imageloader/ImageLoader;", "okHttpClient", "Lokhttp3/OkHttpClient;", "repositoryManager", "Lcom/jess/arms/integration/IRepositoryManager;", "rxErrorHandler", "Lme/jessyan/rxerrorhandler/core/RxErrorHandler;", "application_debug"})
@dagger.Component(modules = {com.wy.adbook.di.module.QYModule.class}, dependencies = {com.jess.arms.di.component.AppComponent.class})
@com.wy.adbook.di.scope.QYScope()
public abstract interface QYComponent {
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.app.Application application();
    
    /**
     * * 用于管理所有 [Activity]
     *     * 之前 [AppManager] 使用 Dagger 保证单例, 只能使用 [AppComponent.appManager] 访问
     *     * 现在直接将 AppManager 独立为单例类, 可以直接通过静态方法 [AppManager.getAppManager] 访问, 更加方便
     *     * 但为了不影响之前使用 [AppComponent.appManager] 获取 [AppManager] 的项目, 所以暂时保留这种访问方式
     *     *
     *     * @return [AppManager]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract com.jess.arms.integration.AppManager appManager();
    
    /**
     * * 用于管理网络请求层, 以及数据缓存层
     *     *
     *     * @return [IRepositoryManager]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract com.jess.arms.integration.IRepositoryManager repositoryManager();
    
    /**
     * * RxJava 错误处理管理类
     *     *
     *     * @return [RxErrorHandler]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract me.jessyan.rxerrorhandler.core.RxErrorHandler rxErrorHandler();
    
    /**
     * * 图片加载管理器, 用于加载图片的管理类, 使用策略者模式, 可在运行时动态替换任何图片加载框架
     *     * arms-imageloader-glide 提供 Glide 的策略实现类, 也可以自行实现
     *     * 需要在 [ConfigModule.applyOptions] 中
     *     * 手动注册 [BaseImageLoaderStrategy], [ImageLoader] 才能正常使用
     *     *
     *     * @return
     */
    @org.jetbrains.annotations.NotNull()
    public abstract com.jess.arms.http.imageloader.ImageLoader imageLoader();
    
    /**
     * * 网络请求框架
     *     *
     *     * @return [OkHttpClient]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract okhttp3.OkHttpClient okHttpClient();
    
    /**
     * * Json 序列化库
     *     *
     *     * @return [Gson]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract com.google.gson.Gson gson();
    
    /**
     * * 缓存文件根目录 (RxCache 和 Glide 的缓存都已经作为子文件夹放在这个根目录下), 应该将所有缓存都统一放到这个根目录下
     *     * 便于管理和清理, 可在 [ConfigModule.applyOptions] 种配置
     *     *
     *     * @return [File]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.io.File cacheFile();
    
    /**
     * * 用来存取一些整个 App 公用的数据, 切勿大量存放大容量数据, 这里的存放的数据和 [Application] 的生命周期一致
     *     *
     *     * @return [Cache]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract com.jess.arms.integration.cache.Cache<java.lang.String, java.lang.Object> extras();
    
    /**
     * * 用于创建框架所需缓存对象的工厂
     *     *
     *     * @return [Cache.Factory]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract com.jess.arms.integration.cache.Cache.Factory cacheFactory();
    
    /**
     * * 返回一个全局公用的线程池,适用于大多数异步需求。
     *     * 避免多个线程池创建带来的资源消耗。
     *     *
     *     * @return [ExecutorService]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.concurrent.ExecutorService executorService();
}