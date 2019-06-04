package com.wy.adbook.di.module;

import android.support.v7.widget.LinearLayoutManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BasicInfoModule_LmFactory implements Factory<LinearLayoutManager> {
  private final BasicInfoModule module;

  public BasicInfoModule_LmFactory(BasicInfoModule module) {
    this.module = module;
  }

  @Override
  public LinearLayoutManager get() {
    return Preconditions.checkNotNull(
        module.lm(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static BasicInfoModule_LmFactory create(BasicInfoModule module) {
    return new BasicInfoModule_LmFactory(module);
  }

  public static LinearLayoutManager proxyLm(BasicInfoModule instance) {
    return Preconditions.checkNotNull(
        instance.lm(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
