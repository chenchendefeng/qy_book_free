package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.VipPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class VipActivity_MembersInjector implements MembersInjector<VipActivity> {
  private final Provider<VipPresenter> mPresenterProvider;

  public VipActivity_MembersInjector(Provider<VipPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<VipActivity> create(Provider<VipPresenter> mPresenterProvider) {
    return new VipActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(VipActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
