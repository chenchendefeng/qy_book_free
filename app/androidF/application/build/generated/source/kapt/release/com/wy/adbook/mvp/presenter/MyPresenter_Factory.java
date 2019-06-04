package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.MyContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyPresenter_Factory implements Factory<MyPresenter> {
  private final Provider<MyContract.Model> modelProvider;

  private final Provider<MyContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public MyPresenter_Factory(
      Provider<MyContract.Model> modelProvider,
      Provider<MyContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public MyPresenter get() {
    MyPresenter instance = new MyPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static MyPresenter_Factory create(
      Provider<MyContract.Model> modelProvider,
      Provider<MyContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new MyPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static MyPresenter newMyPresenter(MyContract.Model model, MyContract.View view) {
    return new MyPresenter(model, view);
  }
}
