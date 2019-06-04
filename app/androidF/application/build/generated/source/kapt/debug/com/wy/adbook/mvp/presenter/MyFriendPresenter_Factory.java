package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.MyFriendContract;
import com.wy.adbook.mvp.model.entity.FriendItem;
import com.wy.adbook.mvp.view.adapter.MyFriendAdapter;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyFriendPresenter_Factory implements Factory<MyFriendPresenter> {
  private final Provider<MyFriendContract.Model> modelProvider;

  private final Provider<MyFriendContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  private final Provider<MyFriendAdapter> friendAdapterProvider;

  private final Provider<List<FriendItem>> friendListProvider;

  public MyFriendPresenter_Factory(
      Provider<MyFriendContract.Model> modelProvider,
      Provider<MyFriendContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<MyFriendAdapter> friendAdapterProvider,
      Provider<List<FriendItem>> friendListProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
    this.friendAdapterProvider = friendAdapterProvider;
    this.friendListProvider = friendListProvider;
  }

  @Override
  public MyFriendPresenter get() {
    MyFriendPresenter instance = new MyFriendPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    MyFriendPresenter_MembersInjector.injectFriendAdapter(instance, friendAdapterProvider.get());
    MyFriendPresenter_MembersInjector.injectFriendList(instance, friendListProvider.get());
    return instance;
  }

  public static MyFriendPresenter_Factory create(
      Provider<MyFriendContract.Model> modelProvider,
      Provider<MyFriendContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider,
      Provider<MyFriendAdapter> friendAdapterProvider,
      Provider<List<FriendItem>> friendListProvider) {
    return new MyFriendPresenter_Factory(
        modelProvider,
        viewProvider,
        mErrorHandlerProvider,
        friendAdapterProvider,
        friendListProvider);
  }

  public static MyFriendPresenter newMyFriendPresenter(
      MyFriendContract.Model model, MyFriendContract.View view) {
    return new MyFriendPresenter(model, view);
  }
}
