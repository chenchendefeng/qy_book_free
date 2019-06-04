package com.wy.adbook.mvp.view.fragment;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.wy.adbook.mvp.presenter.MyPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyFragment_MembersInjector implements MembersInjector<MyFragment> {
  private final Provider<MyPresenter> mPresenterProvider;

  public MyFragment_MembersInjector(Provider<MyPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MyFragment> create(Provider<MyPresenter> mPresenterProvider) {
    return new MyFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MyFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
