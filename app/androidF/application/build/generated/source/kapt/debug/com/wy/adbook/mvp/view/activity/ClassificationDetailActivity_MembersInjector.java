package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.ClassificationDetailPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClassificationDetailActivity_MembersInjector
    implements MembersInjector<ClassificationDetailActivity> {
  private final Provider<ClassificationDetailPresenter> mPresenterProvider;

  public ClassificationDetailActivity_MembersInjector(
      Provider<ClassificationDetailPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ClassificationDetailActivity> create(
      Provider<ClassificationDetailPresenter> mPresenterProvider) {
    return new ClassificationDetailActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ClassificationDetailActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
