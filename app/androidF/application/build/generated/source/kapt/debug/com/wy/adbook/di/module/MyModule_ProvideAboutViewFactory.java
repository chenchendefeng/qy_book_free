package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.MyContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyModule_ProvideAboutViewFactory implements Factory<MyContract.View> {
  private final MyModule module;

  public MyModule_ProvideAboutViewFactory(MyModule module) {
    this.module = module;
  }

  @Override
  public MyContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MyModule_ProvideAboutViewFactory create(MyModule module) {
    return new MyModule_ProvideAboutViewFactory(module);
  }

  public static MyContract.View proxyProvideAboutView(MyModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
