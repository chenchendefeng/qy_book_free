package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.WelcomePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WelcomeActivity_MembersInjector implements MembersInjector<WelcomeActivity> {
  private final Provider<WelcomePresenter> mPresenterProvider;

  public WelcomeActivity_MembersInjector(Provider<WelcomePresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<WelcomeActivity> create(
      Provider<WelcomePresenter> mPresenterProvider) {
    return new WelcomeActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(WelcomeActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
