package com.wy.adbook.di.module;

import com.wy.adbook.mvp.contranct.HelpCenterContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelpCenterModule_ProvideAboutViewFactory
    implements Factory<HelpCenterContract.View> {
  private final HelpCenterModule module;

  public HelpCenterModule_ProvideAboutViewFactory(HelpCenterModule module) {
    this.module = module;
  }

  @Override
  public HelpCenterContract.View get() {
    return Preconditions.checkNotNull(
        module.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static HelpCenterModule_ProvideAboutViewFactory create(HelpCenterModule module) {
    return new HelpCenterModule_ProvideAboutViewFactory(module);
  }

  public static HelpCenterContract.View proxyProvideAboutView(HelpCenterModule instance) {
    return Preconditions.checkNotNull(
        instance.provideAboutView(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
