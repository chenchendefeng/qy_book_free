package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.FaceToFacePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FaceToFaceActivity_MembersInjector
    implements MembersInjector<FaceToFaceActivity> {
  private final Provider<FaceToFacePresenter> mPresenterProvider;

  public FaceToFaceActivity_MembersInjector(Provider<FaceToFacePresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<FaceToFaceActivity> create(
      Provider<FaceToFacePresenter> mPresenterProvider) {
    return new FaceToFaceActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(FaceToFaceActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
