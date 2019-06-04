package com.wy.adbook.di.module;

import android.support.v7.widget.LinearLayoutManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyFriendModule_LinearLayoutManagerFactory
    implements Factory<LinearLayoutManager> {
  private final MyFriendModule module;

  public MyFriendModule_LinearLayoutManagerFactory(MyFriendModule module) {
    this.module = module;
  }

  @Override
  public LinearLayoutManager get() {
    return Preconditions.checkNotNull(
        module.linearLayoutManager(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MyFriendModule_LinearLayoutManagerFactory create(MyFriendModule module) {
    return new MyFriendModule_LinearLayoutManagerFactory(module);
  }

  public static LinearLayoutManager proxyLinearLayoutManager(MyFriendModule instance) {
    return Preconditions.checkNotNull(
        instance.linearLayoutManager(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
