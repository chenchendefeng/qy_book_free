package com.wy.adbook.mvp.view.web.act;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WebActivity_MembersInjector implements MembersInjector<WebActivity> {
  private final Provider<WebPresenter> mPresenterProvider;

  public WebActivity_MembersInjector(Provider<WebPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<WebActivity> create(Provider<WebPresenter> mPresenterProvider) {
    return new WebActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(WebActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
