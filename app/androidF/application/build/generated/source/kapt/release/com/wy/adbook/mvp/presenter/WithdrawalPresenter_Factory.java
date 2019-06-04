package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.WithdrawalContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalPresenter_Factory implements Factory<WithdrawalPresenter> {
  private final Provider<WithdrawalContract.Model> modelProvider;

  private final Provider<WithdrawalContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public WithdrawalPresenter_Factory(
      Provider<WithdrawalContract.Model> modelProvider,
      Provider<WithdrawalContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public WithdrawalPresenter get() {
    WithdrawalPresenter instance = new WithdrawalPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static WithdrawalPresenter_Factory create(
      Provider<WithdrawalContract.Model> modelProvider,
      Provider<WithdrawalContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new WithdrawalPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static WithdrawalPresenter newWithdrawalPresenter(
      WithdrawalContract.Model model, WithdrawalContract.View view) {
    return new WithdrawalPresenter(model, view);
  }
}
