package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.RedEnvelopesForCodePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RedEnvelopesForCodeActivity_MembersInjector
    implements MembersInjector<RedEnvelopesForCodeActivity> {
  private final Provider<RedEnvelopesForCodePresenter> mPresenterProvider;

  public RedEnvelopesForCodeActivity_MembersInjector(
      Provider<RedEnvelopesForCodePresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<RedEnvelopesForCodeActivity> create(
      Provider<RedEnvelopesForCodePresenter> mPresenterProvider) {
    return new RedEnvelopesForCodeActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(RedEnvelopesForCodeActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
