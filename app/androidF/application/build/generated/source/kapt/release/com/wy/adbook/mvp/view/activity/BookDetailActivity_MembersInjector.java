package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.BookDetailPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookDetailActivity_MembersInjector
    implements MembersInjector<BookDetailActivity> {
  private final Provider<BookDetailPresenter> mPresenterProvider;

  public BookDetailActivity_MembersInjector(Provider<BookDetailPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<BookDetailActivity> create(
      Provider<BookDetailPresenter> mPresenterProvider) {
    return new BookDetailActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(BookDetailActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
