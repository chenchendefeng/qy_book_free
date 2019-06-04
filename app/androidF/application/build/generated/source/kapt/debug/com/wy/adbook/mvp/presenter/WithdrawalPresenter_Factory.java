package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.WithdrawalContract;
import com.wy.adbook.mvp.model.entity.WithdrawalItem;
import com.wy.adbook.mvp.view.adapter.WithdrawablAdapter;
import dagger.internal.Factory;
import java.util.List;
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

  private final Provider<WithdrawablAdapter> goldAdapterProvider;

  private final Provider<WithdrawablAdapter> cashAdapterProvider;

  private final Provider<List<WithdrawalItem>> goldListProvider;

  private final Provider<List<WithdrawalItem>> cashListProvider;

  public WithdrawalPresenter_Factory(
      Provider<WithdrawalContract.Model> modelProvider,
      Provider<WithdrawalContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<WithdrawablAdapter> goldAdapterProvider,
      Provider<WithdrawablAdapter> cashAdapterProvider,
      Provider<List<WithdrawalItem>> goldListProvider,
      Provider<List<WithdrawalItem>> cashListProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.goldAdapterProvider = goldAdapterProvider;
    this.cashAdapterProvider = cashAdapterProvider;
    this.goldListProvider = goldListProvider;
    this.cashListProvider = cashListProvider;
  }

  @Override
  public WithdrawalPresenter get() {
    WithdrawalPresenter instance = new WithdrawalPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    WithdrawalPresenter_MembersInjector.injectGoldAdapter(instance, goldAdapterProvider.get());
    WithdrawalPresenter_MembersInjector.injectCashAdapter(instance, cashAdapterProvider.get());
    WithdrawalPresenter_MembersInjector.injectGoldList(instance, goldListProvider.get());
    WithdrawalPresenter_MembersInjector.injectCashList(instance, cashListProvider.get());
    return instance;
  }

  public static WithdrawalPresenter_Factory create(
      Provider<WithdrawalContract.Model> modelProvider,
      Provider<WithdrawalContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<WithdrawablAdapter> goldAdapterProvider,
      Provider<WithdrawablAdapter> cashAdapterProvider,
      Provider<List<WithdrawalItem>> goldListProvider,
      Provider<List<WithdrawalItem>> cashListProvider) {
    return new WithdrawalPresenter_Factory(
        modelProvider,
        viewProvider,
        mErrorHandlerProvider,
        goldAdapterProvider,
        cashAdapterProvider,
        goldListProvider,
        cashListProvider);
  }

  public static WithdrawalPresenter newWithdrawalPresenter(
      WithdrawalContract.Model model, WithdrawalContract.View view) {
    return new WithdrawalPresenter(model, view);
  }
}
