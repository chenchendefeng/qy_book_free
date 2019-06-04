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
public final class WalletItemPresenter_MembersInjector
    implements MembersInjector<WalletItemPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public WalletItemPresenter_MembersInjector(Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static MembersInjector<WalletItemPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new WalletItemPresenter_MembersInjector(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(WalletItemPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }
}
