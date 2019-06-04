package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.WithdrawalRecordPresenter;
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

  public WithdrawalRecordActivity_MembersInjector(
      Provider<WithdrawalRecordPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<WithdrawalRecordActivity> create(
      Provider<WithdrawalRecordPresenter> mPresenterProvider) {
    return new WithdrawalRecordActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(WithdrawalRecordActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
