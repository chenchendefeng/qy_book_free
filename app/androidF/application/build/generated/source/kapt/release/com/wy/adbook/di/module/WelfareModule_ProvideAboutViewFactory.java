package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.WelfareContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WelfareModule_ProvideAboutViewFactory implements Factory<WelfareContract.View> {
  private final WelfareModule module;

  public WelfareModule_ProvideAboutViewFactory(WelfareModule module) {
    this.module = module;
  }

  @Override
  public WelfareContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static WelfareModule_ProvideAboutViewFactory create(WelfareModule module) {
    return new WelfareModule_ProvideAboutViewFactory(module);
  }

  public static WelfareContract.View proxyProvideAboutView(WelfareModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
