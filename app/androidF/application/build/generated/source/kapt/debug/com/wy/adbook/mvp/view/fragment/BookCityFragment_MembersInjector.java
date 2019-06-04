package com.wy.adbook.mvp.view.fragment;

import com.jess.arms.base.BaseFragment_MembersInjector;
import com.wy.adbook.mvp.presenter.BookCityPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookCityFragment_MembersInjector implements MembersInjector<BookCityFragment> {
  private final Provider<BookCityPresenter> mPresenterProvider;

  public BookCityFragment_MembersInjector(Provider<BookCityPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<BookCityFragment> create(
      Provider<BookCityPresenter> mPresenterProvider) {
    return new BookCityFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(BookCityFragment instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
