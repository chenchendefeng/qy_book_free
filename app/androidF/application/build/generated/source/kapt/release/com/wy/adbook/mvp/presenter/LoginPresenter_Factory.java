package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.LoginContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginPresenter_Factory implements Factory<LoginPresenter> {
  private final Provider<LoginContract.Model> modelProvider;

  private final Provider<LoginContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public LoginPresenter_Factory(
      Provider<LoginContract.Model> modelProvider,
      Provider<LoginContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public LoginPresenter get() {
    LoginPresenter instance = new LoginPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static LoginPresenter_Factory create(
      Provider<LoginContract.Model> modelProvider,
      Provider<LoginContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new LoginPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static LoginPresenter newLoginPresenter(
      LoginContract.Model model, LoginContract.View view) {
    return new LoginPresenter(model, view);
  }
}
