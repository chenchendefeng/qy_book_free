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
public final class BasicInfoPresenter_MembersInjector
    implements MembersInjector<BasicInfoPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public BasicInfoPresenter_MembersInjector(Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static MembersInjector<BasicInfoPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new BasicInfoPresenter_MembersInjector(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(BasicInfoPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }
}
