package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.WithdrawalRecordContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalRecordPresenter_Factory implements Factory<WithdrawalRecordPresenter> {
  private final Provider<WithdrawalRecordContract.Model> modelProvider;

  private final Provider<WithdrawalRecordContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public WithdrawalRecordPresenter_Factory(
      Provider<WithdrawalRecordContract.Model> modelProvider,
      Provider<WithdrawalRecordContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public WithdrawalRecordPresenter get() {
    WithdrawalRecordPresenter instance =
        new WithdrawalRecordPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static WithdrawalRecordPresenter_Factory create(
      Provider<WithdrawalRecordContract.Model> modelProvider,
      Provider<WithdrawalRecordContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new WithdrawalRecordPresenter_Factory(
        modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static WithdrawalRecordPresenter newWithdrawalRecordPresenter(
      WithdrawalRecordContract.Model model, WithdrawalRecordContract.View view) {
    return new WithdrawalRecordPresenter(model, view);
  }
}
