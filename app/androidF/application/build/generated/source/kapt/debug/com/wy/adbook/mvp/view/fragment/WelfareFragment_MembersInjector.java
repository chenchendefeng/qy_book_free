package com.wy.adbook.mvp.view.fragment;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.wy.adbook.mvp.presenter.WelfarePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WelfareFragment_MembersInjector implements MembersInjector<WelfareFragment> {
  private final Provider<WelfarePresenter> mPresenterProvider;

  public WelfareFragment_MembersInjector(Provider<WelfarePresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<WelfareFragment> create(
      Provider<WelfarePresenter> mPresenterProvider) {
    return new WelfareFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(WelfareFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
