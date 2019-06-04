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
public final class AboutUsPresenter_MembersInjector implements MembersInjector<AboutUsPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public AboutUsPresenter_MembersInjector(Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static MembersInjector<AboutUsPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new AboutUsPresenter_MembersInjector(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(AboutUsPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }
}
