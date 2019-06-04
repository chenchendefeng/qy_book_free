package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.MyWalletPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyWalletActivity_MembersInjector implements MembersInjector<MyWalletActivity> {
  private final Provider<MyWalletPresenter> mPresenterProvider;

  public MyWalletActivity_MembersInjector(Provider<MyWalletPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MyWalletActivity> create(
      Provider<MyWalletPresenter> mPresenterProvider) {
    return new MyWalletActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MyWalletActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
