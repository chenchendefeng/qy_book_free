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
public final class ClassificationDetailPresenter_MembersInjector
    implements MembersInjector<ClassificationDetailPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public ClassificationDetailPresenter_MembersInjector(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static MembersInjector<ClassificationDetailPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new ClassificationDetailPresenter_MembersInjector(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(ClassificationDetailPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }
}
