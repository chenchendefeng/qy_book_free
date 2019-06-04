package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WelcomePresenter_MembersInjector implements MembersInjector<WelcomePresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public WelcomePresenter_MembersInjector(Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static MembersInjector<WelcomePresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new WelcomePresenter_MembersInjector(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(WelcomePresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }
}
