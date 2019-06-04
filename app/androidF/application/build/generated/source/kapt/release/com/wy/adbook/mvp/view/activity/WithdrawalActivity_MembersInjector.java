package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.WithdrawalPresenter;
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

  public WithdrawalActivity_MembersInjector(Provider<WithdrawalPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<WithdrawalActivity> create(
      Provider<WithdrawalPresenter> mPresenterProvider) {
    return new WithdrawalActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(WithdrawalActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
