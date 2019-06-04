package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.AboutUsContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AboutUsPresenter_Factory implements Factory<AboutUsPresenter> {
  private final Provider<AboutUsContract.Model> modelProvider;

  private final Provider<AboutUsContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public AboutUsPresenter_Factory(
      Provider<AboutUsContract.Model> modelProvider,
      Provider<AboutUsContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public AboutUsPresenter get() {
    AboutUsPresenter instance = new AboutUsPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static AboutUsPresenter_Factory create(
      Provider<AboutUsContract.Model> modelProvider,
      Provider<AboutUsContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new AboutUsPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static AboutUsPresenter newAboutUsPresenter(
      AboutUsContract.Model model, AboutUsContract.View view) {
    return new AboutUsPresenter(model, view);
  }
}
