package com.wy.adbook.app.base;

import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QYBasePresenter_MembersInjector<M extends IModel, V extends IView>
    implements MembersInjector<QYBasePresenter<M, V>> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public QYBasePresenter_MembersInjector(Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  public static <M extends IModel, V extends IView> MembersInjector<QYBasePresenter<M, V>> create(
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new QYBasePresenter_MembersInjector<M, V>(mErrorHandlerProvider);
  }

  @Override
  public void injectMembers(QYBasePresenter<M, V> instance) {
    injectMErrorHandler(instance, mErrorHandlerProvider.get());
  }

  public static <M extends IModel, V extends IView> void injectMErrorHandler(
      QYBasePresenter<M, V> instance, RxErrorHandler mErrorHandler) {
    instance.mErrorHandler = mErrorHandler;
  }
}
