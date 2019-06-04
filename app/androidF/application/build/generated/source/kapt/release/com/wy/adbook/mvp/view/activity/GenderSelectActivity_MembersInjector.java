package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.GenderPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GenderSelectActivity_MembersInjector
    implements MembersInjector<GenderSelectActivity> {
  private final Provider<GenderPresenter> mPresenterProvider;

  public GenderSelectActivity_MembersInjector(Provider<GenderPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<GenderSelectActivity> create(
      Provider<GenderPresenter> mPresenterProvider) {
    return new GenderSelectActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(GenderSelectActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
