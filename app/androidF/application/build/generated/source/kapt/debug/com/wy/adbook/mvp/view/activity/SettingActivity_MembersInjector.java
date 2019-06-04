package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.SettingPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SettingActivity_MembersInjector implements MembersInjector<SettingActivity> {
  private final Provider<SettingPresenter> mPresenterProvider;

  public SettingActivity_MembersInjector(Provider<SettingPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<SettingActivity> create(
      Provider<SettingPresenter> mPresenterProvider) {
    return new SettingActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(SettingActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
