package com.wy.adbook.mvp.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import com.wy.adbook.app.base.QYBaseActivity_MembersInjector;
import com.wy.adbook.mvp.presenter.MyFriendPresenter;
import com.wy.adbook.mvp.view.adapter.MyFriendAdapter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyFriendActivity_MembersInjector implements MembersInjector<MyFriendActivity> {
  private final Provider<MyFriendPresenter> mPresenterProvider;

  private final Provider<MyFriendAdapter> friendAdapterProvider;

  private final Provider<LinearLayoutManager> linearLayoutManagerProvider;

  public MyFriendActivity_MembersInjector(
      Provider<MyFriendPresenter> mPresenterProvider,
      Provider<MyFriendAdapter> friendAdapterProvider,
      Provider<LinearLayoutManager> linearLayoutManagerProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.friendAdapterProvider = friendAdapterProvider;
    this.linearLayoutManagerProvider = linearLayoutManagerProvider;
  }

  public static MembersInjector<MyFriendActivity> create(
      Provider<MyFriendPresenter> mPresenterProvider,
      Provider<MyFriendAdapter> friendAdapterProvider,
      Provider<LinearLayoutManager> linearLayoutManagerProvider) {
    return new MyFriendActivity_MembersInjector(
        mPresenterProvider, friendAdapterProvider, linearLayoutManagerProvider);
  }

  @Override
  public void injectMembers(MyFriendActivity instance) {
    QYBaseActivity_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectFriendAdapter(instance, friendAdapterProvider.get());
    injectLinearLayoutManager(instance, linearLayoutManagerProvider.get());
  }

  public static void injectFriendAdapter(MyFriendActivity instance, MyFriendAdapter friendAdapter) {
    instance.friendAdapter = friendAdapter;
  }

  public static void injectLinearLayoutManager(
      MyFriendActivity instance, LinearLayoutManager linearLayoutManager) {
    instance.linearLayoutManager = linearLayoutManager;
  }
}
