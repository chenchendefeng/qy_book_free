package com.wy.adbook.mvp.view.web.act;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WebPresenter_MembersInjector implements MembersInjector<WebPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public WebPresenter_MembersInjector(Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static MembersInjector<WebPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new WebPresenter_MembersInjector(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(WebPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }
}
