package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.RemoveAdSuccessPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoveAdSuccessActivity_MembersInjector
    implements MembersInjector<RemoveAdSuccessActivity> {
  private final Provider<RemoveAdSuccessPresenter> mPresenterProvider;

  public RemoveAdSuccessActivity_MembersInjector(
      Provider<RemoveAdSuccessPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<RemoveAdSuccessActivity> create(
      Provider<RemoveAdSuccessPresenter> mPresenterProvider) {
    return new RemoveAdSuccessActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(RemoveAdSuccessActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
