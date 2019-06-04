package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.AboutUsPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AboutUsActivity_MembersInjector implements MembersInjector<AboutUsActivity> {
  private final Provider<AboutUsPresenter> mPresenterProvider;

  public AboutUsActivity_MembersInjector(Provider<AboutUsPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AboutUsActivity> create(
      Provider<AboutUsPresenter> mPresenterProvider) {
    return new AboutUsActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AboutUsActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
