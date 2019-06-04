package com.wy.adbook.mvp.view.web.act;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WebPresenter_Factory implements Factory<WebPresenter> {
  private final Provider<WebContract.Model> modelProvider;

  private final Provider<WebContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public WebPresenter_Factory(
      Provider<WebContract.Model> modelProvider,
      Provider<WebContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public WebPresenter get() {
    WebPresenter instance = new WebPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static WebPresenter_Factory create(
      Provider<WebContract.Model> modelProvider,
      Provider<WebContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new WebPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static WebPresenter newWebPresenter(WebContract.Model model, WebContract.View view) {
    return new WebPresenter(model, view);
  }
}
