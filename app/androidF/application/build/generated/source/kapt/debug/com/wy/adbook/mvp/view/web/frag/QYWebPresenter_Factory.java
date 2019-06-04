package com.wy.adbook.mvp.view.web.frag;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QYWebPresenter_Factory implements Factory<QYWebPresenter> {
  private final Provider<QYWebContract.Model> modelProvider;

  private final Provider<QYWebContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public QYWebPresenter_Factory(
      Provider<QYWebContract.Model> modelProvider,
      Provider<QYWebContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public QYWebPresenter get() {
    QYWebPresenter instance = new QYWebPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static QYWebPresenter_Factory create(
      Provider<QYWebContract.Model> modelProvider,
      Provider<QYWebContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new QYWebPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static QYWebPresenter newQYWebPresenter(
      QYWebContract.Model model, QYWebContract.View view) {
    return new QYWebPresenter(model, view);
  }
}
