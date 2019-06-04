package com.wy.adbook.mvp.view.fragment;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.wy.adbook.mvp.presenter.WalletItemPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WalletItemFragment_MembersInjector
    implements MembersInjector<WalletItemFragment> {
  private final Provider<WalletItemPresenter> mPresenterProvider;

  public WalletItemFragment_MembersInjector(Provider<WalletItemPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<WalletItemFragment> create(
      Provider<WalletItemPresenter> mPresenterProvider) {
    return new WalletItemFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(WalletItemFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
