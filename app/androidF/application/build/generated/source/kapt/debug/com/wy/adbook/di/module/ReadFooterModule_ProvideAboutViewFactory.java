package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.ReadFooterContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReadFooterModule_ProvideAboutViewFactory
    implements Factory<ReadFooterContract.View> {
  private final ReadFooterModule module;

  public ReadFooterModule_ProvideAboutViewFactory(ReadFooterModule module) {
    this.module = module;
  }

  @Override
  public ReadFooterContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ReadFooterModule_ProvideAboutViewFactory create(ReadFooterModule module) {
    return new ReadFooterModule_ProvideAboutViewFactory(module);
  }

  public static ReadFooterContract.View proxyProvideAboutView(ReadFooterModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
