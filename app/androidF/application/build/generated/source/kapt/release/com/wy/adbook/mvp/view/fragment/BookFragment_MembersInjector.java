package com.wy.adbook.mvp.view.fragment;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.wy.adbook.mvp.presenter.BookPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookFragment_MembersInjector implements MembersInjector<BookFragment> {
  private final Provider<BookPresenter> mPresenterProvider;

  public BookFragment_MembersInjector(Provider<BookPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<BookFragment> create(Provider<BookPresenter> mPresenterProvider) {
    return new BookFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(BookFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
