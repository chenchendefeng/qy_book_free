package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.IWelcomeContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WelcomePresenter_Factory implements Factory<WelcomePresenter> {
  private final Provider<IWelcomeContract.Model> modelProvider;

  private final Provider<IWelcomeContract.View> rootViewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public WelcomePresenter_Factory(
      Provider<IWelcomeContract.Model> modelProvider,
      Provider<IWelcomeContract.View> rootViewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.rootViewProvider = rootViewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public WelcomePresenter get() {
    WelcomePresenter instance = new WelcomePresenter(modelProvider.get(), rootViewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static WelcomePresenter_Factory create(
      Provider<IWelcomeContract.Model> modelProvider,
      Provider<IWelcomeContract.View> rootViewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new WelcomePresenter_Factory(modelProvider, rootViewProvider, mErrorHandlerProvider);
  }

  public static WelcomePresenter newWelcomePresenter(
      IWelcomeContract.Model model, IWelcomeContract.View rootView) {
    return new WelcomePresenter(model, rootView);
  }
}
