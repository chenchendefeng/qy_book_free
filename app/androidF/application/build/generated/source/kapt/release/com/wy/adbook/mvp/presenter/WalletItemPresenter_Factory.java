package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.WalletItemContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WalletItemPresenter_Factory implements Factory<WalletItemPresenter> {
  private final Provider<WalletItemContract.Model> modelProvider;

  private final Provider<WalletItemContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public WalletItemPresenter_Factory(
      Provider<WalletItemContract.Model> modelProvider,
      Provider<WalletItemContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public WalletItemPresenter get() {
    WalletItemPresenter instance = new WalletItemPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static WalletItemPresenter_Factory create(
      Provider<WalletItemContract.Model> modelProvider,
      Provider<WalletItemContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new WalletItemPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static WalletItemPresenter newWalletItemPresenter(
      WalletItemContract.Model model, WalletItemContract.View view) {
    return new WalletItemPresenter(model, view);
  }
}
