package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.ClassificationDetailContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationDetailPresenter_Factory
    implements Factory<ClassificationDetailPresenter> {
  private final Provider<ClassificationDetailContract.Model> modelProvider;

  private final Provider<ClassificationDetailContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public ClassificationDetailPresenter_Factory(
      Provider<ClassificationDetailContract.Model> modelProvider,
      Provider<ClassificationDetailContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public ClassificationDetailPresenter get() {
    ClassificationDetailPresenter instance =
        new ClassificationDetailPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static ClassificationDetailPresenter_Factory create(
      Provider<ClassificationDetailContract.Model> modelProvider,
      Provider<ClassificationDetailContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new ClassificationDetailPresenter_Factory(
        modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static ClassificationDetailPresenter newClassificationDetailPresenter(
      ClassificationDetailContract.Model model, ClassificationDetailContract.View view) {
    return new ClassificationDetailPresenter(model, view);
  }
}
