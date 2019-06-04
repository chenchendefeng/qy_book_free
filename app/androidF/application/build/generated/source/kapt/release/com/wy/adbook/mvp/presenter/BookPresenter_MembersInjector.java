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
public final class BookPresenter_MembersInjector implements MembersInjector<BookPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public BookPresenter_MembersInjector(Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static MembersInjector<BookPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new BookPresenter_MembersInjector(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(BookPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }
}
