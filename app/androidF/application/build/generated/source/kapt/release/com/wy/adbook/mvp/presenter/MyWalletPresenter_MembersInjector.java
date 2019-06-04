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
public final class MyWalletPresenter_MembersInjector implements MembersInjector<MyWalletPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public MyWalletPresenter_MembersInjector(Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static MembersInjector<MyWalletPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new MyWalletPresenter_MembersInjector(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(MyWalletPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }
}
