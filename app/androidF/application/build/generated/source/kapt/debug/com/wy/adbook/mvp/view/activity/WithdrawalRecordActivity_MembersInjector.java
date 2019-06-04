package com.wy.adbook.mvp.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.WithdrawalRecordPresenter;
import com.wy.adbook.mvp.view.adapter.WithdrawalRecordAdapter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WithdrawalRecordActivity_MembersInjector
    implements MembersInjector<WithdrawalRecordActivity> {
  private final Provider<WithdrawalRecordPresenter> mPresenterProvider;

  private final Provider<WithdrawalRecordAdapter> withdrawalRecordAdapterProvider;

  private final Provider<LinearLayoutManager> linearLayoutManagerProvider;

  public WithdrawalRecordActivity_MembersInjector(
      Provider<WithdrawalRecordPresenter> mPresenterProvider,
      Provider<WithdrawalRecordAdapter> withdrawalRecordAdapterProvider,
      Provider<LinearLayoutManager> linearLayoutManagerProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.withdrawalRecordAdapterProvider = withdrawalRecordAdapterProvider;
    this.linearLayoutManagerProvider = linearLayoutManagerProvider;
  }

  public static MembersInjector<WithdrawalRecordActivity> create(
      Provider<WithdrawalRecordPresenter> mPresenterProvider,
      Provider<WithdrawalRecordAdapter> withdrawalRecordAdapterProvider,
      Provider<LinearLayoutManager> linearLayoutManagerProvider) {
    return new WithdrawalRecordActivity_MembersInjector(
        mPresenterProvider, withdrawalRecordAdapterProvider, linearLayoutManagerProvider);
  }

  @Override
  public void injectMembers(WithdrawalRecordActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectWithdrawalRecordAdapter(instance, withdrawalRecordAdapterProvider.get());
    injectLinearLayoutManager(instance, linearLayoutManagerProvider.get());
  }

  public static void injectWithdrawalRecordAdapter(
      WithdrawalRecordActivity instance, WithdrawalRecordAdapter withdrawalRecordAdapter) {
    instance.withdrawalRecordAdapter = withdrawalRecordAdapter;
  }

  public static void injectLinearLayoutManager(
      WithdrawalRecordActivity instance, LinearLayoutManager linearLayoutManager) {
    instance.linearLayoutManager = linearLayoutManager;
  }
}
