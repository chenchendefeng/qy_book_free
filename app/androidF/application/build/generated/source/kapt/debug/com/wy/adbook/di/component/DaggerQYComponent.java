package com.wy.adbook.di.component;

import android.app.Application;
import com.google.gson.Gson;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.integration.cache.Cache;
import com.wy.adbook.di.module.QYModule;
import dagger.internal.Preconditions;
import java.io.File;
import java.util.concurrent.ExecutorService;
import javax.annotation.Generated;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerQYComponent implements QYComponent {
  private AppComponent appComponent;

  private DaggerQYComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.appComponent = builder.appComponent;
  }

  @Override
  public Application application() {
    return Preconditions.checkNotNull(
        appComponent.application(), "Cannot return null from a non-@Nullable component method");
  }

  @Override
  public AppManager appManager() {
    return Preconditions.checkNotNull(
        appComponent.appManager(), "Cannot return null from a non-@Nullable component method");
  }

  @Override
  public IRepositoryManager repositoryManager() {
    return Preconditions.checkNotNull(
        appComponent.repositoryManager(),
        "Cannot return null from a non-@Nullable component method");
  }

  @Override
  public RxErrorHandler rxErrorHandler() {
    return Preconditions.checkNotNull(
        appComponent.rxErrorHandler(), "Cannot return null from a non-@Nullable component method");
  }

  @Override
  public ImageLoader imageLoader() {
    return Preconditions.checkNotNull(
        appComponent.imageLoader(), "Cannot return null from a non-@Nullable component method");
  }

  @Override
  public OkHttpClient okHttpClient() {
    return Preconditions.checkNotNull(
        appComponent.okHttpClient(), "Cannot return null from a non-@Nullable component method");
  }

  @Override
  public Gson gson() {
    return Preconditions.checkNotNull(
        appComponent.gson(), "Cannot return null from a non-@Nullable component method");
  }

  @Override
  public File cacheFile() {
    return Preconditions.checkNotNull(
        appComponent.cacheFile(), "Cannot return null from a non-@Nullable component method");
  }

  @Override
  public Cache<String, Object> extras() {
    return Preconditions.checkNotNull(
        appComponent.extras(), "Cannot return null from a non-@Nullable component method");
  }

  @Override
  public Cache.Factory cacheFactory() {
    return Preconditions.checkNotNull(
        appComponent.cacheFactory(), "Cannot return null from a non-@Nullable component method");
  }

  @Override
  public ExecutorService executorService() {
    return Preconditions.checkNotNull(
        appComponent.executorService(), "Cannot return null from a non-@Nullable component method");
  }

  public static final class Builder {
    private AppComponent appComponent;

    private Builder() {}

    public QYComponent build() {
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerQYComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This
     *     method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder qYModule(QYModule qYModule) {
      Preconditions.checkNotNull(qYModule);
      return this;
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }
  }
}
