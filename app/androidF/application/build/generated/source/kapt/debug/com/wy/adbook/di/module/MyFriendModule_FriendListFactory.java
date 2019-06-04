package com.wy.adbook.di.module;

import com.wy.adbook.mvp.model.entity.FriendItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyFriendModule_FriendListFactory implements Factory<List<FriendItem>> {
  private final MyFriendModule module;

  public MyFriendModule_FriendListFactory(MyFriendModule module) {
    this.module = module;
  }

  @Override
  public List<FriendItem> get() {
    return Preconditions.checkNotNull(
        module.friendList(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MyFriendModule_FriendListFactory create(MyFriendModule module) {
    return new MyFriendModule_FriendListFactory(module);
  }

  public static List<FriendItem> proxyFriendList(MyFriendModule instance) {
    return Preconditions.checkNotNull(
        instance.friendList(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
