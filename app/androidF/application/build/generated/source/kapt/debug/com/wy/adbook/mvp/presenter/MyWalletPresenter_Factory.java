package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.MyWalletContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyWalletPresenter_Factory implements Factory<MyWalletPresenter> {
  private final Provider<MyWalletContract.Model> modelProvider;

  private final Provider<MyWalletContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public MyWalletPresenter_Factory(
      Provider<MyWalletContract.Model> modelProvider,
      Provider<MyWalletContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public MyWalletPresenter get() {
    MyWalletPresenter instance = new MyWalletPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static MyWalletPresenter_Factory create(
      Provider<MyWalletContract.Model> modelProvider,
      Provider<MyWalletContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new MyWalletPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static MyWalletPresenter newMyWalletPresenter(
      MyWalletContract.Model model, MyWalletContract.View view) {
    return new MyWalletPresenter(model, view);
  }
}
