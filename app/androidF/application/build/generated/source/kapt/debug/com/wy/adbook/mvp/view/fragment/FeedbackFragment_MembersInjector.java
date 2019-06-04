package com.wy.adbook.mvp.view.fragment;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.wy.adbook.mvp.presenter.FeedbackPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FeedbackFragment_MembersInjector implements MembersInjector<FeedbackFragment> {
  private final Provider<FeedbackPresenter> mPresenterProvider;

  public FeedbackFragment_MembersInjector(Provider<FeedbackPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<FeedbackFragment> create(
      Provider<FeedbackPresenter> mPresenterProvider) {
    return new FeedbackFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(FeedbackFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
