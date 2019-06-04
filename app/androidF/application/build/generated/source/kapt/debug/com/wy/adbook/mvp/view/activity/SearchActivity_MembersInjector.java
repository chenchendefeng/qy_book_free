package com.wy.adbook.mvp.view.activity;

import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.SearchPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SearchActivity_MembersInjector implements MembersInjector<SearchActivity> {
  private final Provider<SearchPresenter> mPresenterProvider;

  public SearchActivity_MembersInjector(Provider<SearchPresenter> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<SearchActivity> create(
      Provider<SearchPresenter> mPresenterProvider) {
    return new SearchActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(SearchActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
  }
}
