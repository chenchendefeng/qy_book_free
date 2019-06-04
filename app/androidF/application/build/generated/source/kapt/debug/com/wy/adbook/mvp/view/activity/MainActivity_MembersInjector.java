package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.MainPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<MainPresenter> mPresenterProvider;

  public MainActivity_MembersInjector(Provider<MainPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<MainPresenter> mPresenterProvider) {
    return new MainActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
