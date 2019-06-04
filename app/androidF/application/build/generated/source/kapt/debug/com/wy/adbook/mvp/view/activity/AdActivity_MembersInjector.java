package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.AdPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AdActivity_MembersInjector implements MembersInjector<AdActivity> {
  private final Provider<AdPresenter> mPresenterProvider;

  public AdActivity_MembersInjector(Provider<AdPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AdActivity> create(Provider<AdPresenter> mPresenterProvider) {
    return new AdActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AdActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
