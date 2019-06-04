package com.wy.adbook.di.module;

import android.support.v7.widget.LinearLayoutManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReadFooterModule_ProvideLinearLayoutFactory
    implements Factory<LinearLayoutManager> {
  private final ReadFooterModule module;

  public ReadFooterModule_ProvideLinearLayoutFactory(ReadFooterModule module) {
    this.module = module;
  }

  @Override
  public LinearLayoutManager get() {
    return Preconditions.checkNotNull(
        module.provideLinearLayout(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ReadFooterModule_ProvideLinearLayoutFactory create(ReadFooterModule module) {
    return new ReadFooterModule_ProvideLinearLayoutFactory(module);
  }

  public static LinearLayoutManager proxyProvideLinearLayout(ReadFooterModule instance) {
    return Preconditions.checkNotNull(
        instance.provideLinearLayout(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
