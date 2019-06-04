package com.wy.adbook.mvp.view.activity;

import com.freebookqy.viewlib.rv.layoutmanager.FullyGridLayoutManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.WithdrawalPresenter;
import com.wy.adbook.mvp.view.adapter.WithdrawablAdapter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalActivity_MembersInjector
    implements MembersInjector<WithdrawalActivity> {
  private final Provider<WithdrawalPresenter> mPresenterProvider;

  private final Provider<WithdrawablAdapter> goldAdapterProvider;

  private final Provider<WithdrawablAdapter> cashAdapterProvider;

  private final Provider<FullyGridLayoutManager> glm1Provider;

  private final Provider<FullyGridLayoutManager> glm2Provider;

  public WithdrawalActivity_MembersInjector(
      Provider<WithdrawalPresenter> mPresenterProvider,
      Provider<WithdrawablAdapter> goldAdapterProvider,
      Provider<WithdrawablAdapter> cashAdapterProvider,
      Provider<FullyGridLayoutManager> glm1Provider,
      Provider<FullyGridLayoutManager> glm2Provider) {
    this.mPresenterProvider = mPresenterProvider;
    this.goldAdapterProvider = goldAdapterProvider;
    this.cashAdapterProvider = cashAdapterProvider;
    this.glm1Provider = glm1Provider;
    this.glm2Provider = glm2Provider;
  }

  public static MembersInjector<WithdrawalActivity> create(
      Provider<WithdrawalPresenter> mPresenterProvider,
      Provider<WithdrawablAdapter> goldAdapterProvider,
      Provider<WithdrawablAdapter> cashAdapterProvider,
      Provider<FullyGridLayoutManager> glm1Provider,
      Provider<FullyGridLayoutManager> glm2Provider) {
    return new WithdrawalActivity_MembersInjector(
        mPresenterProvider, goldAdapterProvider, cashAdapterProvider, glm1Provider, glm2Provider);
  }

  @Override
  public void injectMembers(WithdrawalActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectGoldAdapter(instance, goldAdapterProvider.get());
    injectCashAdapter(instance, cashAdapterProvider.get());
    injectGlm1(instance, glm1Provider.get());
    injectGlm2(instance, glm2Provider.get());
  }

  public static void injectGoldAdapter(
      WithdrawalActivity instance, WithdrawablAdapter goldAdapter) {
    instance.goldAdapter = goldAdapter;
  }

  public static void injectCashAdapter(
      WithdrawalActivity instance, WithdrawablAdapter cashAdapter) {
    instance.cashAdapter = cashAdapter;
  }

  public static void injectGlm1(WithdrawalActivity instance, FullyGridLayoutManager glm1) {
    instance.glm1 = glm1;
  }

  public static void injectGlm2(WithdrawalActivity instance, FullyGridLayoutManager glm2) {
    instance.glm2 = glm2;
  }
}
