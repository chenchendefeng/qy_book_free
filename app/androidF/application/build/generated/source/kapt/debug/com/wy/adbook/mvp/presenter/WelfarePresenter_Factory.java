package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.WelfareContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WelfarePresenter_Factory implements Factory<WelfarePresenter> {
  private final Provider<WelfareContract.Model> modelProvider;

  private final Provider<WelfareContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public WelfarePresenter_Factory(
      Provider<WelfareContract.Model> modelProvider,
      Provider<WelfareContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public WelfarePresenter get() {
    WelfarePresenter instance = new WelfarePresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static WelfarePresenter_Factory create(
      Provider<WelfareContract.Model> modelProvider,
      Provider<WelfareContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new WelfarePresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static WelfarePresenter newWelfarePresenter(
      WelfareContract.Model model, WelfareContract.View view) {
    return new WelfarePresenter(model, view);
  }
}
