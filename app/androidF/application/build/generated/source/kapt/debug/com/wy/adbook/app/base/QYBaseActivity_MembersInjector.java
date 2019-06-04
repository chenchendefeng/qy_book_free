package com.wy.adbook.app.base;

import com.jess.arms.mvp.IPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QYBaseActivity_MembersInjector<P extends IPresenter>
    implements MembersInjector<QYBaseActivity<P>> {
  private final Provider<P> mPresenterProvider;

  public QYBaseActivity_MembersInjector(Provider<P> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static <P extends IPresenter> MembersInjector<QYBaseActivity<P>> create(
      Provider<P> mPresenterProvider) {
    return new QYBaseActivity_MembersInjector<P>(mPresenterProvider);
  }

  @Override
  public void injectMembers(QYBaseActivity<P> instance) {
    injectMPresenter(instance, mPresenterProvider.get());
  }

  public static <P extends IPresenter> void injectMPresenter(
      QYBaseActivity<P> instance, P mPresenter) {
    instance.mPresenter = mPresenter;
  }
}
