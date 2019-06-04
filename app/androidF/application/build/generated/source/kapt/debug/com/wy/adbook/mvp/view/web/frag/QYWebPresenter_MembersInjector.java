package com.wy.adbook.mvp.view.web.frag;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QYWebPresenter_MembersInjector implements MembersInjector<QYWebPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public QYWebPresenter_MembersInjector(Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static MembersInjector<QYWebPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new QYWebPresenter_MembersInjector(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(QYWebPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }
}
