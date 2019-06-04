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
public final class FaceToFacePresenter_MembersInjector
    implements MembersInjector<FaceToFacePresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public FaceToFacePresenter_MembersInjector(Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static MembersInjector<FaceToFacePresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new FaceToFacePresenter_MembersInjector(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(FaceToFacePresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }
}
