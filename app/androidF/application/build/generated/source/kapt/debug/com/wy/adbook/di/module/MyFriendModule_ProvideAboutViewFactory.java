package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.MyFriendContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyFriendModule_ProvideAboutViewFactory
    implements Factory<MyFriendContract.View> {
  private final MyFriendModule module;

  public MyFriendModule_ProvideAboutViewFactory(MyFriendModule module) {
    this.module = module;
  }

  @Override
  public MyFriendContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MyFriendModule_ProvideAboutViewFactory create(MyFriendModule module) {
    return new MyFriendModule_ProvideAboutViewFactory(module);
  }

  public static MyFriendContract.View proxyProvideAboutView(MyFriendModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
