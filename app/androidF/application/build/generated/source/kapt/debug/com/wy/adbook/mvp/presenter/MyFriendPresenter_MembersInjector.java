package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.model.entity.FriendItem;
import com.wy.adbook.mvp.view.adapter.MyFriendAdapter;
import dagger.MembersInjector;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyFriendPresenter_MembersInjector implements MembersInjector<MyFriendPresenter> {
  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<MyFriendAdapter> friendAdapterProvider;

  private final Provider<List<FriendItem>> friendListProvider;

  public MyFriendPresenter_MembersInjector(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<MyFriendAdapter> friendAdapterProvider,
      Provider<List<FriendItem>> friendListProvider) {
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.friendAdapterProvider = friendAdapterProvider;
    this.friendListProvider = friendListProvider;
  }

  public static MembersInjector<MyFriendPresenter> create(
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<MyFriendAdapter> friendAdapterProvider,
      Provider<List<FriendItem>> friendListProvider) {
    return new MyFriendPresenter_MembersInjector(
        mErrorHandlerProvider, friendAdapterProvider, friendListProvider);
  }

  @Override
  public void injectMembers(MyFriendPresenter instance) {
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    injectFriendAdapter(instance, friendAdapterProvider.get());
    injectFriendList(instance, friendListProvider.get());
  }

  public static void injectFriendAdapter(
      MyFriendPresenter instance, MyFriendAdapter friendAdapter) {
    instance.friendAdapter = friendAdapter;
  }

  public static void injectFriendList(MyFriendPresenter instance, List<FriendItem> friendList) {
    instance.friendList = friendList;
  }
}
