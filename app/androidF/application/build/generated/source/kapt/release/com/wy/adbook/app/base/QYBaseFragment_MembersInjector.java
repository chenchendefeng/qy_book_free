package com.wy.adbook.app.base;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.jess.arms.mvp.IPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class QYBaseFragment_MembersInjector<P extends IPresenter>
    implements MembersInjector<QYBaseFragment<P>> {
  private final Provider<P> mPresenterProvider;

  public QYBaseFragment_MembersInjector(Provider<P> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static <P extends IPresenter> MembersInjector<QYBaseFragment<P>> create(
      Provider<P> mPresenterProvider) {
    return new QYBaseFragment_MembersInjector<P>(mPresenterProvider);
  }

  @Override
  public void injectMembers(QYBaseFragment<P> instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
