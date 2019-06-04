package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.ReadPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReadActivity_MembersInjector implements MembersInjector<ReadActivity> {
  private final Provider<ReadPresenter> mPresenterProvider;

  public ReadActivity_MembersInjector(Provider<ReadPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ReadActivity> create(Provider<ReadPresenter> mPresenterProvider) {
    return new ReadActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ReadActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
