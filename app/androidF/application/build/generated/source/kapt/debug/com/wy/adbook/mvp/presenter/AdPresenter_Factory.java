package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.AdContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AdPresenter_Factory implements Factory<AdPresenter> {
  private final Provider<AdContract.Model> modelProvider;

  private final Provider<AdContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public AdPresenter_Factory(
      Provider<AdContract.Model> modelProvider,
      Provider<AdContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public AdPresenter get() {
    AdPresenter instance = new AdPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static AdPresenter_Factory create(
      Provider<AdContract.Model> modelProvider,
      Provider<AdContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new AdPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static AdPresenter newAdPresenter(AdContract.Model model, AdContract.View view) {
    return new AdPresenter(model, view);
  }
}
