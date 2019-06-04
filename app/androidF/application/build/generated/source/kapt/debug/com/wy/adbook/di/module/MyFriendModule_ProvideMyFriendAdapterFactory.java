package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.FriendItem;
import com.wy.adbook.mvp.view.adapter.MyFriendAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyFriendModule_ProvideMyFriendAdapterFactory
    implements Factory<MyFriendAdapter> {
  private final MyFriendModule module;

  private final Provider<List<FriendItem>> listProvider;

  public MyFriendModule_ProvideMyFriendAdapterFactory(
      MyFriendModule module, Provider<List<FriendItem>> listProvider) {
    this.module = module;
    this.listProvider = listProvider;
  }

  @Override
  public MyFriendAdapter get() {
    return Preconditions.checkNotNull(
        module.provideMyFriendAdapter(listProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MyFriendModule_ProvideMyFriendAdapterFactory create(
      MyFriendModule module, Provider<List<FriendItem>> listProvider) {
    return new MyFriendModule_ProvideMyFriendAdapterFactory(module, listProvider);
  }

  public static MyFriendAdapter proxyProvideMyFriendAdapter(
      MyFriendModule instance, List<FriendItem> list) {
    return Preconditions.checkNotNull(
        instance.provideMyFriendAdapter(list),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
