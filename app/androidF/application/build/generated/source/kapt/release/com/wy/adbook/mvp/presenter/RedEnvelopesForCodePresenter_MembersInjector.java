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
public final class RedEnvelopesForCodePresenter_MembersInjector
    implements MembersInjector<RedEnvelopesForCodePresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public RedEnvelopesForCodePresenter_MembersInjector(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static MembersInjector<RedEnvelopesForCodePresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new RedEnvelopesForCodePresenter_MembersInjector(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(RedEnvelopesForCodePresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }
}
