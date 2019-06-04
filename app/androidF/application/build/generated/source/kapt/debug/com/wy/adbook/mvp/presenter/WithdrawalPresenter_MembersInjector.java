package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.model.entity.WithdrawalItem;
import com.wy.adbook.mvp.view.adapter.WithdrawablAdapter;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalPresenter_MembersInjector
    implements MembersInjector<WithdrawalPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<WithdrawablAdapter> goldAdapterProvider;

  private final Provider<WithdrawablAdapter> cashAdapterProvider;

  private final Provider<List<WithdrawalItem>> goldListProvider;

  private final Provider<List<WithdrawalItem>> cashListProvider;

  public WithdrawalPresenter_MembersInjector(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<WithdrawablAdapter> goldAdapterProvider,
      Provider<WithdrawablAdapter> cashAdapterProvider,
      Provider<List<WithdrawalItem>> goldListProvider,
      Provider<List<WithdrawalItem>> cashListProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.goldAdapterProvider = goldAdapterProvider;
    this.cashAdapterProvider = cashAdapterProvider;
    this.goldListProvider = goldListProvider;
    this.cashListProvider = cashListProvider;
  }

  public static MembersInjector<WithdrawalPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<WithdrawablAdapter> goldAdapterProvider,
      Provider<WithdrawablAdapter> cashAdapterProvider,
      Provider<List<WithdrawalItem>> goldListProvider,
      Provider<List<WithdrawalItem>> cashListProvider) {
    return new WithdrawalPresenter_MembersInjector(
        mErrorHandlerProvider,
        goldAdapterProvider,
        cashAdapterProvider,
        goldListProvider,
        cashListProvider);
  }

  @Override
  public void injectMembers(WithdrawalPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    injectGoldAdapter(instance, goldAdapterProvider.get());
    injectCashAdapter(instance, cashAdapterProvider.get());
    injectGoldList(instance, goldListProvider.get());
    injectCashList(instance, cashListProvider.get());
  }

  public static void injectGoldAdapter(
      WithdrawalPresenter instance, WithdrawablAdapter goldAdapter) {
    instance.goldAdapter = goldAdapter;
  }

  public static void injectCashAdapter(
      WithdrawalPresenter instance, WithdrawablAdapter cashAdapter) {
    instance.cashAdapter = cashAdapter;
  }

  public static void injectGoldList(WithdrawalPresenter instance, List<WithdrawalItem> goldList) {
    instance.goldList = goldList;
  }

  public static void injectCashList(WithdrawalPresenter instance, List<WithdrawalItem> cashList) {
    instance.cashList = cashList;
  }
}
