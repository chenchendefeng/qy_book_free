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
public final class RemoveAdSuccessPresenter_MembersInjector
    implements MembersInjector<RemoveAdSuccessPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public RemoveAdSuccessPresenter_MembersInjector(Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static MembersInjector<RemoveAdSuccessPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new RemoveAdSuccessPresenter_MembersInjector(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(RemoveAdSuccessPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }
}
