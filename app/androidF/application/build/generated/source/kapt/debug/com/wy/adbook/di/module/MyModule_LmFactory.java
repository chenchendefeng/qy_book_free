package com.wy.adbook.di.module;

import android.support.v7.widget.LinearLayoutManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyModule_LmFactory implements Factory<LinearLayoutManager> {
  private final MyModule module;

  public MyModule_LmFactory(MyModule module) {
    this.module = module;
  }

  @Override
  public LinearLayoutManager get() {
    return Preconditions.checkNotNull(
        module.lm(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static MyModule_LmFactory create(MyModule module) {
    return new MyModule_LmFactory(module);
  }

  public static LinearLayoutManager proxyLm(MyModule instance) {
    return Preconditions.checkNotNull(
        instance.lm(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
