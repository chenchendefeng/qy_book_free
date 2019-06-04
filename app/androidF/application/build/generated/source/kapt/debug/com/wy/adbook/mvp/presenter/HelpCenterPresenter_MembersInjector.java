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
public final class HelpCenterPresenter_MembersInjector
    implements MembersInjector<HelpCenterPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public HelpCenterPresenter_MembersInjector(Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static MembersInjector<HelpCenterPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new HelpCenterPresenter_MembersInjector(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(HelpCenterPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }
}
