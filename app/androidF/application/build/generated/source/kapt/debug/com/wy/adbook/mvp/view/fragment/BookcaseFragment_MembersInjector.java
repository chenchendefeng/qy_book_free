package com.wy.adbook.mvp.view.fragment;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.wy.adbook.mvp.presenter.BookcasePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookcaseFragment_MembersInjector implements MembersInjector<BookcaseFragment> {
  private final Provider<BookcasePresenter> mPresenterProvider;

  public BookcaseFragment_MembersInjector(Provider<BookcasePresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<BookcaseFragment> create(
      Provider<BookcasePresenter> mPresenterProvider) {
    return new BookcaseFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(BookcaseFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
