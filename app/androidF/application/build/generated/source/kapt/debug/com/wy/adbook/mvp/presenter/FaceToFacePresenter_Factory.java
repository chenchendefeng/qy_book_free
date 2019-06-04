package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.FaceToFaceContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FaceToFacePresenter_Factory implements Factory<FaceToFacePresenter> {
  private final Provider<FaceToFaceContract.Model> modelProvider;

  private final Provider<FaceToFaceContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public FaceToFacePresenter_Factory(
      Provider<FaceToFaceContract.Model> modelProvider,
      Provider<FaceToFaceContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public FaceToFacePresenter get() {
    FaceToFacePresenter instance = new FaceToFacePresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static FaceToFacePresenter_Factory create(
      Provider<FaceToFaceContract.Model> modelProvider,
      Provider<FaceToFaceContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new FaceToFacePresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static FaceToFacePresenter newFaceToFacePresenter(
      FaceToFaceContract.Model model, FaceToFaceContract.View view) {
    return new FaceToFacePresenter(model, view);
  }
}
